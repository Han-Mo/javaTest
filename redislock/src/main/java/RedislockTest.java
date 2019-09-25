import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * @author han
 * @Date 2019-08-26 15:25
 **/
public class RedislockTest {
    /**
      *(1)key，我们使用key来当锁，key是唯一的。
     *
     * (2)value，我们传的是“时间+请求号”，通过给value赋值我们在解锁的时候就会传递同样的数据进行解锁。不至于出现不同的服务器对key进行解锁。为什么说，不允许出现不同的服务器对一个key进行解锁？我们后面讲解。
     *
     * (3)nxxx，NX意思为SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作；
     *
     * (4)expx，PX意思是给这个key加一个过期设置，具体时间由第五个参数决定。
     *
     * (5)time，代表key的过期时间，单位毫秒。
      *
      * @author han
      * @date 15:38 2019-08-26
      * @param jedis
      * @param key
     * @param val
     * @param expireTime
      * @return boolean
    */
    public void redisLockAndDaemonThread(final Jedis jedis, String key, String val, int expireTime){
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        try{
            String response = jedis.set(key, val, "NX", "PX", expireTime);
            if(!"OK".equals(response)){
                return;
            }
            //开启守护线程：
            final int tmpExpireTime = expireTime;
            final String tmpKey = key;
            Thread thread = new Thread(new Runnable(){
                public void run() {
                    for(;;){
                        jedis.expire(tmpKey,tmpExpireTime);
                        try {
                            Thread.sleep(tmpExpireTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
            //.....执行业务逻辑
        }catch (Exception e){

        }finally {
            jedis.eval(luaScript,Arrays.asList(key),Arrays.asList(val));
        }
    }

    public boolean setLock(Jedis jedis,String key,String val,int expireTime){
        String response = jedis.set(key, val, "NX", "PX",
                expireTime);
        return "OK".equals(response);
    }

    public void deleteLock(Jedis jedis, String key, String value){
        if (value.equals(jedis.get(key))) {
            jedis.del(key);
        }
    }

}

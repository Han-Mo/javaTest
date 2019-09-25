import java.util.concurrent.FutureTask;

/**
 * @author han
 * @Date 2019-08-16 08:55
 **/
public class StringTest {
    public static void main(String[] args) {

        String testA = new String("abc");
        System.out.println("a:  "+System.identityHashCode(testA));
        String testB = add(testA);
        System.out.println("a:  "+System.identityHashCode(testA));
        System.out.println("b:  "+System.identityHashCode(testB));
        testA = "qwer";
        System.out.println("a:  "+System.identityHashCode(testA));
        testA = "qwer"+"asd";
        System.out.println("a:  "+System.identityHashCode(testA));
        System.out.println("====================================");
        StringBuilder sb=new StringBuilder("aaa");
        System.out.println("sb:  "+System.identityHashCode(sb));
        StringBuilder ns = StringTest.appendStr(sb);
        System.out.println("sb:  "+System.identityHashCode(sb));
        System.out.println("ns:  "+System.identityHashCode(ns));
    }

    public static String  add(String a){
        //String b = a + "defg";
        return a + "defg";
    }

    public static StringBuilder appendStr(StringBuilder sb){
        return sb.append("bbb");
    }
}

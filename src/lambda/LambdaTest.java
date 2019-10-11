package lambda;

import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author han
 * @date 2019-10-10 16:37
 **/
public class LambdaTest {
    public static void main(String[] args) {
        //#####################################
        new Thread(
                () -> System.out.println("just test")
        ).start();
        //#####################################
        System.out.println("#######################################");
        List<String> list = Arrays.asList("I", "love", "you", "too");
        Collections.sort(list, (s1, s2) -> {
            if (s1 == null) {
                return -1;
            }

            if (s2 == null) {
                return 1;
            }

            return s1.length() - s2.length();
        });
        //#####################################
        System.out.println("#######################################");
        // Lambda表达式的书写形式
        Runnable run = () -> System.out.println("Hello World");// 1
        ActionListener listener = event -> System.out.println("button clicked");// 2
        Runnable multiLine = () -> {// 3 代码块
            System.out.print("Hello");
            System.out.println(" Hoolee");
        };

        BinaryOperator<Long> add = (Long x, Long y) -> x + y;// 4
        BinaryOperator<Long> addImplicit = (x, y) -> x + y;// 5 类型推断

        //#####################################
        System.out.println("#######################################");
        // 使用forEach()结合Lambda表达式迭代
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list1.forEach(
                str -> {
                    if (str.length() > 3) {
                        System.out.println(str);
                    }
                }
        );
        //#####################################
        System.out.println("#######################################");
        // 使用removeIf()结合Lambda表达式实现
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list2.removeIf(str -> str.length() > 3); // 删除长度大于3的元素
        //#####################################
        System.out.println("#######################################");
        // 使用Lambda表达式实现
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list3.replaceAll(str -> {
            if (str.length() > 3) {
                return str.toUpperCase();
            }
            return str;
        });
        //#####################################
        System.out.println("#######################################");
        // List.sort()方法结合Lambda表达式
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list4.sort((str1, str2) -> str1.length()-str2.length());
        //#####################################
        System.out.println("#######################################");
        // 使用forEach()结合Lambda表达式迭代Map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach((k, v) -> System.out.println(k + "=" + v));
        //#####################################
        System.out.println("#######################################");
        // 查询Map中指定的值，不存在时使用默认值
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "one");
        map1.put(2, "two");
        map1.put(3, "three");

        // Java7以及之前做法
        if(map1.containsKey(4)){ // 1
            System.out.println(map1.get(4));
        }else{
            System.out.println("NoValue");
        }
        // Java8使用Map.getOrDefault()
        System.out.println(map1.getOrDefault(4, "NoValue")); // 2
        //#####################################
        System.out.println("#######################################");
        // Java7以及之前替换所有Map中所有映射关系
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "one");
        map2.put(2, "two");
        map2.put(3, "three");
        for(Map.Entry<Integer, String> entry : map2.entrySet()){
            entry.setValue(entry.getValue().toUpperCase());
        }

        // 使用replaceAll()结合Lambda表达式实现
        HashMap<Integer, String> map3 = new HashMap<>();
        map3.put(1, "one");
        map3.put(2, "two");
        map3.put(3, "three");
        map3.replaceAll((k, v) -> v.toUpperCase());
        //#####################################
        System.out.println("#######################################");
        // 使用Stream.forEach()迭代
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(str -> System.out.println(str));

        //#####################################
        System.out.println("#######################################");
        Stream<String> stream2= Stream.of("I", "love", "you", "too");
        stream2.sorted((str1, str2) -> str1.length()-str2.length())
                .forEach(str -> System.out.println(str));
        //#####################################
        System.out.println("#######################################");
        Stream<String> stream3 = Stream.of("I", "love", "you", "too");
        stream3.map(str -> str.toUpperCase())
                .forEach(str -> System.out.println(str));
        //#####################################
        System.out.println("#######################################");
        Stream<List<Integer>> stream4 = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream4.filter(List.class::isInstance).flatMap(x -> x.stream())
                .forEach(i -> System.out.println(i));
    }
}

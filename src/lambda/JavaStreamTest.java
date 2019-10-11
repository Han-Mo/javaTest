package lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author han
 * @date 2019-10-11 10:08
 **/
public class JavaStreamTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = stringList.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        filtered.forEach(s -> {
            System.out.println(s);
        });
        //##########################
        System.out.println("#######################################");
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        //##########################
        System.out.println("#######################################");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(s -> {
            System.out.println(s);
        });
        //##########################
        System.out.println("#######################################");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println((int) count);
        //##########################
        System.out.println("#######################################");
        Random random1 = new Random();
        random1.ints().limit(10).sorted().forEach(System.out::println);
        //##########################
        System.out.println("#######################################");
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        int count1 = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count1);
        //##########################
        System.out.println("#######################################");
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered2 = strings2.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        //##########################
        System.out.println("#######################################");
        List<Integer> numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = numbers1.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + statistics.getMax());
        System.out.println("列表中最小的数 : " + statistics.getMin());
        System.out.println("所有数之和 : " + statistics.getSum());
        System.out.println("平均数 : " + statistics.getAverage());
        //##########################
        System.out.println("#######################################");
        List<String> strings3 = Arrays.asList("I", "love", "you", "too");
        Optional<String> optional = strings3.stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println(optional.get());
        //##########################
        System.out.println("#######################################");
        List<String> strings4 = Arrays.asList("I", "love", "you", "too");
        Integer lengthSum = strings4.parallelStream().reduce(
                0,// 初始值　// (1)
                (sum, str) -> sum + str.length(), // 累加器 // (2)
                (a, b) -> a + b);// 部分和拼接器，并行执行时才会用到 // (3)
        System.out.println(lengthSum);
        //##########################
        System.out.println("#######################################");
        List<Student> students = (new JavaStreamTest()).getStudents();
        HashMap<String, Integer> maps = (HashMap<String, Integer>) students.stream().collect(Collectors.toMap(
                s -> s.getName(),// 如何生成key  相当于 t -> t
                s -> s.getScort() + 10// 如何生成value  相当于 t -> t
                )
        );
        System.out.println(maps);
        //##########################
        System.out.println("#######################################");
        List<Student> students1 = (new JavaStreamTest()).getStudents();
        Map<Boolean, List<Student>> maps1 = students1.stream().collect(Collectors.partitioningBy(s -> s.getScort() > 50));
        System.out.println(maps1);
        //##########################
        System.out.println("#######################################");
        List<Student> students2 = (new JavaStreamTest()).getStudents();
        Map<Integer, List<Student>> maps2 = students2.stream().collect(Collectors.groupingBy(Student::getSex));
        System.out.println(maps2);
        //##########################
        System.out.println("#######################################");
        // 使用下游收集器统计每个部门的人数
        List<Student> students3 = (new JavaStreamTest()).getStudents();
        Map<Integer, Long> maps3 = students3.stream().collect(
                Collectors.groupingBy(Student::getSex, Collectors.counting())

        );
        System.out.println(maps3);
        //##########################
        System.out.println("#######################################");
        List<Student> students4 = (new JavaStreamTest()).getStudents();
        Map<Integer, List<String>> map4 = students4.stream().collect(
                Collectors.groupingBy(
                        Student::getSex,
                        Collectors.mapping(
                                s -> s.getName(),
                                Collectors.toList()
                        )
                )
        );
        System.out.println(map4);
        //##########################
        System.out.println("#######################################");
        List<String> strings5 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        String string5 = strings5
                .stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(",", "{", "}"));//"{I,love,you}"
        System.out.println(string5);
        //##########################
        System.out.println("#######################################");
        List<String> strings6 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        OptionalInt maxLength = strings6.stream()
                .filter(s -> s.startsWith("a"))
                .mapToInt(String::length)
                .max();
        System.out.println(maxLength.getAsInt());






    }

    class Student implements Cloneable {
        String name;
        Integer scort;
        Integer sex;

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScort() {
            return scort;
        }

        public void setScort(Integer scort) {
            this.scort = scort;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (Student) super.clone();
        }

    }

    public List getStudents() {
        List<Student> students = new ArrayList<>(10);
        Student student = new Student();
        List<String> names = Arrays.asList("Marguerite", "Wilder", "Jenelle", "Brigitte", "Guinevere", "Johnson", "Love", "Adriano", "Adria", "Kirby", "Shelly");
        try {
            for (int i = 0; i < 10; i++) {
                Student student1 = (Student) student.clone();
                student1.setName(names.get(i));
                student1.setScort((int) (Math.random() * 100));
                student1.setSex(Math.random() > 0.5 ? 1 : 0);
                students.add(student1);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return students;
    }

}

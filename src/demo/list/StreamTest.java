package demo.list;

import entity.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    static void initialize(){
        IntStream.of(1,2,3).forEach(System.out::println);
        IntStream.range(10, 13).forEach(System.out::println);
        IntStream.rangeClosed(20, 23).forEach(System.out::println);
    }

    static void distictTest(){
        List<Integer> list = Arrays.asList(1,1,2,2,4,3,5,6,6,7,3,3,1,3,4);
        list.stream().forEach(System.out::print);
        System.out.println();
        list.stream().distinct().forEach(System.out::print);
    }
    static void order(){
        User user1 = User.builder().name("one").age(1).build();
        User user2 = User.builder().name("two").age(2).build();
        User user3_1 = User.builder().name("three_1").age(3).build();
        User user3_2 = User.builder().name("three_2").age(3).build();
        User user5 = User.builder().name("five").age(5).build();
        List<User> userList = Arrays.asList(user1, user3_1, user5, user3_2, user2);
        userList.stream().sorted((Comparator.comparing(User::getAge, Comparator.reverseOrder()).
                thenComparing(User::getName, Comparator.reverseOrder()))).
                collect(Collectors.toList()).forEach(System.out::println);

    }
    static void sum(){
        User user1 = User.builder().name("one").age(1).build();
        User user2 = User.builder().name("two").age(2).build();
        User user3_1 = User.builder().name("three_1").age(3).build();
        User user3_2 = User.builder().name("three_2").age(3).build();
        User user5 = User.builder().name("five").age(5).build();
        List<User> userList = Arrays.asList(user1, user3_1, user5, user3_2, user2);
        Integer count = userList.stream().mapToInt(User::getAge).sum();
        System.out.println(count);
    }

    /**
     * 返回的value是list用groupingBy
     */
    static void generateMap1(){
        User user1 = User.builder().name("one").age(1).build();
        User user2 = User.builder().name("two").age(2).build();
        User user3_1 = User.builder().name("three_1").age(3).build();
        User user3_2 = User.builder().name("three_2").age(3).build();
        User user5 = User.builder().name("five").age(5).build();
        List<User> userList = Arrays.asList(user1, user3_1, user5, user3_2, user2);
        //key -> id : value -> List<Object>
        Map<Integer, List<User>> userMap = userList.stream().collect(Collectors.groupingBy(User::getAge));
        userMap.forEach((integer, users) -> System.out.println(users));
        System.out.println("----------");
        //key -> id : value -> List<Object.value>
        Map<Integer, List<String>> userMap1 = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
        userMap1.forEach((integer, users) -> System.out.println(users));
        System.out.println("----------");
        //key -> id : value -> Object数目
        Map<Integer, Long> userMap2 = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        userMap2.forEach((integer, users) -> System.out.println(users));
        System.out.println("----------");
        //key -> id : value -> Object属性值的sum
        Map<Integer, Integer> userMap3 = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.summingInt(User::getAge)));
        userMap3.forEach((integer, users) -> System.out.println(users));
    }

    /**
     * 返回的value是单个数用toMap
     * Function.identify = t -> t
     *
     */
    static void generateMap2(){
        User user1 = User.builder().name("one").age(1).build();
        User user2 = User.builder().name("two").age(2).build();
        User user3_1 = User.builder().name("three_1").age(3).build();
        User user3_2 = User.builder().name("three_2").age(3).build();
        User user5 = User.builder().name("five").age(5).build();
        List<User> userList = Arrays.asList(user1, user3_1, user5, user3_2, user2);
        Map<Integer, String> userMap1 = userList.stream().collect(Collectors.toMap(User::getAge, User::getName, (a, b) -> a));
        Map<Integer, String> userMap2 = userList.stream().collect(Collectors.toMap(User::getAge, User::getName, (a, b) -> b));
        Map<Integer, User> userMap3 = userList.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (a, b) -> b));
        Map<Integer, User> userMap4 = userList.stream().collect(Collectors.toMap(User::getAge, t -> t, (a, b) -> b));
        userMap1.forEach((integer, users) -> System.out.println(integer + " : "+ users));
        System.out.println("----------");
        userMap2.forEach((integer, users) -> System.out.println(integer + " : "+ users));
        System.out.println("----------");
        userMap3.forEach((integer, users) -> System.out.println(integer + " : "+ users));
        System.out.println("----------");
        userMap4.forEach((integer, users) -> System.out.println(integer + " : "+ users));
    }

    static void filterTest() {

        User user1 = User.builder().name("one").age(1).build();
        User user2 = User.builder().name("two").age(2).build();
        User user3_1 = User.builder().name("three_1").age(3).build();
        User user3_2 = User.builder().name("three_2").age(3).build();
        User user5 = User.builder().name("five").age(5).build();
        List<User> userList = Arrays.asList(user1, user3_1, user5, user3_2, user2);
        userList.stream().filter(item -> true).collect(Collectors.toList()).forEach(System.out::println);
        userList.stream().filter(distinctByKey(User::getAge)).collect(Collectors.toList()).forEach(System.out::println);
    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }




    public static void main(String[] args) {
        //initialize();
        //order();
        //sum();
        //generateMap1();
        //generateMap2();
        //filterTest();
        distictTest();
    }

}

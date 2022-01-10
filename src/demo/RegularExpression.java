package demo;

import entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularExpression {

    public static void RegularExpressionMatch(){
        System.out.println("-------0");
//        Pattern pattern = Pattern.compile("^[0-9]]");
//        String[] str = pattern.split("我的电话是123我的邮箱是789");
//        for (String s: str) {
//            System.out.println(s);
//        }
        System.out.println(Pattern.matches("[0-9]{3}\\.[0-9]+\\.[0-9]+", "127.000.123"));
    }

    public static void StreamTest(){

        Integer[] integerArray = {1,2,3,4,5};
        List<Integer> integerList = Arrays.asList(integerArray);
        List<Integer> sumList1 = integerList.stream().map(n->n+n).collect(Collectors.toList());
        //map(n->n)等于忽略map
        sumList1.forEach(System.out::println);
//        List<Integer> sumList2 = integerList.stream().collect(Collectors.toList());
//        List<Integer> sumList3 = integerList.stream().map(Function.identity()).collect(Collectors.toList());
//        sumList2.forEach(System.out::println);
//        sumList3.forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>list转map<<<<<<<<<<<<<<<<<");
        List<User> userList = new ArrayList<>();
        userList.add(new User("zhangsan", 12));
        userList.add((new User("lisi", 13)));
        userList.add((new User("wanger", 14)));
        userList.add((new User("tiezhu", 12)));
        userList.add((new User("meihua", 13)));
        Map<Integer, List<User>> newsimap = userList.stream().collect(Collectors.groupingBy(User::getAge));
        newsimap.entrySet().forEach(t -> System.out.println("key="+t.getKey() +" + value="+t.getValue()));




    }

    public static  void testPrint(){
        System.out.println("ss\n\tssss");
    }

    public static void main(String[] args){
        testPrint();
        //RegularExpressionMatch();
        //StreamTest();
    }
}

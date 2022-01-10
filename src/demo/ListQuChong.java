package demo;

import entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class ListQuChong {

    /**
     * 由list转set在转回list
     */
    public static void method1() {
        List<Integer> numList = new ArrayList(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8));
        System.out.println(numList);
        Set<Integer> numSet = new HashSet<>(numList);
        List<Integer> newNumList = new ArrayList<>(numSet);
        System.out.println(newNumList);
    }

    /**
     * 用stream的distinct()
     */
    public static void method2() {
        List<Integer> numList = new ArrayList(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8));
        System.out.println(numList);
        List<Integer> newNumList = numList.stream().distinct().collect(Collectors.toList());
        System.out.println(newNumList);
    }

    /**
     * 对单个对象根据对象的属性去重
     */
    public static void method3() {
        User u1 = new User("john", 12);
        User u2 = new User("john", 22);
        User u3 = new User("martin", 12);
        User u4 = new User("clyde", 15);
        List<User> users = new ArrayList(Arrays.asList(u1, u2, u3, u4));
        System.out.println(users);
        List<User> newUsers = users.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new));
        //List<User> newUsers = users.stream().distinct().collect(Collectors.toList());
        System.out.println(newUsers);
    }

    /**
     * 根据set不能重复加的特性一个一个检查元素是否重复
     */
    public static void method4(){
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,5,5,6));
        System.out.println(numList);
        Set<Integer> numSet = new HashSet<>();
        List<Integer> newNumList= new ArrayList<>();
        for (Integer i: numList
             ) {
            if(numSet.add(i)){
                newNumList.add(i);
            }
        }
        System.out.println(newNumList);
    }

    /**
     * 根据list.contains()方法一个一个检查元素是否重复
     */
    public static void method5(){
        List<Integer> numList = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,5,5,6));
        System.out.println(numList);
        List<Integer> newNumList= new ArrayList<>();
        for (Integer i: numList
             ) {
            if(!newNumList.contains(i)){
                newNumList.add(i);
            }
        }
        System.out.println(newNumList);
    }

    public static void main(String[] args) {
        //method1();
        //method2();
        method3();
        //method4();
        //method5();
    }


}

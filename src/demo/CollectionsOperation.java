package demo;

import entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsOperation {

    public static void addListIntoSet() {
        Set<Integer> integerSet = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(10, 10, 11, 12, 12));
        map.put(1, list1);
        map.put(2, list2);
        map.put(3, list3);
        map.put(4, list4);
        map.forEach((k, v) -> {
            List<Integer> finalList = null;
            finalList = v.stream().distinct().collect(Collectors.toList());
            finalList.stream().forEach(System.out::println);
        });

    }

    public static void emptyListTest() {
        List<Integer> integers = Collections.EMPTY_LIST;
        List<Integer> integerList = Collections.emptyList();
        //empty list始终不为null，所以省去了后续判断是不是null这一步
        System.out.println(integers == null);
        //empty list不能add，因为add会报错
//        System.out.println(integers.add(1));
    }

    public static void main(String[] args) {

        //addListIntoSet();
        emptyListTest();
    }
}

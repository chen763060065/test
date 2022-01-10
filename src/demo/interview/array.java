package demo.interview;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class array {

    static void arrayToList(){
        //Object类型
        // array->list
        String[] sArray = {"a","b", "c"};
        List<String> sList = Arrays.asList(sArray);
        List<String> sList1 = Arrays.stream(sArray).collect(Collectors.toList());
        //list->array
        List<String> sList2 = new ArrayList<>();
        sList2.add("a");sList2.add("v");sList2.add("dfd");
        String[] sArray2 =sList2.toArray(new String[sList2.size()]);
        //基本数据类型
        // array -> list
        int[] iArray = {1,2,3};
        List<Integer> iList = Arrays.stream(iArray).boxed().collect(Collectors.toList());
        // list -> array
        List<Integer> iList1 = new ArrayList<>();
        iList.add(1);iList.add(2);iList.add(3);
        Integer[] iArray1 = iList1.toArray(new Integer[iList.size()]);
        int[] iArray2 = iList1.stream().mapToInt(Integer::valueOf).toArray();
    }
    static void listToSet(){
        List<String>sList = new ArrayList<>();
        sList.add("a");sList.add("b");sList.add("c");
        //set和list都是Collection所以可以直接转换
        Set<String> sSet = new HashSet<>(sList);
        List<String> sList1 = new ArrayList<>(sSet);
    }
    static void arrayToSet(){

        String[] sArray = {"a","b","c"};
        Set<String> sSet = new HashSet<>(Arrays.asList(sArray));
    }
    static void arrayTest(){
        int[] array = new int[3];
        int[] array1 = {1,2,3,7,5,3,1};
        Arrays.sort(array1);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]);
        }
        String s = "eeee";
        System.out.println(s.length());
    }
    static void hashMapTest(){
        Map<Integer, String> map = new HashMap<>();
        map.put(3,"3");
        map.put(1,"1");
        map.put(2,"2");
        map.put(5,"2");
        map.put(6,null);
        map.put(null, null);
        map.remove(5);
        //迭代
        for(Integer i: map.keySet()){
            System.out.println(i);
        }
        for(String s: map.values()){
            System.out.println(s);
        }
        System.out.println(map.containsKey(5));
        System.out.println(map.containsValue("3"));
        map.forEach((k, v) -> System.out.println(k+v));
        Set<Map.Entry<Integer, String>> entry =  map.entrySet();
        for(Map.Entry<Integer, String> e: entry){
            System.out.println(e);
        }

    }
    static void arrayTest1(){
        Integer[] integers = {1,2,34,4,5,2,1,1};
//        Arrays.sort(integers);
//        Arrays.stream(integers).forEach(System.out::println);
        List<Integer> integerList= Arrays.asList(integers);
        for (Integer i: integerList
             ) {
            System.out.print(i);
        }
        System.out.println();
        integerList.stream().sorted(Comparator.reverseOrder());
        for (Integer i: integerList
        ) {
            System.out.print(i);
        }
        System.out.println();

    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int n = nums.length;
        int[] dp = new int[n]; //存的是到这个元素时的数组最大和
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;

    }
    public static boolean isSymmetry(int num) {
        //转变为一个字符串，然后看这个字符串是不是回文字符串
        String output =  String.valueOf(Math.abs(num));
        for(int i = 0; i < output.length()/2; i++){
            if(output.charAt(i)!=output.charAt(output.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //hashMapTest();
        arrayTest1();
    }

}

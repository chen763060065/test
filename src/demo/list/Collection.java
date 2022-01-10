package demo.list;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {

    static void initializeList(){
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List list2 = Arrays.asList(1,2,3);
        list1.add(4);
        System.out.println(list1);
        //list2.add(4);  -->Arrays.asList()创建的List不能加减。
        System.out.println(list2);
    }

    static void initializeArray(){
        Integer[][] array1 = {{1,2},{3,4}};
        Integer[] array2 = new Integer[3];
        array2[0] = 1;
        array2[1] = 2;
        array2[2] = 3;
        Arrays.stream(array1).forEach(i -> Arrays.stream(i).forEach(System.out::print));
        System.out.println();
        Arrays.stream(array2).forEach(System.out::print);
        System.out.println();
    }

    static void listToArray(){
        List list = Arrays.asList(1,2,3);
        Integer[] array = (Integer[]) list.toArray();
        Arrays.stream(array).forEach(System.out::print);
    }
    static void arrayToList(){
        Integer[] array = {1,2,3};
        List list = Arrays.asList(array);
        System.out.println();
        System.out.println(list);
    }

    public static List<Integer> getList(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(null);
        }
        System.out.println(list.size());
        System.out.println(list);
        return list;
    }


    public static void main(String[] args) {
        //initializeList();
        //initializeArray();
        //listToArray();
        //arrayToList();
        getList();

    }


}

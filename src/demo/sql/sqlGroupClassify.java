package demo.sql;

import java.util.Arrays;
import java.util.List;

public class sqlGroupClassify {


    public static void test(String s){
        List<String> stringList = Arrays.asList(s.split("\n"));
        String returnList = null;
        for(String ss: stringList){
            returnList="INSERT ks_group_classify_relation (classify_id, group_id) VALUES (5,"+ss+");";
            System.out.println(returnList);
        }
    }

    public static void main(String[] args) {
        //test("20\n" +
//                "90\n" +
//                "21\n" +
//                "95\n" +
//                "16\n" +
//                "18\n" +
//                "85\n" +
//                "108\n" +
//                "110\n" +
//                "111\n" +
//                "112\n");

        List<String> list = null;
        String s = list.get(0);
        System.out.println(s);
    }
}

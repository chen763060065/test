package demo.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class listTest {

    public static void initLine(List<String> peopleList){
        Line line = new Line(peopleList);
        System.out.println(line.toString());
    }

    public static void initLine(String peoples){
        List<String> peopleList = Arrays.asList(peoples.split("\\|"));
        Line line = new Line(peopleList);
        System.out.println(line.toString());
        System.out.println(peopleList);
    }

    public static void listStream(String string){
        List<String> list1 = Arrays.asList(string.split("\\|"));
        System.out.println(list1);
        List<String> strings = Arrays.asList(string.split("\\|")).
                stream().filter(s -> !"".equals(s)).collect(Collectors.toList());
        System.out.println(strings);
    }

    public static void main(String[] args) {
        //initLine(Arrays.asList("a","b","c"));
        //initLine("a|b|c|");
        listStream("|a|b|c|");
    }
}

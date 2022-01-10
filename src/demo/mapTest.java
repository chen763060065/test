package demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class mapTest {

    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        System.out.println(stringIntegerMap == null);
        System.out.println(stringIntegerMap.get("ee"));
    }
}

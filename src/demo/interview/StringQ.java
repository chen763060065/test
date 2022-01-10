package demo.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringQ {

    public static int lengthOfLongestSubstring1(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char head = s.charAt(i);
            List<Character> cList = new ArrayList<>();
            cList.add(head);
            for(int j = i+1; j<s.length(); j++){
                char tmp = s.charAt(j);
                if(!cList.contains(tmp)){
                    cList.add(tmp);
                }else{
                    break;
                }
            }
            max = Math.max(max, cList.size());
        }
        return max;
    }
    public static int lengthOfLongestSubstring2(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int max = 0;
        int right = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<s.length()){
            char c = s.charAt(right);
            if(map.keySet().contains(c)){
                left = Math.max(left, map.get(c));
            }
            map.put(c, right);
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));

    }
}

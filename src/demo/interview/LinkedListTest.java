package demo.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LinkedListTest {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put('{', 2);
        map.put('[', 3);
        map.put(')', -1);
        map.put('}', -2);
        map.put(']', -3);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty() || map.get(stack.peek())+map.get(c)!=0){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isValid("}"));
    }
}

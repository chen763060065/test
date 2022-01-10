package demo;

public class StringTest {

    public static void test1(){
        String s = "12ndb4";
        int a= s.indexOf("3");
        System.out.println(a); //-1
        //字符串->char数组转换
        char[] charArray = s.toCharArray();
        //char数组->字符串转换
        String new_s = new String(charArray);
        //字符串->String数组转换
        String[] sArray = s.split("");
        //字符串->Integer类型转换
        String s1 = "122a3";
        Integer i = Integer.valueOf(s1);
        Integer ii = Integer.parseInt(s1);
        System.out.println(ii);
        //Integer->字符串类型转换
        int i1 = 333;
        String s2 = String.valueOf(333);
    }

    public static void test2(){
        String s = "abneifeg";
        String s1 = s.replace("ab", "4");
        System.out.println(s1);
        System.out.println(s1.contains("ei"));
    }



    public static void main(String[] args) {
        test2();
    }
}

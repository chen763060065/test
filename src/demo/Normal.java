package demo;

import com.sun.media.jfxmediaimpl.HostUtils;

import javax.management.RuntimeMBeanException;
import java.io.IOException;
import java.util.Arrays;

public class Normal {
    public static void sameObject(){
        Integer[] a = {1,2,3};
        Integer[] b = a;
        Integer integer = b[0];
        b[0]= 100;
        for (Integer i: a
        ) {
            System.out.println(i);
        }
        System.out.println(integer);
    }
    public static void yiWei(){
        System.out.println(4<<1);//8
        System.out.println(4>>2);//1
        System.out.println(11>>2);//2
        System.out.println(-11>>2);//-3
        System.out.println(11>>>2);//2
        System.out.println(-11>>>2);//1073741821
    }


    public static void test1(){
        System.out.println("null".contains("null"));
    }


    public static void test2(){
        try{
            for (int i = 0; i < 30; i++) {
                compute(i);
            }
        }catch (Exception e){
            System.out.println("外面爆的异常");
        }

    }

    public static void compute(int i){
        try{
            if(i==25){
                int a = 10/0;
            }
            System.out.println(i);
        }catch (Throwable e){
            System.out.println("里面爆异常");
        }
    }

    public static void compute(){
        System.out.println(0x01 & 0x08);
    }

    public static void stringEqual(){
        String a = "About";
        System.out.println("about");
    }

    public static void test3(){
        try{
            errorOccur(1);
        }catch (Exception e){
            System.out.println("捕获");
        }
    }

    public static void errorOccur(int i) throws IOException {
        //int a = 10/0;
        if(i == 1){
            throw new IOException("broken pipe");
        }
    }



    public static void main(String[] args) {
        //sameObject();
        //yiWei();
        //test1();
        //test2();
        //compute();
        //stringEqual();
        //test3();
    }


}

package demo;

public class ClassLoad {

    public static void main(String[] args) {
        System.out.println(SubClass.a);
        SubClass[] array = new SubClass[3];
        System.out.println(SubClass.b);
        System.out.println(SubClass.c);
    }
}
class SuperClass{
    static{
        System.out.println("superclass加载");
    }
    public static int a = 100;
}
class SubClass extends SuperClass{
    static{
        System.out.println("subclass加载");
    }
    public static final int b = 1000;
    public static int c = 1000;
}
/*output:
    superclass加载
    100
    1000
    subclass加载
    1000*/

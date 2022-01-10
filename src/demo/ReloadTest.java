package demo;

public class ReloadTest {

    public static void main(String[] args) {
        Parent p = new Son();
        p.sayHello();
    }
}
class Parent{

    public void sayHello(){
        System.out.println("father say hello");
    }
}
class Son extends Parent{

}

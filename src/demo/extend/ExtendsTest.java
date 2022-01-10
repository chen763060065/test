package demo.extend;

public class ExtendsTest {

    //入参是父类，传入子类是->不报错
    public static String fatherInSonIn(Father father){
        if(Son1.class.isInstance(father)){
            System.out.println("传入的是son");
        }
        else if(Father.class.isInstance(father)){
            System.out.println("传入的是father");
        }
        return father.toString();
    }

    public static void getFatherInSonIn(){
        Son1 son1 = new Son1("li","mei");
        Father father = new Father("ai");
        System.out.println(fatherInSonIn(son1));
    }

    public static String sonInFatherIn(Son1 son1){
        return son1.toString();
    }

    //入参是子类，传入是父类->报错 父类向下转型后->不报错
    public static void getSonInFatherIn(){
        Father father = new Father("xing");
        Father father1 = new Son1("xing", "tian");
        //Son1 son = (Son1)father1;
        System.out.println(sonInFatherIn((Son1)father1));
    }

    //返回类型是父类，返回一个子类 ->不报错
    public static Father fatherOutSonOut(){
        Son1 son1 = new Son1("ma", "dongmei");
        Father father = new Son1("cao", "cao");
        //return father;
        return son1;
    }

    public static void getFatherOutSonOut(){
        System.out.println(fatherOutSonOut().toString());
    }

    //返回类型是子类，返回一个父类 ->报错
/*    public static Son1 son1OutFatherOut(){
        Father father = new Father("aa");
        return father;
    }*/

    //子类向上转型后不能用子类的构造方法
    public static Father fatherUseSon(){
//        Son1 son1 = new Son1();
//        son1.setLastName("dong");
//        son1.setFirstName("mei");
//        return son1;
        Father father = new Son1();
        father.setLastName("ma");
        ((Son1)father).setFirstName("dongmei");
        return father;
    }

    public static void getFatherUseSon(){
        System.out.println(fatherUseSon().toString());
    }
    public static void main(String[] args) {
        getFatherInSonIn();
        //getSonInFatherIn();
        //getFatherOutSonOut();
        //getFatherUseSon();
    }
}

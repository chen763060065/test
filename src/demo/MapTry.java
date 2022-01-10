package demo;

public class MapTry {

    public void devide(){
        int a = 10/0;
    }
    public void layer1(){
        System.out.println("layer1");
        try{
            devide();
        }catch (Exception e){
            System.out.println("catch");
            throw e;
        }

    }
    public void layer2(){
        System.out.println("layer2");
        layer1();
    }

    public static void main(String[] args) {
        MapTry mapTry = new MapTry();
        mapTry.layer2();
    }
}

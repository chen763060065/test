import lombok.extern.slf4j.Slf4j;

public class Cuowu {

    //只补捕获异常不抛出不会停止forloop
    public static void tryCatch() throws Exception {
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i==5){
                    try{
                        int[] a = {1,2,3};
                        int b = a[3];
                        int x = 10/0;

                    }catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("message: "+e.getMessage());
                        System.out.println("string: "+e.toString());
                        throw e;
                    }
                }
            }
        }catch (Throwable e){
            e.printStackTrace();
        }

    }




    public static void main(String[] args) throws Exception {
        tryCatch();
    }
}

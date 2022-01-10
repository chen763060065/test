package demo.thread;

import java.util.concurrent.*;

public class threadTest {

    public static void test1() throws InterruptedException, ExecutionException, TimeoutException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum++;
                }
                System.out.println(sum);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 200;
                for (int i = 0; i < 100; i++) {
                    sum++;
                }
                System.out.println(sum);
            }
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("---------");
        R3 r3 = new R3();
        Thread t3 = new Thread(r3);
        t3.start();
        T4 t4 = new T4();
        t4.start();
        C5 c5 = new C5();
        FutureTask f5 = new FutureTask(c5);
        Thread t5 = new Thread(f5);
        t5.start();
        System.out.println(f5.get());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        test1();
    }
}

class R3 implements Runnable{

    @Override
    public void run() {
        System.out.println(333);
    }
}

class T4 extends Thread{

    @Override
    public void run(){
        System.out.println(444);
    }
}

class C5 implements Callable{

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum++;
        }
        Thread.sleep(3000L);
        System.out.println(555);
        return "中国女拳一拳伤害："+sum+"万";
    }
}

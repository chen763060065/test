package demo.interview;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        ex.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println();
    }
}


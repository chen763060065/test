package demo.thread;

import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class testFuture {

    public static void test1(){

        CompletableFuture completableFutureOne = new CompletableFuture<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            try {
                Thread.sleep(3000L);
                completableFutureOne.complete("one执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void test2() throws Exception {
        // 创建异步执行任务，有返回值
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
                return 1.2;
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成
        //主线程休眠等待子线程执行完成，子线程执行完成后唤醒主线程
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    public static void test3() throws Exception {
        // 创建异步执行任务，无返回值
        CompletableFuture cf = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread()+" start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            if(false){
                throw new RuntimeException("test");
            }else{
                System.out.println(Thread.currentThread()+" exit,time->"+System.currentTimeMillis());
            }
        });
        System.out.println("main thread start,time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

    public static void test4() throws Exception {
        ForkJoinPool pool=new ForkJoinPool();
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread()+" start job1,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job1,time->"+System.currentTimeMillis());
            return 1.2;
        }, pool);
        //cf关联的异步任务的返回值作为方法入参，传入到thenApply的方法中
        //thenApply这里实际创建了一个新的CompletableFuture实例
        CompletableFuture<String> cf2=cf.thenApply((result)->{
            System.out.println(Thread.currentThread()+" start job2,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread()+" exit job2,time->"+System.currentTimeMillis());
            return "test:"+result;
        });
        System.out.println("main thread start cf.get(),time->"+System.currentTimeMillis());
        //等待子任务执行完成
        System.out.println("run result->"+cf.get());
        System.out.println("main thread start cf2.get(),time->"+System.currentTimeMillis());
        System.out.println("run result->"+cf2.get());
        System.out.println("main thread exit,time->"+System.currentTimeMillis());
    }

//    public static void test5(){
//        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
//        ListenableFuture<Explosion> explosion = service.submit(new Callable<Explosion>() {
//            public Explosion call() {
//                return pushBigRedButton();
//            }
//        });
//        Futures.addCallback(explosion, new FutureCallback<Explosion>() {
//            // we want this handler to run immediately after we push the big red button!
//            public void onSuccess(Explosion explosion) {
//                walkAwayFrom(explosion);
//            }
//            public void onFailure(Throwable thrown) {
//                battleArchNemesis(); // escaped the explosion!
//            }
//        });
//
//    }
    public static void main(String[] args) throws Exception {
        //test2();
        //test3();
        //test4();
    }


}

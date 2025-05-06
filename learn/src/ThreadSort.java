import com.sun.xml.internal.ws.util.CompletedFuture;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class ThreadSort {
    @Test
    public void test() {
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("线程1在执行");
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("线程2在执行");
        });
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("线程3在执行");
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Test
    public void test2() {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println("线程1在执行");
            System.out.println(Thread.currentThread().getName());
        });
        CompletableFuture<Void> completableFuture2 = completableFuture1.thenRun(() -> {
            System.out.println("线程2在执行");
            System.out.println(Thread.currentThread().getName());
        });
        CompletableFuture<Void> completableFuture3 = completableFuture2.thenRun(() -> {
            System.out.println("线程3在执行");
            System.out.println(Thread.currentThread().getName());
        });
    }
}

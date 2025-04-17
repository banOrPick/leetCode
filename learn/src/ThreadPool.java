import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    public int maxThreads;
    public ThreadPoolTask[] threads;
    public BlockingQueue<Runnable> tasks;

    public ThreadPool(int maxThreads) {
        this.maxThreads = maxThreads;
        threads = new ThreadPoolTask[maxThreads];
        for (int i = 0; i < maxThreads; i++) {
            ThreadPoolTask threadPoolTask = new ThreadPoolTask();
            threadPoolTask.start();
            threads[i] = threadPoolTask;
        }
    }

    //提交任务
    public void submit(Runnable task) {

        this.tasks = new LinkedBlockingQueue<Runnable>();
        tasks.add(task);

    }

    //执行线程队列里的任务
    public class ThreadPoolTask extends Thread {
        @Override
        public void run() {
            while (tasks.peek() != null) {
                Runnable runnable = tasks.poll();
                runnable.run();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);
        threadPool.submit(new Runnable(){

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }


}

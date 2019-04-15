package com.vshpynta.spring.cloud.hystrix.rest.consumer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTest {

    @Test
    public void testThreadPoolExecutorBehavior() {
        int maxQueueSize = 2;
        int corePoolSize = 1;
        int maximumPoolSize = 2;
        long keepAliveTime = 2;

        final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(maxQueueSize);
        ThreadFactory threadFactory = getThreadFactory();

        List<Future> tasksResults = new ArrayList<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue, threadFactory);
        IntStream.iterate(0, i -> ++i)
                .limit(5)
                .forEach(i -> addTask(tasksResults, threadPoolExecutor));

        tasksResults.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e);
            }
        });
    }

    private boolean addTask(List<Future> tasksResults, ThreadPoolExecutor threadPoolExecutor) {
        try {
            System.out.println("threadPoolExecutor.getQueue().size():" + threadPoolExecutor.getQueue().size());
            System.out.println("threadPoolExecutor.getPoolSize():" + threadPoolExecutor.getPoolSize());
            tasksResults.add(threadPoolExecutor.submit(longRunningTask()));
            System.out.println("Successfully added task to executor");
            return true;
        } catch (Exception e) {
            System.out.println("Error adding task to executor: " + e);
            return false;
        }

    }

    private Runnable longRunningTask() {
        return () -> {
            try {
                Thread.sleep(3000);
                System.out.println("Successfully finished longRunningTask");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private ThreadFactory getThreadFactory() {
        return new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "mytest-thread-" + threadNumber.incrementAndGet());
                thread.setDaemon(true);
                return thread;
            }

        };
    }
}

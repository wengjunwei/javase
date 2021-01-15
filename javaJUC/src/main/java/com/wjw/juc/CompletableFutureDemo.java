package com.wjw.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created on 2021/1/15 0015
 *
 * @author weng
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t completableFuture1");
        });

        completableFuture1.get();

        //异步回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t completableFuture2");
            int i=10/0;
            return 1024;
        });

        completableFuture2.whenComplete((t,u) ->{
            System.out.println("-----t"+t);
            System.out.println("-----u"+u);
        }).exceptionally(f->{
            System.out.println("-----exception"+f.getMessage());
            return 444;
        }).get();
    }
}

package com.wjw.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2021/1/13 0013
 *  读写锁
 * @author weng
 */

class MyCache{

    Map map = new HashMap<String,Object>();

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t---正在写");
            Thread.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t---写完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }
    
    public void get(String key)  {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在读");
            Thread.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读完成"+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }
    

}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt+"",tempInt);
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }

}

package com.wjw.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created on 2021/1/3 0003
 *
 * @author weng
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//        Map hashMap = new HashMap();
        Map hashMap = new ConcurrentHashMap();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                hashMap.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(hashMap);
            },String.valueOf(i)).start();

        }
    }
    
    public void hashSetSafe(){
        //        HashSet<Object> hashSet = new HashSet<>();
        Set<Object> hashSet = new CopyOnWriteArraySet<Object>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                hashSet.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(hashSet);
            },String.valueOf(i)).start();

        }
    }
    
    public void listNotSafe(){
        //        List<String> list = Arrays.asList("a","b","c");
//        list.forEach(System.out::println);
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }
}

package com.wjw;

/**
 * 使用Runable实现实现线程
 *
 * 一种是通过实现Runable接口创建线程
 * 另外一种就是通过继承Thread类创建线程
 * 开发中：优先选择：实现Runable接口的方式
 * 原因：1.实现的方式没有类的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程的共享数据情况
 */
class RThead implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                System.out.println(i);
            }
        }
    }
}

public class _05RunableThread {
    public static void main(String[] args) {
        RThead rThead = new RThead();
        Thread thread = new Thread(rThead);
        thread.start();
    }
}

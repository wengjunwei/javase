package com.wjw;

/**
 * 单例模式
 *
 * 线程安全问题 优化
 */
public class _09Singleton {

}

class Bank{

    private Bank(){}

    private static Bank instance=null;

    public  static Bank getInstance(){

        //方式一:效率稍差
//        synchronized (Bank.class) {
//            if(instance==null){
//                return new Bank();
//            }
//            return instance;
//        }

        //方式二：效率稍高
        if (instance==null) {
            synchronized (Bank.class) {
                if(instance==null){
                    return new Bank();
                }
            }
        }
        return instance;
    }

}

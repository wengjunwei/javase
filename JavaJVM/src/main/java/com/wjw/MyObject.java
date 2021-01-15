package com.wjw;

/**
 * Created on 2020/12/29 0029
 *
 * @author weng
 */
public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());

        System.out.println();
        System.out.println();
        System.out.println();


        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader());
    }
}

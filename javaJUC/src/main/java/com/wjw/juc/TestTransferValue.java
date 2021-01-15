package com.wjw.juc;

/**
 * Created on 2021/1/14 0014
 *
 * @author weng
 */
public class TestTransferValue {

    public static void main(String[] args) {
        int a=2;
        demo01(a);
        System.out.println("a = " + a);

        Person person = new Person("小明");
        demo02(person);
        System.out.println("person.getName() = " + person.getName());

        String str = "ss";
        demo03(str);
        System.out.println("str = " + str);

    }

    private static void demo03(String str) {
        str = "bb";
    }

    private static void demo02(Person person) {
        person.setName("xxxx");
    }

    private static void demo01(int a) {
        a=3;
    }
}

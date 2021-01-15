package com.wjw;

/**
 * Created on 2020/12/30 0030
 *
 * @author weng
 */
public class TestTransferValue {

    public static void main(String[] args) {

        TestTransferValue testTransferValue = new TestTransferValue();
        int age = 20;
        testTransferValue.changeVaule(age);
        System.out.println("age-----"+age);

        Person person = new Person("abc");
        testTransferValue.changeValue2(person);
        System.out.println("personName-------"+person.getName());

        String str = "abc";
        testTransferValue.changeValue3(str);
        System.out.println("str------"+str);



    }

    private void changeValue3(String str) {
        str = "xxx";
    }

    private void changeValue2(Person person) {
        person.setName("xxx");
    }

    private void changeVaule(int age) {
        age = 30;
    }
}

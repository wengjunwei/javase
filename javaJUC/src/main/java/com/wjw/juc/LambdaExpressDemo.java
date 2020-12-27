package com.wjw.juc;

/**
 * Created on 2020/12/28 0028
 *
 * @author weng
 */
@FunctionalInterface
interface Foo{

//    public void sayHello();

    public int sayHello(int a , int b);

    default int div(int a ,int b){
        return a+b;
    }

    default int div2(int a ,int b){
        return a+b;
    }

    public static int mv(int a , int b){
        return a*b;
    }

}
/**
 *
 * @Description: Lambda Express-----> 函数式编程
 * 1 拷贝小括号(形参列表)，写死右箭头 ->，落地大括号 {方法实现}
 * 2 有且只有一个public方法@FunctionalInterface注解增强定义
 * 3 default方法默认实现
 * 4 静态方法实现
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {


//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("say hello");
//            }
//        };

//        Foo foo = () -> {System.out.println("say hello lambada");};
        Foo foo = (int a , int b) -> {
            System.out.println("say hello lambada");
            return a+b;
        };
//        int div = foo.div(1, 2);
//        System.out.println(div);

        int i = foo.sayHello(1, 2);
        System.out.println(i);

        int mv = Foo.mv(1, 5);
        System.out.println("mv = " + mv);
    }
}

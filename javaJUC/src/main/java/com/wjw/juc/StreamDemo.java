package com.wjw.juc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @create 2019-02-26 22:24
 *
 * 题目：请按照给出数据，找出同时满足
 *      偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序
 *      最后只输出一个用户名字
 */
public class StreamDemo {

    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream().filter(user -> {
            return user.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge() > 24;
        }).map(f -> {
            return f.getUserName().toUpperCase();
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(1).forEach(System.out::println);
    }




    private static void demo() {
        //        Function function = new Function() {
//            @Override
//            public Object apply(Object o) {
//                return null;
//            }
//        }
        Function function = a -> {return a;};
        System.out.println(function.apply("aaa"));

//        Supplier supplier = new Supplier() {
//            @Override
//            public Object get() {
//                return null;
//            }
//        }

        Supplier supplier = () -> {return 123;};
        System.out.println(supplier.get());

//        Consumer consumer = new Consumer() {
//            @Override
//            public void accept(Object o) {
//
//            }
//        }
        Consumer<String> consumer = b -> {
            System.out.println(b);
        };

//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        }
        Predicate<String> predicate = c -> {return c!=null;};
        System.out.println(predicate.test("A"));
    }

}

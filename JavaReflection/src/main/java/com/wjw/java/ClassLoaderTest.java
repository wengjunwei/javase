package com.wjw.java;

/**
 * Created on 2020/12/26 0026
 *
 * @author weng
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;

/**
 * 了解类的加载器
 */
public class ClassLoaderTest {

    @Test
    public  void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoaderParent.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /**
     *  Properties：用来读取配置文件。
     */
    @Test
    public void test3() throws IOException {

        Properties properties = new Properties();


        //读取配置文件的方式一：
        //此时的文件默认在当前的module下。
        FileInputStream fileInputStream = new FileInputStream(ClassLoaderTest.class.getClassLoader().getResource("jdbc.properties").getPath());
        properties.load(fileInputStream);

        //读取配置文件的方式二：
        //配置文件默认识别为：当前module的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
//        properties.load(resourceAsStream);


        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user);
        System.out.println("password = " + password);


    }

}

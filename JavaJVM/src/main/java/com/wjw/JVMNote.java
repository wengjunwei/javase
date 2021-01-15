package com.wjw;

/**
 * Created on 2020/12/30 0030
 *
 * 1.JVM架构图   灰色线程私有 不存在垃圾回收。
 *
 * 2.类加载器
 *      2.1 有哪几种加载器
 *      2.2双亲委派
 *      2.3沙箱安全机制
 * 3.Native
 *      3.1native是一个关键字
 *      3.2声明有，实现无，why？
 * 4.PC寄存器
 *      4.1积累了方法之间的调用和执行情况，类似排版值日表用来存储指向下一条指令的地址，也即将要执行的指令代码。
 *      它是当前线程所执行的字节码的行号指示器。
 *
 * 5 方法区
 *      5.1 它存储了每一个类的结构信息
 *      5.2 方法区是规范，在不同虚拟机里头实现是不一样的，最典型的就是永久代（PermGen soace) 和元空间（Metasopace）
 *
 *      空调 k1 = new 格力（）
 *      List list = new ArrayList();
 * 方法区 f = new 永久代
 * 方法区 f = new 元空间
 *
 *
 * 6.stack
 *      6.1 栈管运行，堆管存储
 *      6.2 栈保存哪些东东？
 *          8种基本类型变量+对象的引用变量+实例方法都是在函数的栈内存中分配
 *      6.3 Exception in thread "main" java.lang.StackOverflowError
 *
 * 7.heap
 *
 * @author weng
 */
public class JVMNote {

    //本地变量（Local Variables）:输入参数和输出参数以及方法内的变量
    public int show(int a , int b){
        int x = 1;
        x = a+b;
        return x;
    }

//    public static void m1(){
//        m1();
//    }

    public static void main(String[] args) {
//        m1();
    }

}

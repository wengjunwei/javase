package com.wjw.juc;
 
import java.util.concurrent.TimeUnit;
 
 
class Phone
{
 
 public static   synchronized void sendSMS() throws Exception
 {
   TimeUnit.SECONDS.sleep(4);
   System.out.println("------sendSMS");
 }
 public static synchronized void sendEmail() throws Exception
 {
   System.out.println("------sendEmail");
 }
 
 public void getHello() 
 {
   System.out.println("------getHello");
 }
 
}
 
/**
 * 
 * @Description: 8锁
 * 
 1 标准访问，先打印短信还是邮件    短信
 2 停4秒在短信方法内，先打印短信还是邮件  短信
 3 新增普通的hello方法，是先打短信还是hello  Hello
 4 现在有两部手机，先打印短信还是邮件  短信
 5 两个静态同步方法，1部手机，先打印短信还是邮件 短信
 6 两个静态同步方法，2部手机，先打印短信还是邮件  短信
 7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件
 8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件
 * ---------------------------------
 * 
 */
public class Lock_8
{
 public static void main(String[] args) throws Exception
 {
 
   Phone phone = new Phone();
   Phone phone2 = new Phone();
   
   new Thread(() -> {
    try {
     phone.sendSMS();
    } catch (Exception e) {
     e.printStackTrace();
    }
   }, "AA").start();
   
   Thread.sleep(100);
   
   new Thread(() -> {
    try {
//     phone.sendEmail();
     phone.getHello();
//     phone2.sendEmail();
    } catch (Exception e) {
     e.printStackTrace();
    }
   }, "BB").start();
 }
}
 
 

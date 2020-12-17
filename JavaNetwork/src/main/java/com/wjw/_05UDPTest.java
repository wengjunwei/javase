package com.wjw;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPd协议的网络编程
 */
public class _05UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] buffer = "我是UTP发送端".getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length,inetAddress,8899);

        datagramSocket.send(datagramPacket);
        datagramSocket.close();

    }

    //接收端
    @Test
    public void reserver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8899);

        byte[] buffer = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);

        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        datagramSocket.close();
    }

}

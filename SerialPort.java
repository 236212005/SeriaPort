package com.aijiao.test;

public class SerialPort {
    
    public native int[] getPorts();                 //获取串口号
    
    public native void getHandle(int port);         //获得句柄
    
    public native void startPort(int _BaudRation, int _parity,int _stopBits,int _byteSize);         //开启串口
    
    public native String readPort();                //读取一次数据
    
    public native boolean sendDatatoP04();          //发送一次信号
    
    //加载动态库
    static{
            System.loadLibrary("SerialPort");
    }
    public static void main(String[] args) {
        SerialPort serial=new SerialPort();
        int port=0;
        for(int i:serial.getPorts()) {
            System.out.println(i);//这里就一个，其他再处理
            port=i;
        };
        serial.getHandle(port);
        serial.startPort(9600, 0, 0, 8);
        int n=1000;
        while(n-->0) {
            String str=serial.readPort();
            System.out.println(str);
        }
    }
}

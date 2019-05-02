package com.aijiao.test;

public class SerialPort {
    
    public native int[] getPorts();                 //��ȡ���ں�
    
    public native void getHandle(int port);         //��þ��
    
    public native void startPort(int _BaudRation, int _parity,int _stopBits,int _byteSize);         //��������
    
    public native String readPort();                //��ȡһ������
    
    public native boolean sendDatatoP04();          //����һ���ź�
    
    //���ض�̬��
    static{
            System.loadLibrary("SerialPort");
    }
    public static void main(String[] args) {
        SerialPort serial=new SerialPort();
        int port=0;
        for(int i:serial.getPorts()) {
            System.out.println(i);//�����һ���������ٴ���
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

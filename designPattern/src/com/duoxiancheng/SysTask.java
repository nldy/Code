package com.duoxiancheng;

public class SysTask {
    public synchronized void doSomeThing(){
        System.out.println("start thread name is :" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end thread name is :" + Thread.currentThread().getName());
    }
}

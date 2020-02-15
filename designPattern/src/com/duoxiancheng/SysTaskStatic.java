package com.duoxiancheng;

public class SysTaskStatic {
    public synchronized static void doSomeThing(){  // 加锁静态方法，即类锁
        System.out.println("start thread name is :" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end thread name is :" + Thread.currentThread().getName());
    }
}

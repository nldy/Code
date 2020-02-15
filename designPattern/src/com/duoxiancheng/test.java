package com.duoxiancheng;

public class test {
    public static void main(String[] args) {
        /*对象锁
        SysTask sysTask = new SysTask();
        for (int i=0 ;i<3;i++){ //3线程调用一个线程的同步方法
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    sysTask.doSomeThing();
                }
            });
            thread.setName(i+"-name");
            thread.start();
        }
         */

        /*对象锁对比
        for (int i = 0; i < 3; i++) {
            SysTask sysTask = new SysTask();    //3线程调用3个不同对象的同步方法->不同步
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    sysTask.doSomeThing();
                }
            });
            thread.setName(i + "-name");
            thread.start();
        }
         */

        //加锁静态方法，即类锁。
        //静态方法其实就是类方法，所以加锁静态方法，即类锁。类锁的范围是整个实体类，即全局锁。
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Runnable() { // 类锁，也是同步的
                @Override
                public void run() {
                    SysTaskStatic.doSomeThing();
                }
            });
            thread.setName(i + "-name");
            thread.start();
        }
    }
}

package com.jvmdemo;

public class Mytest {
    public static void main(String[] args){
        //对于静态字段来说，只有直接定义了该字段的类才会被初始化
        System.out.println(MyChild1.str);

        /*
        str2是在子类定义，对MyParent1的主动使用，也是对父类的主动使用
        当一个类在初始化时，要求其父类全部都已经初始化了
        */
        //System.out.println(MyChild1.str2);
    }
}

class MyParent1{
    public static String str="hello world";

    static {
        System.out.println("MyPrent1 static block");
    }
}

class MyChild1 extends MyParent1{
    public static String str2="welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
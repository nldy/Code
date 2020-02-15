package com.basestudydemo;

public class GenericsTest {
    public static void main(String[] args){
        A<String> a1=new A<String>();
        a1.setKey("one");
        System.out.println(a1.getKey());
        Class clazz=a1.getClass();
        System.out.println(clazz);
    }
}
class A<T>{
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
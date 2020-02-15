package com.basestudydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author LDC
 * @Date 2020/2/15 6:30 下午
 * @Version 1.0
 */
public class MyProxy implements InvocationHandler {
    Object obj;//被代理的对象

    public MyProxy(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        System.out.println("开始执行");

        Object result=method.invoke(this.obj,args);//执行指定代理对象的指定方法

        System.out.println("结束执行");
        return result;
    }
}

package com.basestudydemo;

/**
 * @Author LDC
 * @Date 2020/2/15 6:24 下午
 * @Version 1.0
 */
public class MyProxyTestDemoImpl implements MyProxyTestDemo{
    @Override
    public void test1(){
        System.out.println("excute test1()");
    }
    @Override
    public void test2(){
        System.out.println("excute test2()");
    }
}

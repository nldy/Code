package com.basestudydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author LDC
 * @Date 2020/2/15 6:19 下午
 * @Version 1.0
 */
public class MyProxyTest {
    public static void main(String[] args) {
        MyProxyTestDemo test=new MyProxyTestDemoImpl();

        test.test1();
        test.test2();
        System.out.println("------------");
        /*
        需求：在执行test1（）和test2（）方法时需要加入
        1）在执行前打印"开始执行"
        2）在执行后打印"结束执行"
         */
        InvocationHandler handler=new MyProxy(test);
        /*
        Proxy.newProxyIn stance(ClassLoader,interface,h)
        参数1：代理对象的类加载器
        参数2：被代理的对象的接口
        参数3：代理对象

        返回值：成功被代理后对象（Object类型）
         */
        MyProxyTestDemo t=(MyProxyTestDemo)Proxy.newProxyInstance(handler.getClass().getClassLoader(),test.getClass().getInterfaces(),handler);
        t.test1();
        t.test2();
    }
}
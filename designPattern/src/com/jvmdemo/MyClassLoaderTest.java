package com.jvmdemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/*
自定义类加载器
 */
public class MyClassLoaderTest extends ClassLoader{
    private String classLoaderName;
    private final String fileExtension=".class";

    public MyClassLoaderTest(String classLoaderName){
        super();
        this.classLoaderName=classLoaderName;
    }

    public MyClassLoaderTest(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName=classLoaderName;
    }

    @Override
    public String toString(){
        return "["+this.classLoaderName+"]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException{
        byte[] data=this.loadClassData(className);

        return this.defineClass(className,data,0,data.length);
    }

    private  byte[] loadClassData(String name){
        InputStream is=null;
        byte[] data=null;
        ByteArrayOutputStream baos=null;
        try{
            this.classLoaderName=this.classLoaderName.replace(".","/");
            is=new FileInputStream(new File(name+this.fileExtension));
            baos=new ByteArrayOutputStream();

            int ch=0;
            while(-1 != (ch=is.read())){
                baos.write(ch);
            }
            data=baos.toByteArray();
        }catch (Exception ex){
            ex.printStackTrace();;
        }finally {
            try{
                is.close();
                baos.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception{
        MyClassLoaderTest loader1=new MyClassLoaderTest("loader1");
        test(loader1);
    }

    public static void test(ClassLoader classLoader) throws Exception{
        Class<?> clazz= classLoader.loadClass("com.jvmdemo.Mytest");
        Object object=clazz.newInstance();

        System.out.println(object);
    }
}

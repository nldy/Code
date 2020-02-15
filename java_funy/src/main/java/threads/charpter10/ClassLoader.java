package threads.charpter10;

public class ClassLoader {
    public static void main(String[] args)
    {
        System.out.println("Bootstrap:"+String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println(System.getProperty("java.ext.dirs"));
    }
}

//package threads.charpter8;
//
//import java.util.concurrent.TimeUnit;
//
//public class BasicThreadPool extends Thread implements ThreadPool{
//    private final int initSize;
//
//    private final int maxSize;
//
//    private final int coreSize;
//
//    private int activeCount;
//
//    private final ThreadFactory threadFactory;
//
//    private final RunnableQueue runnableQueue;
//
//    private volatile boolean isShutdown = false;
//
//    private final static DenyPolicy DEFAULT_DENY_POLICY=new DenyPolicy.DiscardDenyPolicy();
//
////    private final static DenyPolicy DEFAULT_THREAD_FACTORY=new Defau
//
//    private final long keepAliveTime;
//
//    private final TimeUnit timeUnit;
//
//    public BasicThreadPool(int initSize,int maxSize,int coreSize,int queueSize)
//    {
//        this(initSize,maxSize,coreSize,queueSize,DEFAULT_DENY_POLICY,10,TimeUnit.SECONDS)
//    }
//}

package threads.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

public class BooleanLock implements Lock{
    private Thread currentThread;

    private boolean locked=false;

    private final List<Thread> bolockedList=new ArrayList<>();

    @Override
    public void lock() throws InterruptedException
    {
        synchronized (this)
        {
            while(locked)
            {
                //加强lock（），解决如果某个线程被中断，其还可能在blockList中
                final Thread tempThread=currentThread();
                try {
                    //当前锁已经被某个线程获得，将该线程加入阻塞队列，并释放this monitor的所有权
                    bolockedList.add(currentThread());
                    this.wait();
                }catch (InterruptedException e){
                    //如果当前线程在wait时被中断，则从list中将其删除，避免内存泄漏
                    bolockedList.remove(tempThread);
                    throw e;
                }
            }
            //如果当前锁没有被其他线程获得，尝试从阻塞队列中删除自己（未进入阻塞队列删除也不会有影响）
            bolockedList.remove(currentThread());
            this.locked=true;
            //记录获取锁的线程
            this.currentThread=currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException
    {
        synchronized (this)
        {
            if(mills<=0)
            {
                this.lock();
            }else
            {
                long remainingMills=mills;
                long endMills=currentTimeMillis()+remainingMills;
                while(locked)
                {
                 if(remainingMills<=0)
                     throw new TimeoutException("can not get the lock during"+mills);
                 if(!bolockedList.contains(currentThread()))
                     bolockedList.add(currentThread());
                 this.wait();
                 remainingMills=endMills-currentTimeMillis();
                }
                bolockedList.remove(currentThread());
                this.lock();
                this.currentThread=currentThread();
            }
        }
    }

    @Override
    public void unlock()
    {
        synchronized (this)
        {
            if(currentThread==currentThread())
            {
                this.locked=false;
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads()
    {
        return Collections.unmodifiableList(bolockedList);
    }
}

package threads.charpter8;

@FunctionalInterface
public interface DenyPolicy {
    void reject(Runnable runnable,ThreadPool threadPool);

    //该拒绝策略会直接将任务丢弃
    class DiscardDenyPolicy implements DenyPolicy
    {
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool)
        {
            //do nothing
        }

    }
    //向任务提交者抛出异常
    class AbortDenyPolicy implements DenyPolicy
    {
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool)
        {
            throw new RuntimeException("The runnable "+runnable+" will be abort.");
        }
    }
    //使任务在提交者所在的线程执行任务
    class RunnerDenyPolicy implements DenyPolicy
    {
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool)
        {
            if(!threadPool.isShutdown())
            {
                runnable.run();
            }
        }
    }
}

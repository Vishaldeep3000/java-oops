package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**Here we have created a threadpool with queue size of 2, and corepool (means initial threads as )2, and max size as 4
 * 
 * So when we start giving it the runnable tasks from the for loop(here we are giving 4 tasks) -> series of execution
 * firs and second task we get the thread and will work there task 
 * then thrird and fourth (as the queue size is 2) will be pushed to the queue, they wont create a new thread although 
 * the max thread count is given as 4
 * when the 5th task comes the as the core threads are working and queeu is also full , so it will then create new thread
 * and same as for 6th(asuming 1st and 2nd have not finished there execution)
 * and then if 1st gets done witn the thread then it will take a new task from the queue which are waiting for execution
 */

public class ThreadPool {
    
    public static void main(String args[]){
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), 
                                        new CustomThreadFactory(), new CustomRejectHandler() );

        for(int i = 0 ; i < 6; i++){
            executor.submit(() -> {
                try{
                    Thread.sleep(5000);
                }catch(Exception e){
                    //exception handeling goes here
                }
                System.out.println("This is the task being processed "+ Thread.currentThread().getName());
            });
        }
    }
}


class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r){
        Thread th = new Thread(r);
        th.setDaemon(false);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        
        System.out.println(" Task rejected : "+ r.toString());  
    }

}

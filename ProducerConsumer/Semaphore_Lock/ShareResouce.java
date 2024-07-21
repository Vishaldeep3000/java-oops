package ProducerConsumer.Semaphore_Lock;

import java.util.concurrent.Semaphore;

public class ShareResouce {

    boolean isAvailable = false;
    Semaphore lock = new Semaphore(1);

    public void producer(){

        try{
            System.out.println(Thread.currentThread().getName() + " attempting to acquire lock");
            lock.acquire();
            System.out.println("Lock Acquired : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println("Exception in " + Thread.currentThread().getName() + ": " + e.getMessage());
        }
        finally{
            lock.release();
            System.out.println("Lock Released : " + Thread.currentThread().getName());
        }

    }
}

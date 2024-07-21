package ProducerConsumer.ReadWrite_Lock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource{

    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){

        try{
            lock.readLock().lock(); //lock acquired
            System.out.println("Lock acuired by : "+ Thread.currentThread().getName()+ " from producer");
            isAvailable = true;
            Thread.sleep(2000);
        }catch(Exception e){
            //Exception handeling goes here
        }
        finally{
            lock.readLock().unlock();//lock released
            System.out.println("Lock released by : "+ Thread.currentThread().getName() + " from producer");
        }

    }

    public void consumer(ReadWriteLock lock){

        try{
            lock.writeLock().lock();
            System.out.println("Lock acuired by : "+ Thread.currentThread().getName() + " from consumer");
            isAvailable = false;
        }catch(Exception e){
            //Exception handeling goes here
        }
        finally{
            lock.writeLock().unlock();
            System.out.println("Lock released by : "+ Thread.currentThread().getName() +" from consumer");

        }

    }
}
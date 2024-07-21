package ProducerConsumer.ReadWrite_Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource1.producer(lock);
        });

        Thread th2 = new Thread(() -> {
            resource1.producer(lock);
        });

        SharedResource resource2 = new SharedResource();

        Thread th3 = new Thread(() -> {
            resource2.consumer(lock);
        });

        th1.start();
        th2.start();
        th3.start();
    }

}

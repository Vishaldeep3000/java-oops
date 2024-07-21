package ProducerConsumer.Semaphore_Lock;

public class Main {

    public static void main(String[] args) {
        ShareResouce resouce  = new ShareResouce();

        Thread th1 = new Thread(() -> {
            resouce.producer();
        });
    
        Thread th2 = new Thread(() -> {
            resouce.producer();
        });
    
        Thread th3 = new Thread(() -> {
            resouce.producer();
        });
    
        Thread th4 = new Thread(() -> {
            resouce.producer();
        });
    
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}

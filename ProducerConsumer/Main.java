/*Two threads, a producer and a consumer, share a common, fixed-size buffer as a queue
 * The producer job is to generate data and put it into the buffer, while the consumer job is to 
 * consume data from the buffer
 * The problem is to make sure that the producer wont produce data if the buffer is full
 * and the consumer wont consume data if the buffer is empty
 */

package ProducerConsumer;

public class Main {

    public static void main(String[] args) {
        
        SharedResouce resouceObj = new SharedResouce();

        Thread producerThread = new Thread(() -> {
            try{
                Thread.sleep(2000); // so that everytime consumerThread starts first
            }catch(Exception e){
                //some exception handleing here
            }
            resouceObj.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            resouceObj.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
    }
    
}

package ProducerConsumer;

import java.util.ArrayList;
import java.util.LinkedList;

public class SharedResouce{

    LinkedList<Integer> lst = new LinkedList<>();
    int capacity = 2;

    public synchronized void addItem(){

        int val = 1;
        while(true){
            while(lst.size() == capacity){
                try{
                    System.out.println("Capacity is full");
                    wait();
                }catch(Exception e){
                  //Exception handeling  
                }   
            }
            lst.add(val++);
            System.out.println("Producer thread notifying the consumer to consume ..... ");
            notifyAll();
        }
        
    }

    public synchronized void consumeItem(){

        System.out.println("Inside consumer Thread");
        while(true){

            while(lst.isEmpty()){
                try{
                    System.out.println("Consumer Thread is waiting as list is empty.....");
                    wait();
                }catch(Exception e){
                    //Some exception handeling
                }
            }
    
            int val = lst.removeFirst();
            System.out.println("Consumed element -> "+ val);
            notifyAll();


        }


    }

}
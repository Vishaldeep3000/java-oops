package Rent_Vehicle;

public class Vehicle {

    private String name;
    private int currentspeed;
    private int currentdirection;

    public Vehicle(String name){
        this.name = name;
        this.currentdirection = 0;
        this.currentspeed = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getDirection(){
        return this.currentdirection;
    }

    public int getSpeed(){
        return this.currentspeed;
    }

    public void move(int speed, int direction){
        this.currentspeed = speed;
        this.currentdirection = direction;
        System.out.println(" updated speed -> "+ this.currentspeed);
        System.out.println(" updated direction -> "+ this.currentdirection);
    }

    public void steer(int direction){
        this.currentdirection = direction;
        System.out.println(" updated direction -> "+ this.currentdirection);
    }

    public void stop(){
        this.currentspeed = 0;
        this.currentdirection = 0;
        System.out.println(" Vehicle stopped !! ");
    }
}

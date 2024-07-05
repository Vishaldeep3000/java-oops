package Rent_Vehicle;

public class Car extends Vehicle{

    private int wheels;
    private String type;
    private int doors;
    private int gear;
    private boolean ifManual;
    private int currentGear;

    public Car(String name, int wheels, String type,int gear, int doors, boolean ifManual) {
        super(name);
        this.wheels = wheels;
        this.type = type;
        this.doors = doors;
        this.ifManual = ifManual;
        this.gear = gear;
        this.currentGear = 1;
    }
    
    public void setWheels(int noOfweh){
        this.wheels = noOfweh;
    }

    public void setDoors(int noOfDoors){
        this.doors = noOfDoors;
    }

    public void setGear(int ger){
        this.gear = ger;
        System.out.println("Gear changed to -> "+ this.gear);
    }

    public int getGear(){
        return this.gear;
    }

    public void setIFManual(boolean ifYes){
        this.ifManual = ifYes;
    }

    public boolean getIfManual(){
        return this.ifManual;
    }

    public void changeGear(int updated_Gear){
        setGear(updated_Gear);
    }

    public void changeSpeed(int updated_speed, int updated_dir){
        move(updated_speed, updated_dir);
    }
}

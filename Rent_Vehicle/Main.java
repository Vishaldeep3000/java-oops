package Rent_Vehicle;

public class Main {
    public static void main(String[] args) {
        SUV xuv = new SUV("xuv", false);
        xuv.move(40, 0);
        xuv.accelerate(20);
        xuv.accelerate(-20);
        System.out.println(xuv.getGear());

    }
}

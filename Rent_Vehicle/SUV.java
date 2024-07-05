package Rent_Vehicle;

public class SUV extends Car{

    public SUV(String name, boolean manualOrNot){
        super(name, 4, "SUV",6,  4, manualOrNot);
    }

    public void accelerate(int rate){ /*THis method is not working as expected currently  */

        int newSpeed = getSpeed();

        while (newSpeed != 0 && newSpeed + rate != 0) {
            newSpeed += rate;
            if (newSpeed <= 0) {
                stop();
                newSpeed = 0;
            } else if (newSpeed > 0 && newSpeed <= 10) {
                changeGear(2);
            } else if (newSpeed > 10 && newSpeed <= 20) {
                changeGear(3);
            } else if (newSpeed > 20 && newSpeed <= 30) {
                changeGear(4);
            } else if (newSpeed > 30 && newSpeed <= 40) {
                changeGear(5);
            } else {
                changeGear(6);
            }

            changeSpeed(newSpeed, getDirection());
        }

    }
    
}

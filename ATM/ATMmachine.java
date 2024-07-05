package ATM;
import java.util.Scanner;

class ATM{

    private int PIN = 1111; //hey please update PIN don't make it public - lets see
    private float Balance ;

    ATM(){  
        
        checkPIN();

    }

    public void checkPIN(){
        System.out.println("Enter your PIN : ");
        Scanner sc = new Scanner(System.in);
    
        int enteredPIN = sc.nextInt();
    
        if(enteredPIN == PIN){
            menu();
        }else{
            System.out.println("Please enter a valid PIN ! ");
        }
    }


    public void menu(){

        int selectedOption;
        do{
            displayMenu();
            Scanner sc = new Scanner(System.in);
            selectedOption = sc.nextInt();

            switch (selectedOption) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawlBalance();
                    break;
                case 3:
                    depositBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM , thankyou !");
                    break;
                default:
                    System.out.println("Enter a valid PIN !!");
            }
        }while(selectedOption != 4);

    }

    private void displayMenu(){
        System.out.println("Please enter the corresponding code for your option -> ");
        System.out.println("Check Balance (Code : 1)");
        System.out.println("Withdrawl Balance (Code : 2)");
        System.out.println("Deposit Balance (Code : 3)");
        System.out.println("Exit (Code : 4)");
    }

    public void checkBalance(){

        System.out.println(" Available balance : "+ Balance);
        menu();

    }

    public void withdrawlBalance(){

        System.out.println(" Enter the amount to withdraw : ");
        Scanner sc = new Scanner(System.in);

        float withdrawAmout = sc.nextFloat();

        if(withdrawAmout > Balance){
            System.out.println(" Insufficient Balance !! ");
            menu();
        }else{
            Balance -= withdrawAmout;
            System.out.println(" Updated amount : "+ Balance);
        }

    }

    public void depositBalance(){

        System.out.println("Enter the amount to deposit : ");
        Scanner sc  = new Scanner(System.in);

        float depositAmount = sc.nextFloat();
        Balance += depositAmount;

        System.out.println("Updated amount : "+ Balance);
        menu();
    }

}

public class ATMmachine {

    public static void main(String[] args) {
        
        ATM objATM = new ATM();

    }
    
}

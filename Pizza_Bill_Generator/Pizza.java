package Pizza_Bill_Generator;

public class Pizza {

    private int price;
    private Boolean veg;
    private int basePizzaPrice;

    private int extraCheesePrice = 50;
    private int extraToppingsPrice = 50;
    private int packingCharge = 20;

    private boolean extraCheeseAdded = false;
    private boolean extraTopingsAdded = false;
    private boolean takeAwayOpted = false;

    public Pizza(Boolean veg){

        this.veg = veg;
        if(this.veg){
            this.price = 300;
        }else{
            this.price = 400;
        }

        this.basePizzaPrice = this.price;
    }

    public int getPizzaPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        System.out.println("Loading more cheese .... ");
        extraCheeseAdded = true;
        this.price += this.extraCheesePrice;
    } 

    public void addExtraToppings(){
        System.out.println("Spreading more toppings .... ");
        extraTopingsAdded = true;
        this.price += this.extraToppingsPrice;
    }

    public void takeAway(){
        System.out.println("Your order is being packed ");
        takeAwayOpted = true;
        this.price += this.packingCharge;

    }

    public void getBill(){
        System.out.println("Pizza price : "+ basePizzaPrice);
        if(extraCheeseAdded){
            System.out.println("Extra Cheese : "+ extraCheesePrice);
        }
        if(extraTopingsAdded){
            System.out.println("Extra Toppings : " + extraToppingsPrice);
        }
        if(takeAwayOpted){
            System.out.println("Packing Charge : " + packingCharge);
        }

        System.out.println("Grand total : "+ this.price);

    }
    
}

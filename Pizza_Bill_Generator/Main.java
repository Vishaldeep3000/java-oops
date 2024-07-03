package Pizza_Bill_Generator;

public class Main {
    public static void main(String[] args) {
        Pizza basePizza = new Pizza(true);
        //System.out.println(basePizza.getPizzaPrice());
        basePizza.addExtraToppings();
        basePizza.addExtraCheese();
        basePizza.takeAway();
        basePizza.getBill();
    }
}

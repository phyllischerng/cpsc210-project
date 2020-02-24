package model;

public class Drink {

    private int calories;
    private double price;
    private String size;
    private String topping;
    private int sugarLevel;
    private String flavour;
    private String fullName;




    public Drink(String size, String flavour, int sugarLevel, String topping, int calories, double price) {
        this.size = size;
        this.flavour = flavour;
        this.sugarLevel = sugarLevel;
        this.topping = topping;
        this.price = price;
        this.calories = calories;
        fullName = size + " " + flavour + " with " + topping + " " + sugarLevel + "% sugar";
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }

    public String getFullName() {
        return fullName;
    }
}

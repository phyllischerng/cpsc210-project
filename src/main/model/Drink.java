package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

public class Drink implements Saveable {

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

    public String getSize() {
        return size;
    }

    public String getFlavour() {
        return flavour;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public String getTopping() {
        return topping;
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

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(size);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(flavour);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(sugarLevel);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(topping);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(calories);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(price);




    }
}

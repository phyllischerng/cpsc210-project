package model;

import java.awt.*;
import java.util.LinkedList;


public class DrinkList {
    private double totalMoney;
    private int totalCalories;

    LinkedList<Drink> drinkList;

    public DrinkList() {
        drinkList = new LinkedList<>();

    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: Adds the given drink to the drinkList

    public void addDrink(Drink d) {
        drinkList.add(d);
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Returns the total amount of calories in the drinkList
    public int getCalories() {
        totalCalories = 0;
        for (Drink d : drinkList) {
            totalCalories = totalCalories + d.getCalories();
        }
        return totalCalories;
    }


    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Returns the total amount of money spent in the drinkList

    public double getMoneySpent() {
        totalMoney = 0;
        for (Drink d : drinkList) {
            totalMoney = totalMoney + d.getPrice();
        }
        return totalMoney;

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Returns the drinks that are currently in the list

    public String viewDrinkList() {
        String temp = "";
        for (Drink d : drinkList) {
            temp = temp + d.getFullName() + "\n";
        }
        return temp;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Returns number of drinks in the list

    public int getNumDrinks() {
        return drinkList.size();
    }

}

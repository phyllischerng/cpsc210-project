package ui;

import model.Drink;
import model.DrinkList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

public class DrinkApp {
    private Scanner input;
    private DrinkList bbtList;

    String size = "";
    String flavour = "";
    int sugarLevel = 0;
    String topping = "";
    int calories = 0;
    double price = 0;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: runs the drink application
    public DrinkApp() {
        runDrinkApp();
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: runs the app
    private void runDrinkApp() {
        bbtList = new DrinkList();
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays main menu
    private void displayMenu() {
        System.out.println("\nWelcome. What would you like to do?");
        System.out.println("\ta -> Add a drink");
        System.out.println("\tb -> View current drink list");
        System.out.println("\tc -> Get total money spent");
        System.out.println("\td -> Get total calories consumed");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addDrink();
        } else if (command.equals("b")) {
            viewDrinkList();
        } else if (command.equals("c")) {
            getTotalMoney();
        } else if (command.equals("d")) {
            getTotalCalories();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: adds a drink to the list
    private void addDrink() {

        displayMenuSize();
        size = input.next();
        processCommandSize(size);


        displayMenuFlavour();
        flavour = input.next();
        processCommandFlavour(flavour);


        displayMenuSugarLevel();
        sugarLevel = input.nextInt();

        displayMenuTopping();
        topping = input.next();
        processCommandTopping(topping);

        displayMenuCalories();
        calories = input.nextInt();

        displayMenuPrice();
        price = input.nextDouble();


        bbtList.addDrink(new Drink(size, flavour, sugarLevel, topping, calories, price));

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: prints the full names of the drinks in the list
    private void viewDrinkList() {
        System.out.println(bbtList.viewDrinkList());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: prints the total cost of all drinks in the list
    private void getTotalMoney() {
        System.out.println(bbtList.getMoneySpent());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: prints the total calories of all drinks in the list
    private void getTotalCalories() {
        System.out.println(bbtList.getCalories());
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays size menu
    private void displayMenuSize() {
        System.out.println("\nWhat is the drink size?");
        System.out.println("\tm -> medium");
        System.out.println("\tl -> large");
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays flavour menu
    private void displayMenuFlavour() {
        System.out.println("\nWhat flavour is your drink?");
        System.out.println("\tb -> black tea");
        System.out.println("\tg -> green tea");
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays sugar level menu
    private void displayMenuSugarLevel() {
        System.out.println("What is your drink's sugar level? Input only 0, 30, 50, 70, 100, 120");
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays topping menu
    private void displayMenuTopping() {
        System.out.println("\nWhat topping did you get?");
        System.out.println("\tp -> pearls");
        System.out.println("\tgj -> grass jelly");
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays calories menu
    private void displayMenuCalories() {
        System.out.println("How many calories is in your drink?");

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: displays price menu
    private void displayMenuPrice() {
        System.out.println("How much does your drink cost? Ex: 5.20 , 3.00 , 6.20");
    }



    // MODIFIES: this
    // EFFECTS: processes user command for size
    private void processCommandSize(String command) {
        if (command.equals("m")) {
            size = "M";
        } else if (command.equals("l")) {
            size = "L";
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: processes user command for flavour
    private void processCommandFlavour(String command) {
        if (command.equals("b")) {
            flavour = "BLACK TEA";
        } else if (command.equals("g")) {
            flavour = "GREEN TEA";
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: processes user command for topping
    private void processCommandTopping(String command) {
        if (command.equals("p")) {
            topping = "Pearls";
        } else if (command.equals("gj")) {
            topping = "Grass Jelly";
        } else {
            System.out.println("Selection not valid...");
        }
    }

}
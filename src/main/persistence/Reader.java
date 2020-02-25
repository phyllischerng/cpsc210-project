package persistence;

import model.Drink;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of drinks parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static LinkedList<Drink> readDrinks(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of drinks parsed from list of strings
    // where each string contains data for one account
    private static LinkedList<Drink> parseContent(List<String> fileContent) {
        LinkedList<Drink> drinkList = new LinkedList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            drinkList.add(parseDrink(lineComponents));
        }

        return drinkList;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 6 where element 0 represents the
    // size of the next drink to be constructed, element 1 represents
    // the flavour, elements 2 represents the sugar level, element 3 represents
    // the topping of the account to be constructed, element 4 represents
    // the number of calories, and element 5 represents
    // the price of the drink to be constructed
    // EFFECTS: returns a Drink constructed from components
    private static Drink parseDrink(List<String> components) {
        String size = components.get(0);
        String flavour = components.get(1);
        int sugarLevel = Integer.parseInt(components.get(2));
        String topping = components.get(3);
        int calories = Integer.parseInt(components.get(4));
        double price = Double.parseDouble(components.get(5));
        return new Drink(size,flavour,sugarLevel,topping,calories,price);
    }

}
package ui;

import model.Drink;
import model.DrinkList;
import persistence.Reader;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


public class WestPanel extends JPanel {

    double totalMoney;
    int totalCalories;

    DrinkList bbtList = CenterPanel.bbtList;
    LinkedList<Drink> drinks = CenterPanel.drinks;

    private static final String DRINKS_FILE = "./data/testDrinks.txt";

    JLabel totalCaloriesNumber;
    JLabel totalMoneyNumber;

    public WestPanel() {
        setPanelDimensions();
        loadDrinks();


        JLabel totalMoneyLabel = new JLabel("Total Money Spent: ");
        JLabel totalCaloriesLabel = new JLabel("Total Calories Consumed: ");
        updateNumbers();



        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First column ///////////////////

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        add(totalMoneyLabel,gc);
        gc.gridx = 0;
        gc.gridy = 1;
        add(totalMoneyNumber,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(totalCaloriesLabel,gc);
        gc.gridx = 0;
        gc. gridy = 3;
        add(totalCaloriesNumber,gc);

    }

    public void setPanelDimensions() {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // MODIFIES: this
    // EFFECTS: loads list of drinks from DRINKS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    private void loadDrinks() {
        try {
            drinks = Reader.readDrinks(new File(DRINKS_FILE));

            for (Drink d : drinks) {
                bbtList.addDrink(d);
            }

        } catch (IOException e) {
            init();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes DrinkList
    private void init() {
        bbtList = new DrinkList();
    }

    public void updateNumbers() {
        totalMoney = bbtList.getMoneySpent();
        totalCalories = bbtList.getCalories();
        totalMoneyNumber = new JLabel("$" + Double.toString(totalMoney));
        totalCaloriesNumber = new JLabel(Integer.toString(totalCalories));

    }
}


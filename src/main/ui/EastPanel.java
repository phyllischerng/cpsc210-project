package ui;


import model.Drink;
import model.DrinkList;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import persistence.Reader;

public class EastPanel extends JPanel {

    private static final String DRINKS_FILE = "./data/testDrinks.txt";

    DrinkList bbtList = CenterPanel.bbtList;

    LinkedList<Drink> drinks = CenterPanel.drinks;

    JList<Drink> tempList = new JList<>();
    DefaultListModel<Drink> tempModel = new DefaultListModel<>();
    JList<String> listOfDrinks = new JList<>();
    DefaultListModel<String> model = new DefaultListModel<>();


    public EastPanel() {

        setPanelDimensions();

        loadDrinks();

        tempList.setModel(tempModel);
        listOfDrinks.setModel(model);

        for (Drink d: drinks) {
            tempModel.addElement(d);
        }

        for (int k = 0; k < tempModel.size(); k++) {
            model.addElement(tempModel.get(k).getFullName());
        }

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First column ///////////////////////

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;

        add(listOfDrinks,gc);
    }

    private void setPanelDimensions() {
        Dimension size = getPreferredSize();
        size.width = 250;
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
}

package ui;


import model.Drink;
import model.DrinkList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import persistence.Reader;
import persistence.Writer;
import ui.CenterPanel;

import ui.DrinkApp;

public class EastPanel extends JPanel {

    private static final String DRINKS_FILE = "./data/testDrinks.txt";

    DrinkList bbtList = CenterPanel.bbtList;

    LinkedList<Drink> drinks = CenterPanel.drinks;


    public EastPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        loadDrinks();

        JList<Drink> tempList = new JList<>();
        DefaultListModel<Drink> tempModel = new DefaultListModel<>();
        JList<String> listOfDrinks = new JList<>();
        DefaultListModel<String> model = new DefaultListModel<>();

        tempList.setModel(tempModel);
        listOfDrinks.setModel(model);

        for (Drink d: drinks) {
            tempModel.addElement(d);
        }

        for (int k = 0; k < tempModel.size(); k++) {
            model.addElement(tempModel.get(k).getFullName());
        }


        JButton saveButton = new JButton("Save");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First column ///////////////////////

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;

        add(listOfDrinks,gc);

        gc.gridx = 0;
        gc.gridy = 1;

        add(saveButton,gc);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDrinks();
                
                // fire main menu
            }
        });
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


    // EFFECTS: saves the current drink list to DRINKS_FILE
    private void saveDrinks() {
        try {
            Writer writer = new Writer(new File(DRINKS_FILE));

            for (Drink d : drinks) {
                writer.write(new Drink(d.getSize(), d.getFlavour(),d.getSugarLevel(), d.getTopping(),
                        d.getCalories(), d.getPrice()));
            }

            writer.close();
            System.out.println("Drinks saved to file " + DRINKS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save drinks to " + DRINKS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }
}

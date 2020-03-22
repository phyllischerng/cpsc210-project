package ui;


import model.DrinkList;

import javax.swing.*;
import java.awt.*;

import ui.DrinkApp;

public class EastPanel extends JPanel {

    //string array that takes the leements of drink list


    private String[] drinkListStringArray = {"Drink 1", "Drink 2", "Drink 3","Drink 4",
            "Drink 5", "M GREEN TEA WITH PEARLS"};

    public EastPanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JList drinkList = new JList(drinkListStringArray);
        JButton saveButton = new JButton("Save");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First column ///////////////////////

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;

        add(drinkList,gc);

        gc.gridx = 0;
        gc.gridy = 1;

        add(saveButton,gc);
    }
}

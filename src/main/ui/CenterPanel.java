package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import model.Drink;
import model.DrinkList;
import persistence.Reader;
import persistence.Writer;


public class CenterPanel extends JPanel {

    GridBagConstraints gc;

    String size;
    String flavour;
    int sugarLevel;
    String topping;
    int calories;
    double price;



    JButton addButton;

    JLabel askSize;
    JLabel askFlavour;
    JLabel askSugar;
    JLabel askTopping;
    JLabel askCalories;
    JLabel askPrice;

    JButton medButton;
    JButton largeButton;

    JButton blackTeaButton;
    JButton greenTeaButton;
    JButton noSugarButton;
    JButton thirtySugarButton;
    JButton fiftySugarButton;
    JButton seventySugarButton;
    JButton fullSugarButton;
    JButton extraSugarButton;

    JButton pearlsButton;
    JButton grassJellyButton;

    JTextField caloriesField;
    JButton caloriesSubmitButton;

    JTextField priceField;
    JButton priceSubmitButton;

    protected static DrinkList bbtList = new DrinkList();

    protected static LinkedList<Drink> drinks;

    private static final String DRINKS_FILE = "./data/testDrinks.txt";




    public CenterPanel() {
        Dimension size = getPreferredSize();
        size.width = 600;
        setPreferredSize(size);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        initializeComponents();
        fireMainMenu();
    }

    public void initializeComponents() {
        addButton = new JButton("Add drink");

        // Size
        askSize = new JLabel("What size is your drink?");
        medButton = new JButton("Medium");
        largeButton = new JButton("Large");

        // Flavour
        askFlavour = new JLabel("What flavour is your drink?");
        blackTeaButton = new JButton("Black Tea");
        greenTeaButton = new JButton("Green Tea");

        // Sugar Level
        askSugar = new JLabel("What is the sugar level of your drink?");
        noSugarButton = new JButton("0%");
        thirtySugarButton = new JButton("30%");
        fiftySugarButton = new JButton("50%");
        seventySugarButton = new JButton("70%");
        fullSugarButton = new JButton("100%");
        extraSugarButton = new JButton("120%");

        // Topping
        askTopping = new JLabel("What topping is in your drink?");
        pearlsButton = new JButton("Pearls");
        grassJellyButton = new JButton("Grass Jelly");

        // Calories
        askCalories = new JLabel("How many calories is in your drink?");
        caloriesField = new JTextField(10);
        caloriesSubmitButton = new JButton("Submit");

        // Price
        askPrice = new JLabel("How much does your drink cost?");
        priceField = new JTextField(10);
        priceSubmitButton = new JButton("Submit");
    }

    public void fireMainMenu() {
        loadDrinks();

        addButton.setVisible(true);
        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 1;

        // Initialize Add Button
        gc.gridx = 0;
        gc.gridy = 0;
        add(addButton,gc);

        // Initialize Components
        initializeAskComponents();
        initializeSizeFlavourToppingComponents();
        initializeSugarCaloriesPriceComponents();
        initializeSubmitButtons();



        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireSizeEvent();
            }
        });
    }

    public void initializeAskComponents() {
        gc.gridx = 1;
        gc.gridy = 0;
        add(askSize,gc);
        askSize.setVisible(false);
        add(askFlavour,gc);
        askFlavour.setVisible(false);
        add(askSugar,gc);
        askSugar.setVisible(false);
        add(askTopping,gc);
        askTopping.setVisible(false);
        add(askCalories,gc);
        askCalories.setVisible(false);
        add(askPrice,gc);
        askPrice.setVisible(false);
    }

    public void initializeSizeFlavourToppingComponents() {
        gc.gridx = 0;
        gc.gridy = 2;
        add(medButton,gc);
        medButton.setVisible(false);
        add(blackTeaButton,gc);
        blackTeaButton.setVisible(false);
        add(pearlsButton,gc);
        pearlsButton.setVisible(false);

        gc.gridx = 2;
        gc.gridy = 2;
        add(largeButton,gc);
        largeButton.setVisible(false);
        add(greenTeaButton,gc);
        greenTeaButton.setVisible(false);
        add(grassJellyButton,gc);
        grassJellyButton.setVisible(false);
    }

    public void initializeSugarCaloriesPriceComponents() {
        gc.gridx = 0;
        gc.gridy = 1;
        add(noSugarButton,gc);
        noSugarButton.setVisible(false);
        add(caloriesField,gc);
        caloriesField.setVisible(false);
        add(priceField,gc);
        priceField.setVisible(false);
        gc.gridy = 2;
        add(thirtySugarButton,gc);
        thirtySugarButton.setVisible(false);
        gc.gridy = 3;
        add(fiftySugarButton,gc);
        fiftySugarButton.setVisible(false);
        gc.gridy = 4;
        add(seventySugarButton,gc);
        seventySugarButton.setVisible(false);
        gc.gridy = 5;
        add(fullSugarButton,gc);
        fullSugarButton.setVisible(false);
        gc.gridy = 6;
        add(extraSugarButton,gc);
        extraSugarButton.setVisible(false);
    }

    public void initializeSubmitButtons() {
        gc.gridx = 1;
        gc.gridy = 1;
        add(caloriesSubmitButton,gc);
        caloriesSubmitButton.setVisible(false);
        add(priceSubmitButton,gc);
        priceSubmitButton.setVisible(false);
    }

    public void fireSizeEvent() {
        addButton.setVisible(false);
        askSize.setVisible(true);
        medButton.setVisible(true);
        largeButton.setVisible(true);


        // if M is pressed
        medButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = "M";
                fireFlavourEvent();
            }
        });

        // if L is pressed
        largeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = "L";
                fireFlavourEvent();
            }
        });

    }

    public void fireFlavourEvent() {
        medButton.setVisible(false);
        largeButton.setVisible(false);
        askSize.setVisible(false);

        blackTeaButton.setVisible(true);
        greenTeaButton.setVisible(true);
        askFlavour.setVisible(true);

        // if B is pressed
        blackTeaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flavour = "BLACK TEA";
                fireSugarEvent();
            }
        });


        // if G is pressed
        greenTeaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flavour = "GREEN TEA";
                fireSugarEvent();
            }
        });

    }

    public void fireSugarEvent() {
        toggleFireSugarEventVisibility();
        toggleZeroToFiftySugarButton();
        toggleSeventyToExtraSugarButton();

    }

    public void toggleZeroToFiftySugarButton() {
        // if 0 is pressed
        noSugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sugarLevel = 0;
                fireToppingEvent();
            }
        });
        // if 30 is pressed
        thirtySugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sugarLevel = 30;
                fireToppingEvent();
            }
        });

        // if 50 is pressed
        fiftySugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sugarLevel = 50;
                fireToppingEvent();
            }
        });
    }

    public void toggleSeventyToExtraSugarButton() {
        // if 70 is pressed
        seventySugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sugarLevel = 70;
                fireToppingEvent();
            }
        });

        // if 100 is pressed
        fullSugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sugarLevel = 100;
                fireToppingEvent();
            }
        });
        // if 120 is pressed
        extraSugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sugarLevel = 120;
                fireToppingEvent();
            }
        });
    }

    public void toggleFireSugarEventVisibility() {
        blackTeaButton.setVisible(false);
        greenTeaButton.setVisible(false);
        askFlavour.setVisible(false);

        askSugar.setVisible(true);
        noSugarButton.setVisible(true);
        thirtySugarButton.setVisible(true);
        fiftySugarButton.setVisible(true);
        seventySugarButton.setVisible(true);
        fullSugarButton.setVisible(true);
        extraSugarButton.setVisible(true);
    }

    public void fireToppingEvent() {
        toggleFireToppingEventVisibility();


        // if pearls
        pearlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping = "Pearls";
                fireCaloriesEvent();
            }
        });


        // if grass jelly
        grassJellyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topping = "Grass Jelly";
                fireCaloriesEvent();
            }
        });

    }

    public void toggleFireToppingEventVisibility() {
        askSugar.setVisible(false);
        noSugarButton.setVisible(false);
        thirtySugarButton.setVisible(false);
        fiftySugarButton.setVisible(false);
        seventySugarButton.setVisible(false);
        fullSugarButton.setVisible(false);
        extraSugarButton.setVisible(false);

        pearlsButton.setVisible(true);
        grassJellyButton.setVisible(true);
        askTopping.setVisible(true);
    }

    public void fireCaloriesEvent() {
        pearlsButton.setVisible(false);
        grassJellyButton.setVisible(false);
        askTopping.setVisible(false);

        askCalories.setVisible(true);
        caloriesField.setVisible(true);
        caloriesSubmitButton.setVisible(true);

        // if submit button is pressed
        caloriesSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calories = Integer.parseInt(caloriesField.getText());
                firePriceEvent();
            }
        });
    }

    public void firePriceEvent() {
        askCalories.setVisible(false);
        caloriesField.setVisible(false);
        caloriesSubmitButton.setVisible(false);

        askPrice.setVisible(true);
        priceField.setVisible(true);
        priceSubmitButton.setVisible(true);

        // if submit button is pressed
        priceSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                price = Double.parseDouble(priceField.getText());
                fireProcessDrink();

                //play an audio
                playSound("ding.wav");

            }
        });
    }

    public void fireProcessDrink() {
        bbtList.addDrink(new Drink(size, flavour, sugarLevel, topping, calories, price));
        drinks.add(new Drink(size, flavour, sugarLevel, topping, calories, price));
        saveDrinks();
//        fireMainMenu();
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
            // writer = writer + \n and then the new drinks??


            for (Drink d : drinks) {
                writer.write(new Drink(d.getSize(), d.getFlavour(),d.getSugarLevel(), d.getTopping(),
                        d.getCalories(), d.getPrice()));
            }
            // for loop over drinks

            writer.close();
            System.out.println("Drinks saved to file " + DRINKS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save drinks to " + DRINKS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }



}

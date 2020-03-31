package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private WestPanel totalPanel;
    private EastPanel drinkListPanel;
    private CenterPanel centerPanel;

    private static final String DRINKS_FILE = "./data/testDrinks.txt";


    public MainFrame(String title) {
        super(title);

        // Set layout manager
        setLayout(new BorderLayout());

        // Adding a panel
        totalPanel = new WestPanel();
        drinkListPanel = new EastPanel();
        centerPanel = new CenterPanel();


        // Add Swing components to content pane
        Container c = getContentPane();
        c.add(totalPanel,BorderLayout.WEST);
        c.add(drinkListPanel,BorderLayout.EAST);
        c.add(centerPanel,BorderLayout.CENTER);

        // Add behaviour

        // Add Panels to Frame






    }

}

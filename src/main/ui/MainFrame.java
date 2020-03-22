package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;
    private WestPanel totalPanel;
    private EastPanel drinkListPanel;
    private CenterPanel centerPanel;

    public MainFrame(String title) {
        super(title);

        // Set layout manager
        setLayout(new BorderLayout());



        // Create Swing components
        final JTextArea textArea = new JTextArea();
        JButton addDrinkButton = new JButton("Click me!");

        detailsPanel = new DetailsPanel();
        detailsPanel.addDetailListener(new DetailListener() {
            @Override
            public void detailEventOccurred(DetailEvent event) {
                String text = event.getText();
                textArea.append(text);

            }
        });


        // Adding a panel
        detailsPanel = new DetailsPanel();
        totalPanel = new WestPanel();
        drinkListPanel = new EastPanel();
        centerPanel = new CenterPanel();


        // Add Swing components to content pane
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(addDrinkButton, BorderLayout.SOUTH);
    //    c.add(detailsPanel,BorderLayout.WEST);
        c.add(totalPanel,BorderLayout.WEST);
        c.add(drinkListPanel,BorderLayout.EAST);
        c.add(centerPanel,BorderLayout.CENTER);

        // Add behaviour
        addDrinkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // steps to adding a drink
                //

            }
        });




    }

}

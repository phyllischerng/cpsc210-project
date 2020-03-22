package ui;

import javax.swing.*;
import java.awt.*;

public class WestPanel extends JPanel {
    public WestPanel() {
        Dimension size = getPreferredSize();
        size.width = 200;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel totalMoneyLabel = new JLabel("Total Money Spent: ");
        JLabel totalCaloriesLabel = new JLabel("Total Calories Consumed: ");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First column ///////////////////

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;

        add(totalMoneyLabel,gc);

        gc.gridx = 0;
        gc. gridy = 1;
        add(totalCaloriesLabel,gc);



    }
}

package ui;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    public CenterPanel() {
        Dimension size = getPreferredSize();
        size.width = 600;
        setPreferredSize(size);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton addButton = new JButton("Add drink");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //// First column ///////////////

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        add(addButton,gc);

    }
}

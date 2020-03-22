package ui;

import javax.swing.*;

public class DrinkGUI extends JFrame {



    public static void main(String[] args) {
        //new DrinkApp();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame("Bubble Tea Tracker");

                frame.setSize(1000,500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });





    }

}

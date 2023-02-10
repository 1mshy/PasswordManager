package com.imshy.GUI;

import com.imshy.GUI.Buttons.ExitButton;
import javax.swing.*;

public class GUI extends JFrame {
    private static GUI gui = new com.imshy.GUI.GUI();
    private JList<JButton> mainMenu;
    private GUI() {
        setUpMainMenu();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500,400);
        setVisible(true);

    }
    public void getRThing()
    {

    }
    public static GUI getInstance()
    {
        return gui;
    }

    private void setUpMainMenu() {
        mainMenu = new MainMenu();
        add(mainMenu);
    }

    private void setUpExitButton()
    {
        add(new ExitButton());
    }

}

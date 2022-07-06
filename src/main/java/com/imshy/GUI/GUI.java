package com.imshy.GUI;

import com.imshy.GUI.Buttons.ExitButton;

import javax.swing.*;

public class GUI extends JFrame {
    private JMenu MAIN_MENU;

    public GUI() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setBounds(0, 0, 300 ,200);
    }

    private void setUpMainMenu() {
        MAIN_MENU = new JMenu();
        MAIN_MENU.add(new MainMenu());
    }

}

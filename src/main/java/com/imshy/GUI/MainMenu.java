package com.imshy.GUI;

import com.imshy.GUI.Buttons.ExitButton;

import javax.swing.*;

public class MainMenu extends JMenu {
    public MainMenu()
    {
        this.setVisible(true);
        this.add(new ExitButton());
    }
}

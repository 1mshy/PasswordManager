package com.imshy.GUI;

import com.imshy.GUI.Buttons.ExitButton;

import javax.swing.*;

public class MainMenu extends JList<JButton> {
    public MainMenu()
    {
        this.setVisible(true);
        this.add(new ExitButton());
        var dim = GUI.getInstance();

//        setLocation(dim.width/2, dim.height/2);
    }
}

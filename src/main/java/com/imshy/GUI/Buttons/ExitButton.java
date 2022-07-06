package com.imshy.GUI.Buttons;

import com.imshy.GUI.Actions.ExitAction;

import javax.swing.*;

public class ExitButton extends JButton {
    public ExitButton()
    {
        this.setVisible(true);
        this.setText("Exit");
        this.setAction(new ExitAction());
    }
}

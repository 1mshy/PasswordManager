package com.imshy.GUI.Buttons;

import com.imshy.GUI.Actions.ExitAction;

import javax.swing.*;

public class ExitButton extends JButton {
    public ExitButton()
    {
        this.setText("Exit");
        this.addActionListener(e -> action());
        this.setBounds(130, 130, 100, 40);
    }

    private void action()
    {
        System.out.println("Damn you just clicked the exit button;!");
    }
}

package com.imshy.UserInterface.Prompt.elements;

public abstract class Choice {
    final String choice;

    public Choice(String choice)
    {
        this.choice = choice;
    }
    @Override
    public abstract String toString();

}

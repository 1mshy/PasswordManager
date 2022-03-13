package com.imshy.UserInterface.Prompt.elements;

public class ListChoice extends Choice{
    private final int number;
    public ListChoice(String choice, int number) {
        super(choice);
        this.number = number;

    }
    private String addNumber(String value)
    {
        // 1. choice
        return number + ". " + value;
    }
    @Override
    public String toString()
    {
        return addNumber(choice);
    }
    
}

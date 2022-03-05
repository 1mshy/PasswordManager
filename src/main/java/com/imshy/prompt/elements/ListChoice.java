package com.imshy.prompt.elements;

import javax.annotation.processing.Generated;
import java.beans.JavaBean;
import java.beans.Transient;

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

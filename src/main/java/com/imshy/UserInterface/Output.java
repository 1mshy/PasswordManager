package com.imshy.UserInterface;

import com.imshy.UserInterface.Prompt.Prompt;

public class Output {
    public void printPrompt(Prompt prompt)
    {
        System.out.println(prompt.structurePrompt());
    }
}

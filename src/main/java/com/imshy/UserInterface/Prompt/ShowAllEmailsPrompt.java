package com.imshy.UserInterface.Prompt;

public class ShowAllEmailsPrompt implements Prompt{

    @Override
    public String structurePrompt() {
        return "Input the domain you wish to see all the emails from: ";
    }
}

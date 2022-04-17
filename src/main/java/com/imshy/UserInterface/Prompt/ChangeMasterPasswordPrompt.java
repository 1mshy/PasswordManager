package com.imshy.UserInterface.Prompt;

public class ChangeMasterPasswordPrompt implements Prompt{
    @Override
    public String structurePrompt() {
        return "Enter the new master password: ";
    }
}

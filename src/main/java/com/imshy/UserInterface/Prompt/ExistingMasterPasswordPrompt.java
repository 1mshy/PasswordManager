package com.imshy.UserInterface.Prompt;

public class ExistingMasterPasswordPrompt implements Prompt{

    @Override
    public String structurePrompt() {
        return "Enter the master password: ";
    }
}

package com.imshy.UserInterface.Prompt;

public class NewMasterPasswordPrompt implements Prompt{

    @Override
    public String structurePrompt() {
        return "Enter new master password: ";
    }
}

package com.imshy.UserInterface.Prompt;

public class NewMasterPasswordPrompt extends MasterPasswordPrompt {

    @Override
    public String structurePrompt() {
        return "Enter a new master password *IMPORTANT* If this password is forgotten, there is no getting back your saved passwords";
    }
}

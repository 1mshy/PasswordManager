package com.imshy.UserInterface.Prompt;

public class ShowPasswordPrompt implements Prompt {
    @Override
    public String structurePrompt() {
        return "Enter your credentials as follows: *source* *email*";
    }
}

package com.imshy.UserInterface.Prompt;

public class RemovePasswordPrompt implements Prompt {
    @Override
    public String structurePrompt() {
        return "Enter your credentials as follows: *email* *source* *password*";
    }
}

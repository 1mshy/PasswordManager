package com.imshy.UserInterface.Prompt;

import com.imshy.UserInterface.Prompt.Prompt;

public class AddPasswordPrompt implements Prompt {
    @Override
    public String structurePrompt() {
        return "Enter your credentials as follows: *email* *source* *password*";
    }
}

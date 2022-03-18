package com.imshy.UserInterface;

import com.imshy.UserInterface.Prompt.ListPrompt;
import com.imshy.UserInterface.Prompt.MainPrompt;
import com.imshy.UserInterface.Prompt.Prompt;

import java.util.*;

public class UI {
    public UI() {
    }
    public void start() {
        final Output OUTPUT = new Output();

        ListPrompt<String> mainPrompt = new MainPrompt();
        OUTPUT.printPrompt(mainPrompt);

        final Input INPUT = new Input();
        int chosen = INPUT.takeInputNumber(mainPrompt.getValues().size());


    }
}



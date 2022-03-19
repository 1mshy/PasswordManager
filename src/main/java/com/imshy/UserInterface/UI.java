package com.imshy.UserInterface;

import com.imshy.UserInterface.Prompt.ListPrompt;
import com.imshy.UserInterface.Prompt.MainPrompt;

public class UI {

    private final Output OUTPUT = new Output();
    private final Input INPUT = new Input();
    private final ListPrompt<String> MAIN_PROMPT = new MainPrompt();
    public void start() {
        printMainPrompt();
        int chosen = scanInputNumber();
    }

    public void printMainPrompt()
    {
        OUTPUT.printPrompt(MAIN_PROMPT);
    }
    private int scanInputNumber()
    {
        return INPUT.takeInputNumber(MAIN_PROMPT.size());
    }
    public ListPrompt<String> getMainPrompt()
    {
        return MAIN_PROMPT;
    }



}



package com.imshy.UserInterface;

import com.imshy.UserInterface.Prompt.ListPrompt;
import com.imshy.UserInterface.Prompt.MainPrompt;
import com.imshy.UserInterface.Prompt.OtherPrompt;

public class UI {

    private final Output OUTPUT = new Output();
    private final Input INPUT = new Input();
    private final ListPrompt<String> MAIN_PROMPT = new MainPrompt();
    private final ListPrompt<String> OTHER_PROMPT = new OtherPrompt();

    public int printMainAndScan() {
        printMainPrompt();
        return scanInputNumber(MAIN_PROMPT);
    }
    public int printOtherAndScan()
    {
        printOtherPrompt();
        return scanInputNumber(OTHER_PROMPT);
    }

    private void printMainPrompt() {
        OUTPUT.printPrompt(MAIN_PROMPT);
    }
    private void printOtherPrompt() {OUTPUT.printPrompt(OTHER_PROMPT);}

    private int scanInputNumber(ListPrompt<String> listPrompt) {
        return INPUT.takeInputNumber(listPrompt.size());
    }


    public ListPrompt<String> getMainPrompt() {
        return MAIN_PROMPT;
    }
}



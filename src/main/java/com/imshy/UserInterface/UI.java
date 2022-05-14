package com.imshy.UserInterface;

import com.imshy.UserInterface.Prompt.ListPrompt;
import com.imshy.UserInterface.Prompt.MainPrompt;
import com.imshy.UserInterface.Prompt.OtherPrompt;
import com.imshy.UserInterface.Prompt.Prompt;

public class UI {

    private final Output OUTPUT = new Output();
    private final Input INPUT = new Input();
    private final ListPrompt<String> MAIN_PROMPT = new MainPrompt();
    private final ListPrompt<String> OTHER_PROMPT = new OtherPrompt();

    public int printMainAndScan() {
        printMainPrompt();
        return scanInputNumber(MAIN_PROMPT);
    }

    public int printOtherAndScan() {
        printOtherPrompt();
        return scanInputNumber(OTHER_PROMPT);
    }

    public int printListPromptAndScan(ListPrompt<String> prompt) {
        printPrompt(prompt);
        return scanInputNumber(prompt);
    }

    public String printPromptAndScan(Prompt prompt) {
        printPrompt(prompt);
        return INPUT.scan();
    }

    public void printPrompt(Prompt prompt) {
        OUTPUT.printPrompt(prompt);
    }

    private void printMainPrompt() {
        printPrompt(MAIN_PROMPT);
    }

    private void printOtherPrompt() {
        printPrompt(OTHER_PROMPT);
    }

    private int scanInputNumber(ListPrompt<String> listPrompt) {
        return INPUT.takeInputNumber(listPrompt.size());
    }


    public ListPrompt<String> getMainPrompt() {
        return MAIN_PROMPT;
    }
}



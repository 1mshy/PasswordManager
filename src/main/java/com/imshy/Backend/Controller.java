package com.imshy.Backend;

import com.imshy.Backend.Prompts.AddPasswordPrompt;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Output;
import com.imshy.UserInterface.Prompt.MainPrompt;
import com.imshy.UserInterface.Prompt.Prompt;
import com.imshy.UserInterface.UI;


public class Controller {
    private static Controller instance;
    private static String[] args;

    public static Controller getInstance(String[] args) {
        if (instance == null) {
            instance = new Controller(args);
        }
        return instance;
    }

    private Controller(String[] args) {
        Controller.args = args;
    }

    public void run() {
        if (args.length > 0) {
            //TODO cli
        } else
        {
            scanAndExecute();
            System.exit(0);
        }
    }

    //shows the normal UI + takes input + executes the input
    private void scanAndExecute() {
        UI ui = new UI();
        ui.printMainPrompt();
        int chosen = ui.scanInputNumber();
        // -1 because input options start from 1, and arrays start from 0
        switch (MainPrompt.OPTION.values()[chosen - 1]) {
            case REMOVE_PASSWORD -> removePassword();
            case ADD_PASSWORD -> addPassword();
            case UPDATE_PASSWORD -> updatePassword();
        }

    }


    private void addPassword() {
        new Output().printPrompt(new AddPasswordPrompt());
        Input input = new Input();
        String[] credentials = input.takeCombo().split(" ");
    }
    private void removePassword() {
    }



    private void updatePassword() {

    }
}
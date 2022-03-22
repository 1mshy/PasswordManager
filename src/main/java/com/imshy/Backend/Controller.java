package com.imshy.Backend;

import com.imshy.UserInterface.Prompt.MainPrompt;
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
        UI ui = new UI();
        ui.printMainPrompt();
        int chosen = ui.scanInputNumber();
        // -1 because input options start from 1, and arrays start from 0
        switch (MainPrompt.OPTION.values()[chosen-1]) {
            case REMOVE_PASSWORD -> removePassword();
            case SAVE_PASSWORD  -> savePassword();
            case UPDATE_PASSWORD -> updatePassword();
        }
    }
    private void removePassword() {

    }
    private void savePassword() {

    }
    private void updatePassword() {

    }
}
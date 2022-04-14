package com.imshy.Backend;

import com.imshy.Backend.Password.*;
import com.imshy.UserInterface.Prompt.*;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Output;
import com.imshy.UserInterface.UI;


public class Controller {
    private static Controller instance;
    private final String[] args;
    private final FileManager fileManager;
    private final JsonTools jsonTools;

    public static Controller getInstance(String[] args) {
        if (instance == null) {
            instance = new Controller(args);
        }
        return instance;
    }

    private Controller(String[] args) {
        this.args = args;
        this.fileManager = new FileManager();
        this.jsonTools = new JsonTools();
    }

    public void run() {
        // domain - email - password
        if (args.length == 3) {
            cli();
            return;
        }
        MasterPassword masterPassword = new MasterPassword();
        String pass = obtainMasterPassword();
        masterPassword.setMasterPassword(pass);

        fileManager.instantiateFileIfMissing();
        masterPassword.exitIfIncorrectPassword();

        scanAndExecute();
        System.exit(0);
    }


    private void cli() {

    }

    private String obtainMasterPassword() {
        Output output = new Output();
        output.printPrompt(getCorrectMasterPrompt());
        Input input = new Input();
        return input.scan();
    }

    private MasterPasswordPrompt getCorrectMasterPrompt() {
        if (fileManager.passwordFileExists())
            return new MasterPasswordPrompt();
        return new NewMasterPasswordPrompt();
    }

    //shows the normal UI + takes input + executes the input
    private void scanAndExecute() {
        UI ui = new UI();
        ui.printMainPrompt();
        int chosen = ui.scanInputNumber();
        // -1 because input options start from 1, and arrays start from 0
        switch (MainPrompt.OPTION.values()[chosen - 1]) {
            case REMOVE_PASSWORD -> removePassword();
            case ADD_OR_UPDATE_PASSWORD -> addPassword();
            case SHOW_PASSWORD -> showPassword();
        }
    }

    private void printPrompt(Prompt prompt) {
        new Output().printPrompt(prompt);
    }

    private Combo getOutputs() {
        return getOutputs(3);
    }

    private Combo getOutputs(int segments) {
        return new Input().takeCombo(segments);
    }

    private void addPassword() {
        printPrompt(new AddPasswordPrompt());
        Combo credentials = getOutputs();

        Password controls = new AddPassword(credentials);
        controls.runPasswordFunction();

    }


    private void removePassword() {
        final int SEGMENTS = 2;
        printPrompt(new RemovePasswordPrompt());
        Combo credentials = getOutputs(SEGMENTS);
        Password controls = new RemovePassword(credentials);
        controls.runPasswordFunction();
    }

    private void showPassword() {
        final int SEGMENTS = 2;
        printPrompt(new ShowPasswordPrompt());
        Combo credentials = getOutputs(SEGMENTS);
        Password controls = new ShowPassword(credentials);
        controls.runPasswordFunction();
    }
}
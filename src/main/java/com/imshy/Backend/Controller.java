package com.imshy.Backend;

import com.imshy.Backend.MasterPassword.MasterPassword;
import com.imshy.UserInterface.Prompt.AddPasswordPrompt;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Output;
import com.imshy.UserInterface.Prompt.MainPrompt;
import com.imshy.UserInterface.Prompt.NewMasterPasswordPrompt;
import com.imshy.UserInterface.UI;

import java.io.File;
import java.io.IOException;


public class Controller {
    private static Controller instance;
    private final String[] args;

    public static Controller getInstance(String[] args) {
        if (instance == null) {
            instance = new Controller(args);
        }
        return instance;
    }

    private Controller(String[] args) {
        this.args = args;
    }

    public void run() {
        // domain - email - password
        if (args.length == 3) {
            cli();
            return;
        }
        if (!new FileManager().passwordFileExists()) {
            try {
                createPasswordFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String pass = obtainMasterPassword();
        MasterPassword masterPassword = new MasterPassword();
        masterPassword.setMasterPassword(pass);
        
        scanAndExecute();
        System.exit(0);


    }

    private void cli() {

    }
    
    private void createPasswordFile() throws IOException {
        FileManager fileManager = new FileManager();
        File password = fileManager.getPasswordFile();
        File parent = password.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        password.createNewFile();
    }

    private String obtainMasterPassword() {
        Output output = new Output();
        output.printPrompt(new NewMasterPasswordPrompt());
        Input input = new Input();
        String masterPasswordString = input.scan();
        return masterPasswordString;
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
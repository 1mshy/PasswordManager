package com.imshy.Backend;

import com.google.gson.JsonObject;
import com.imshy.Backend.MasterPassword.MasterPassword;
import com.imshy.UserInterface.Prompt.*;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Output;
import com.imshy.UserInterface.UI;

import java.io.File;
import java.io.IOException;


public class Controller {
    private static Controller instance;
    private final String[] args;
    private final FileManager fileManager;

    public static Controller getInstance(String[] args) {
        if (instance == null) {
            instance = new Controller(args);
        }
        return instance;
    }

    private Controller(String[] args) {
        this.args = args;
        this.fileManager = new FileManager();
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

    private Combo printPromptAndGetValues(Prompt prompt) {
        new Output().printPrompt(prompt);
        return new Combo(new Input().takeCombo().split(" "));
    }

    private void addPassword() {
        Combo credentials = printPromptAndGetValues(new AddPasswordPrompt());

        JsonObject data = fileManager.getFileJson();
        if (!data.has(credentials.getDomain())) {
            data.add(credentials.getDomain(), new JsonObject());
        }
        JsonObject domain = data.get(credentials.getDomain()).getAsJsonObject();

        if (!domain.has(credentials.getEmail())) {
            domain.add(credentials.getEmail(), new JsonObject());
        }
        JsonObject email = data.get(credentials.getEmail()).getAsJsonObject();



    }

    private void removePassword() {

        Combo credentials = printPromptAndGetValues(new RemovePasswordPrompt());
    }

    private void updatePassword() {

        Combo credentials = printPromptAndGetValues(new UpdatePasswordPrompt());
    }
}
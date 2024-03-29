package com.imshy.Backend;

import com.imshy.Backend.Password.ChangeMasterPassword;
import com.imshy.Backend.Password.Functions.*;
import com.imshy.Backend.Password.MasterPassword;
import com.imshy.Encrypter.CustomEncryption;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Prompt.*;
import com.imshy.UserInterface.UI;

import java.util.NoSuchElementException;


public class Controller {
    private static Controller instance;
    private final FileManager fileManager;
    private final JsonTools jsonTools;
    private String[] args;


    private Controller() {
        this.fileManager = new FileManager();
        this.jsonTools = new JsonTools();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void run() {
        // domain - email - password
        if (args.length == 3) {
            cli();
            return;
        }

        String pass = obtainMasterPassword();
        MasterPassword masterPassword = MasterPassword.getInstance();
        masterPassword.setMasterPassword(pass);

        fileManager.instantiateFileIfMissing();
        masterPassword.exitIfIncorrectPassword();
        clearTerminal();
        loopMainPromptUntilError();
        exit();

    }

    private void loopMainPromptUntilError() {
        try {
            while (true) {
                executeMainPrompt();
                System.out.println();
                System.out.println();
            }
        }
        // happens when user clicks control C on keyboard to exit
        catch (NoSuchElementException e) {

            exit();
        }
    }

    private void exit() {
        // print before exit because user cancels on input message
        // else exit message will print on same line as input message
        System.out.println();
        System.out.println("Exitting...");
        System.exit(0);
    }


    private void cli() {

    }

    private String obtainMasterPassword() {
        return new UI().printPromptAndScan(getCorrectMasterPrompt());
    }

    private MasterPasswordPrompt getCorrectMasterPrompt() {
        if (fileManager.passwordFileExists())
            return new MasterPasswordPrompt();
        return new NewMasterPasswordPrompt();
    }

    // only works on windows for now
    public void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //shows the normal UI + takes input + executes the input
    private void executeMainPrompt() {
        UI ui = new UI();
        int chosen = ui.printMainAndScan();

        clearTerminal();
        // -1 because input options start from 1, and arrays start from 0
        switch (MainPrompt.MAIN_OPTIONS.values()[chosen - 1]) {
            case REMOVE_PASSWORD -> removePassword();
            case ADD_OR_UPDATE_PASSWORD -> addPassword();
            case SHOW_PASSWORD -> showPassword();
            case OTHER -> other();
        }
    }

    private void other() {
        UI ui = new UI();
        int chosen = ui.printOtherAndScan();

        switch (OtherPrompt.OTHER_OPTIONS.values()[chosen - 1]) {
            case CHANGE_MASTER_PASSWORD -> changeMasterPassword();
            case SHOW_ALL_DOMAINS -> showAllDomains();
            case SHOW_ALL_EMAILS -> showAllEmails();
            case EXPORT -> export();
            case IMPORT -> importPasswords();
        }
    }

    private void importPasswords() {

    }

    private void export() {
        AbstractPassword export = new ExportPasswords(new Combo(new String[]{}));
        export.runPasswordFunction();
    }

    private void showAllEmails() {
        printPrompt(new ShowAllEmailsPrompt());
        String domain = new Input().scan();
        AbstractPassword showAllEmails = new ShowAllEmails(new Combo(new String[]{domain, "f", "f"}));
        showAllEmails.runPasswordFunction();
    }

    private void printPrompt(Prompt prompt) {
        new UI().printPrompt(prompt);
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

        AbstractPassword controls = new AddPassword(credentials);
        controls.runPasswordFunction();
    }

    private void showAllDomains() {
        AbstractPassword showAllDomains = new ShowAllDomains();
        showAllDomains.runPasswordFunction();
    }

    private void changeMasterPassword() {
        ChangeMasterPassword changeMasterPassword = new ChangeMasterPassword();
        changeMasterPassword.changeMasterPassword();
    }

    private void removePassword() {
        final int SEGMENTS = 2;
        printPrompt(new RemovePasswordPrompt());
        Combo credentials = getOutputs(SEGMENTS);
        AbstractPassword controls = new RemovePassword(credentials);
        controls.runPasswordFunction();
    }

    private void showPassword() {
        final int SEGMENTS = 1;
        printPrompt(new ShowPasswordPrompt());
        Combo credentials = getOutputs(SEGMENTS);
        AbstractPassword controls = new ShowPassword(credentials);
        controls.runPasswordFunction();
    }
}
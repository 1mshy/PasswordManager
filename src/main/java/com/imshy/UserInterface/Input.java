package com.imshy.UserInterface;

import java.util.Objects;
import java.util.Scanner;

public class Input {

    private final Scanner SC = new Scanner(System.in);
    private final String DEFAULT_INPUT_MESSAGE = "Input: ";

    public int takeInputNumber(int end) {
        return takeInputNumber(1, end);
    }


    public String scan() {
        return SC.nextLine();
    }

    // IMPORTANT
    // function will cease the program if input is "exit" or "quit"
    public int takeInputNumber(int start, int end) {
        int scannedInt = Integer.MIN_VALUE;
        printDefaultInputMessage();
        while (scannedInt == Integer.MIN_VALUE || scannedInt < start || scannedInt > end) {
            try {
                String input = SC.nextLine();
                isQuitMessage(input);
                scannedInt = Integer.parseInt(input);
                if (scannedInt < start || scannedInt > end)
                    throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.printf("Please input an integer between %d and %d: ", start, end);
            }
        }
        return scannedInt;
    }

    // no new line character
    private void printDefaultInputMessage() {
        System.out.print(DEFAULT_INPUT_MESSAGE);
    }

    // IMPORTANT ONLY USE WHEN USER INPUTS
    // *email* *source* *password*
    public String takeCombo() {
        CheckUserInputs checkUserInputs = new CheckUserInputs();
        String input = null;

        while (checkUserInputs.malformedComboInput(input)) {
            printDefaultInputMessage();
            input = SC.nextLine();
        }
        return input;
    }


    private void isQuitMessage(String s) {
        if (Objects.equals(s, "quit") || Objects.equals(s, "exit")) {
            System.out.println("Exiting now...");
            System.exit(0);
        }
    }
}

package com.imshy.UserInterface;

import java.util.Objects;
import java.util.Scanner;

public class Input {

    int takeInputNumber(int end) {
        return takeInputNumber(1, end);
    }

    int takeInputNumber(int start, int end) {
        Scanner sc = new Scanner(System.in);
        int scannedInt = Integer.MIN_VALUE;
        System.out.print("Input: ");
        while (scannedInt == Integer.MIN_VALUE || scannedInt < start || scannedInt > end) {
            try {
                String input = sc.nextLine();
                isQuit(input);
                scannedInt = Integer.parseInt(input);
                if (scannedInt < start || scannedInt > end)
                    throw new IllegalArgumentException();
            } catch (NumberFormatException e) {
                System.err.print("Please input an integer: ");
            } catch (IllegalArgumentException e) {
                System.err.printf("Please input an integer between %d and %d: ", start, end);
            }
        }
        sc.close();
        return scannedInt;
    }

    private void isQuit(String s) {
        if (Objects.equals(s, "quit"))
        {
            System.out.println("Exiting now...");
            System.exit(0);
        }
    }
}

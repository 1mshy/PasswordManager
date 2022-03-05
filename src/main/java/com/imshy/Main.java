package com.imshy;

import com.imshy.prompt.ListPrompt;
import com.imshy.prompt.Prompt;

import java.util.ArrayList;

public class Main {
    /*
    * Program will take in a master key that will be used to decrypt the file.
    * The user then can interact with the passwords, add, remove, update (remove -> add) */

    public static void main(String[] args) {
        UI ui = new UI();
        ui.start();
    }
}

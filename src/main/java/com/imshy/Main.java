package com.imshy;

import com.imshy.prompt.AbstractPrompt;
import com.imshy.prompt.ListPrompt;
import com.imshy.prompt.elements.Choice;
import com.imshy.prompt.elements.ListChoice;

import java.util.ArrayList;

public class Main {
    /*
    * Program will take in a master key that will be used to decrypt the file.
    * The user then can interact with the passwords, add, remove, update (remove -> add) */

    public static void main(String[] args) {
        AbstractPrompt<String> a = new ListPrompt<>(new ArrayList<>());
    }
}

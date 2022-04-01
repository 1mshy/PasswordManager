package com.imshy;

import com.imshy.Backend.Controller;
import com.imshy.Encrypter.SHA256;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {
    /*
     * Program will take in a master key that will be used to decrypt the file.
     * The user then can interact with the passwords, add, remove, update (remove -> add)
     */

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Controller controller = Controller.getInstance(args);
        controller.run();

    }
}

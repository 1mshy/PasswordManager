package com.imshy.Backend.Errors;

public class WrongMasterPasswordException extends IllegalArgumentException{
    public WrongMasterPasswordException()
    {
        //when user inputs the wrong master password
        System.err.println("Sorry, but the master password you inputted is incorrect, or the contents of the password file have been altered.");
        System.out.println("Exiting...");
        System.exit(0);

    }
}

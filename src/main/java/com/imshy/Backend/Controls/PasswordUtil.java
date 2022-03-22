package com.imshy.Backend.Controls;

import java.io.File;

public abstract class PasswordUtil {
    public File getPasswordFile()
    {
        return new File("src/main/resources/passwords.txt");
    }

}

package com.imshy.Backend.Password;

import com.imshy.Backend.FileManager;
import com.imshy.Backend.JsonTools;
import com.imshy.Encrypter.XorEncrypter;

public class MasterPassword {
    private String masterPassword;

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
        XorEncrypter.getInstance().setKeyAndSalt(masterPassword);
    }

    public void exitIfIncorrectPassword()
    {
        JsonTools jsonTools = new JsonTools();
        FileManager fileManager = new FileManager();
        jsonTools.validateJson(fileManager.getUnenctryptedFileData());
    }
}

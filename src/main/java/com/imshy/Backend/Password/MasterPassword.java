package com.imshy.Backend.Password;

import com.imshy.Backend.FileManager;
import com.imshy.Backend.JsonTools;
import com.imshy.Encrypter.CustomEncryption;
import com.imshy.Encrypter.Xor;

public class MasterPassword {
    private static MasterPassword instance;

    private MasterPassword() {

    }

    public static MasterPassword getInstance() {
        if (instance == null)
            instance = new MasterPassword();
        return instance;
    }

    public void setMasterPassword(String masterPassword) {
        String hashedPass = new CustomEncryption().hash(masterPassword);
        Xor.getInstance().setKey(hashedPass);
    }

    public void exitIfIncorrectPassword() {
        JsonTools jsonTools = new JsonTools();
        FileManager fileManager = new FileManager();
        jsonTools.validateJson(fileManager.getUnenctryptedFileData());
    }
}

package com.imshy.Backend;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.imshy.Backend.Errors.WrongMasterPasswordException;
import com.imshy.Encrypter.XorEncrypter;

import java.io.IOException;

public class PasswordUtil {
    private final FileManager fileManager = new FileManager();
    private final XorEncrypter xorEncrypter = XorEncrypter.getInstance();
    private String UnencryptedFileData;

    public String retrieveUnenctryptedFileData() {
        //series of tests that validates the master password correctly decrypted the data
        String data;
        String unencryptedData = "";
        try {
            data = fileManager.getFileData();
            unencryptedData = xorEncrypter.decrypt(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        validateJson(unencryptedData);
        // program will shut down if there was an error
        return unencryptedData;
    }
    private void validateJson(String json)
    {
        // void as a false flag would never occur
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException e) {
            throw new WrongMasterPasswordException();
        }
    }

}

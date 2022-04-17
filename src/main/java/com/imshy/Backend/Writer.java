package com.imshy.Backend;

import com.google.gson.JsonObject;
import com.imshy.Encrypter.Xor;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final FileManager fileManager = new FileManager();

    private void write(String content) throws IOException {
        FileWriter fileWriter = new FileWriter(fileManager.getPasswordFile());
        fileWriter.write(content);
        fileWriter.close();
    }
    private void write(JsonObject jsonObject) throws IOException {
            write(jsonObject.toString());
    }
    // These methods exist soley for debugging
    public void writeToFile(String content)
    {
        try {
            write(content);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error when trying to write to password file. Exitting...");
            System.exit(1);
        }
    }
    public void writeToFile(JsonObject jsonObject)
    {
        writeToFile(jsonObject.toString());
    }
    //

    public void encryptAndWriteToFile(String data)
    {
        String encryptedData = Xor.getInstance().encrypt(data);
        writeToFile(encryptedData);
    }
    public void encryptAndWriteToFile(JsonObject jsonObject)
    {
        encryptAndWriteToFile(jsonObject.toString());
    }



}

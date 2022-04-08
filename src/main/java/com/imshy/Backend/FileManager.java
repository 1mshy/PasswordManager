package com.imshy.Backend;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    public File getPasswordFile() {
        return new File("passwords.txt");
    }

    public boolean passwordFileExists() {
        return getPasswordFile().exists();
    }

    private BufferedReader getFileBuffer() throws IOException {
        return new BufferedReader(new FileReader(getPasswordFile()));
    }

    public String getFileData() throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = getFileBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public String tryGetFileData() {
        String data = "Ratatouille";
        try {
            data = getFileData();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Could not read the password file. Exitting now.");
            System.exit(1);
        }

        return data;

    }

    public JsonObject getFileJson() {
        return JsonParser.parseString(tryGetFileData()).getAsJsonObject();
    }


}

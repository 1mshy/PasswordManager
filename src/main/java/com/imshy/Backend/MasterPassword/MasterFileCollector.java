package com.imshy.Backend.MasterPassword;

import java.io.*;

public class MasterFileCollector {
    private final String masterFilePath;
    private final String masterFileName;

    public MasterFileCollector() {
        this.masterFileName = "master.txt";
        this.masterFilePath = System.getProperty("user.home") + "/Documents/" + masterFileName;
    }

    public String getMasterFilePath() {
        return masterFilePath;
    }

    public String getMasterFileName() {
        return masterFileName;
    }
    String readPassword() throws IOException {
        String path = getMasterFilePath();
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String firstLine = reader.readLine();
        reader.close();
        return firstLine;
    }
    private void writePassword(String password) throws IOException {
        String path = getMasterFilePath();
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(password);
        fileWriter.close();
    }
    public void updatePassword(String password) throws IOException {
        writePassword(password);
    }
}

package com.imshy.Backend.MasterPassword;

import java.io.*;

public class MasterFileCollector {
    private final String masterFileName;
    private final String userHomePath;
    private final String masterPath;
    private final String masterFilePath;



    public MasterFileCollector() {
        this.masterFileName = "poker";
        this.userHomePath = System.getProperty("user.home");
        this.masterPath = userHomePath + "/Documents/";
        this.masterFilePath = masterPath + masterFileName;

        createMasterFileIfMissing();
    }

    private void createMasterFileIfMissing() {
        try {
            File file = new File(masterFilePath);
            if (!file.exists()) {
                createPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create master file");
        }
    }
    private void createPath() throws IOException {
        createFolders();

        File file = new File(masterFilePath);
        file.createNewFile();
    }
    private void createFolders() {
        File file = new File(masterPath);
        file.mkdirs();
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

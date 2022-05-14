package com.imshy.Backend;

import com.imshy.Encrypter.Xor;

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

    public void instantiateFileIfMissing() {
        if (!new FileManager().passwordFileExists()) {
            try {
                createPasswordFile();
                writeInitialJson();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void writeInitialJson() throws IOException {
        Writer writer = new Writer();
        writer.encryptAndWriteToFile("{}");
    }

    private void createPasswordFile() throws IOException {
        File password = getPasswordFile();
        File parent = password.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw new IllegalStateException("Couldn't create dir: " + parent);
        }
        password.createNewFile();
    }

    public String getUnenctryptedFileData() {
        //series of tests that validates the master password correctly decrypted the data
        String data;
        String unencryptedData = "";
        try {
            data = getFileData();
            unencryptedData = Xor.getInstance().decrypt(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new JsonTools().validateJson(unencryptedData);
        // program will shut down if there was an error
        return unencryptedData;
    }


    public String tryToGetFileData() {
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


}

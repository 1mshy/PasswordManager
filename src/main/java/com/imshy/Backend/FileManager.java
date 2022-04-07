package com.imshy.Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    public File getPasswordFile() {
        return new File("src/main/resources/passwords.txt");
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


}

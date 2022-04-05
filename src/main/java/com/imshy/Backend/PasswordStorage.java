package com.imshy.Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PasswordStorage {

    File getPasswordFile() {
        return new File("src/main/resources/passwords.txt");
    }

    private BufferedReader getFileBuffer() throws IOException
    {
        return new BufferedReader(new FileReader(getPasswordFile()));
    }

    public String getFileData(){

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = getFileBuffer()){
            String line;
            while((line = br.readLine()) != null)
            {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

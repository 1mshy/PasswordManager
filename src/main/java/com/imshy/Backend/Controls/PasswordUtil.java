package com.imshy.Backend.Controls;

import java.io.*;

public abstract class PasswordUtil {
    File getPasswordFile() {
        return new File("src/main/resources/passwords.txt");
    }

    BufferedReader getFileBuffer() throws IOException
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

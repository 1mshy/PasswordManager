package com.imshy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Single threaded Singleton
public class TaskManager {
    private static TaskManager instance;
    private TaskManager(){}
    public static TaskManager initialize()
    {
        if(instance == null) instance = new TaskManager();
        return instance;
    }
    public static void addPassword(String source, String email, String password) {

    }

    public String getPasswordFileLocation() {
        try (InputStream in = Main.class.getResourceAsStream("/PasswordFileLocation");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Stopping application due to issue with retrieving the file location of the passwords.");
            System.exit(1);
        }
        return null;
    }

    // function is run with the arguments taking in the main function
    public static void parseAndExecute(String[] args) {
        
    }
}

package com.imshy.Backend.Password.Functions;

import com.imshy.Backend.Combo;

import java.io.FileWriter;
import java.io.IOException;

public class ExportPasswords extends AbstractPassword{
    private final String fileName = "ExportedPasswords.json";
    public ExportPasswords(Combo combo) {
        super(combo);
    }

    @Override
    public void runPasswordFunction() {
        try {
            fileManager.createNewFile(fileName);
            FileWriter writer = new FileWriter(fileName);
            writer.write(jsonTools.getFileJson().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

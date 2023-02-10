package com.imshy.Backend.Password.Functions;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;
import com.imshy.Backend.JsonTools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Browse {
    private final String fileName = "ExportedPasswords.json";
    public Browse() {
    }

    public void browse() {
        JsonTools tools = new JsonTools();
        JsonObject data = tools.getFileJson();
        Set<String> keys = data.keySet();

        new ShowAllDomains().runPasswordFunction();
    }

}

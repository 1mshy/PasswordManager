package com.imshy.Backend;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.imshy.Backend.Errors.WrongMasterPasswordException;

public class JsonTools {
    private final FileManager fileManager;

    public JsonTools()
    {
        this.fileManager = new FileManager();
    }

    public void validateJson(String json)
    {
        // void as a false flag would never occur
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException e) {
            throw new WrongMasterPasswordException();
        }
    }
    public JsonObject getFileJson() {
        return JsonParser.parseString(fileManager.getUnenctryptedFileData()).getAsJsonObject();
    }


}

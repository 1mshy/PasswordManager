package com.imshy.Backend;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.imshy.Backend.Errors.WrongMasterPasswordException;

import java.util.Set;

public class JsonTools {
    private final FileManager fileManager;

    public JsonTools() {
        this.fileManager = new FileManager();
    }


    public JsonObject getFileJson() {
        return JsonParser.parseString(fileManager.getUnenctryptedFileData()).getAsJsonObject();
    }
    public Set<String> getDomains()
    {
        return this.getFileJson().keySet();
    }
    public void validateJson(String json) {
        // void as a false flag would never occur
        try {
            JsonParser.parseString(json);
            if(!json.chars().allMatch(this::isDefined))
                throw new WrongMasterPasswordException();
        } catch (JsonSyntaxException e) {
            throw new WrongMasterPasswordException();
        }
    }

    private boolean isDefined(int c)
    {
        return "!@#$%^&*()_+1234567890-=\\|~`qwertyuiop[]asdfghjkl;'zxcvbnm,.QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>)"
                .contains(String.valueOf((char)(c)));
    }

}

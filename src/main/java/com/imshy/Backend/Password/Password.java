package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;
import com.imshy.Backend.FileManager;
import com.imshy.Backend.JsonTools;
import com.imshy.Backend.Writer;

public abstract class Password {
    final FileManager fileManager = new FileManager();
    final JsonTools jsonTools = new JsonTools();
    final Writer writer = new Writer();
    final Combo combo;
    JsonObject data;

    public Password(Combo combo) {
        this.combo = combo;
        this.data = jsonTools.getFileJson();
    }

    JsonObject parseDomain() {
        return data.get(combo.getDomain()).getAsJsonObject();
    }

    JsonObject lazyParseDomain() {
        if (!data.has(combo.getDomain())) {
            data.add(combo.getDomain(), new JsonObject());
        }
        return parseDomain();
    }
    String parsePassword()
    {
        return lazyParseDomain().get(combo.getEmail()).getAsString();
    }
    String lazyParsePassword() {
        JsonObject domain = lazyParseDomain();

        if (!domain.has(combo.getEmail())) {
            domain.addProperty(combo.getEmail(), "NotARealPassword");
        }
        return parsePassword();
    }


    abstract public void runPasswordFunction();




}

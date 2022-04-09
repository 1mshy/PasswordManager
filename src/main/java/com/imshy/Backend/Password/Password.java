package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;
import com.imshy.Backend.FileManager;
import com.imshy.Backend.JsonTools;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Output;
import com.imshy.UserInterface.Prompt.AddPasswordPrompt;
import com.imshy.UserInterface.Prompt.Prompt;

public abstract class Password {
    private final FileManager fileManager = new FileManager();
    private final JsonTools jsonTools = new JsonTools();
    private final Combo combo;
    public Password(Combo combo)
    {
        this.combo = combo;
    }


    private Combo printPromptAndGetValues(Prompt prompt) {
        new Output().printPrompt(prompt);
        return new Combo(new Input().takeCombo().split(" "));
    }

    private void addPassword() {
        Combo credentials = printPromptAndGetValues(new AddPasswordPrompt());

        JsonObject data = jsonTools.getFileJson();
        if (!data.has(credentials.getDomain())) {
            data.add(credentials.getDomain(), new JsonObject());
            
        }
        JsonObject domain = data.get(credentials.getDomain()).getAsJsonObject();

        if (!domain.has(credentials.getEmail())) {
            domain.add(credentials.getEmail(), new JsonObject());
        }
        JsonObject email = data.get(credentials.getEmail()).getAsJsonObject();
    }

}

package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;
import com.imshy.Backend.JsonTools;
import com.imshy.Backend.Password.Functions.AbstractPassword;
import com.imshy.Backend.Writer;
import com.imshy.Encrypter.Xor;
import com.imshy.UserInterface.Input;
import com.imshy.UserInterface.Output;
import com.imshy.UserInterface.Prompt.ChangeMasterPasswordPrompt;

public class ChangeMasterPassword {

    public void changeMasterPassword()
    {
        new Output().printPrompt(new ChangeMasterPasswordPrompt());
        String masterPassword = new Input().scan();

        JsonTools tools = new JsonTools();
        JsonObject data = tools.getFileJson();

        Xor.getInstance().setKeyAndSalt(masterPassword);

        new Writer().encryptAndWriteToFile(data);
    }

}
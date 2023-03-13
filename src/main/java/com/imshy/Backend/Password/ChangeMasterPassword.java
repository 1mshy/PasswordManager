package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.JsonTools;
import com.imshy.Backend.Writer;
import com.imshy.Encrypter.Xor;
import com.imshy.UserInterface.Prompt.ChangeMasterPasswordPrompt;
import com.imshy.UserInterface.Prompt.MasterPasswordPrompt;
import com.imshy.UserInterface.UI;

public class ChangeMasterPassword {

    public void changeMasterPassword() {
        String newMasterPassword = new UI().printPromptAndScan(new ChangeMasterPasswordPrompt());

        JsonTools tools = new JsonTools();
        JsonObject data = tools.getFileJson();
        MasterPassword.getInstance().setMasterPassword(newMasterPassword);

        new Writer().encryptAndWriteToFile(data);
    }

}

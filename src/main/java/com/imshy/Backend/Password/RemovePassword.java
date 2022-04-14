package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;

public class RemovePassword extends Password{
    public RemovePassword(Combo combo) {
        super(combo);
    }

    @Override
    public void runPasswordFunction() {
        JsonObject domain = lazyParseDomain();

        if(domain.has(combo.getEmail()))
            domain.remove(combo.getEmail());

        writer.encryptAndWriteToFile(data);
    }

}

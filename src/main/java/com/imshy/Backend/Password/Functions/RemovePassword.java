package com.imshy.Backend.Password.Functions;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;

public class RemovePassword extends AbstractPassword {
    public RemovePassword(Combo combo) {
        super(combo);
    }

    @Override
    public void runPasswordFunction() {
        JsonObject domain = lazyParseDomain();

        if (domain.has(combo.getEmail()))
            domain.remove(combo.getEmail());

        writer.encryptAndWriteToFile(data);
    }

}

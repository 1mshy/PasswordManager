package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;

// adding a password will overrite any existing password for the same email under the same domain.
public class AddPassword extends Password {

    public AddPassword(Combo combo) {
        super(combo);
    }

    @Override
    public void runPasswordFunction() {
        // this command will directly alter the data object
        JsonObject domain = lazyParseDomain();
        if (domain.has(combo.getEmail()))
            domain.remove(combo.getEmail());
        domain.addProperty(combo.getEmail(), combo.getPassword());
        writer.encryptAndWriteToFile(data);
    }

}

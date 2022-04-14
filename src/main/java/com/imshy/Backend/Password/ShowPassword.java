package com.imshy.Backend.Password;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;

public class ShowPassword extends Password{
    public ShowPassword(Combo combo) {
        super(combo);
    }

    @Override
    public void runPasswordFunction() {
        JsonObject domain = lazyParseDomain();
        if(!domain.has(combo.getEmail()))
            return; // add error message
        System.out.printf("The password to '%s' is: %s", combo.getEmail(), lazyParsePassword());


    }
}

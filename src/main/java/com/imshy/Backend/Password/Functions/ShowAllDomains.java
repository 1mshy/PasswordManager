package com.imshy.Backend.Password.Functions;

import com.google.gson.JsonObject;
import com.imshy.Backend.Combo;

import java.util.Set;

public class ShowAllDomains extends AbstractPassword {

    public ShowAllDomains() {
        // just to make it not throw an error
        super(new Combo(new String[]{"f", "f", "f"}));
    }

    @Override
    public void runPasswordFunction() {
        JsonObject data = getData();
        Set<String> keys = data.keySet();
        if (keys.size() == 0)
            System.out.println("There are currently no domains, create a new password to make one");
        else
            System.out.printf("The domains currently registered are: %s", String.join(", ", keys));
        // new line
        System.out.println();
    }
}

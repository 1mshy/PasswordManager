package com.imshy.UserInterface;

public class CheckUserInputs {
    @Deprecated
    public boolean isEmail(String email) {
        String[] identifiers = {".com", ".uk", ".us", ".ca", "gmail", "protonmail", "yahoo"};
        for (String identifier : identifiers)
            if (email.contains(identifier))
                return true;
        return false;
    }


    public boolean malformedComboInput(String combo, int segements) {
        // *source* *email* *password*
        int emailLocation = 1;
        if (combo == null || combo.split(" ").length != segements)
            return true;
        return false;
    }

}

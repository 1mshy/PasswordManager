package com.imshy.UserInterface;

public class CheckUserInputs {
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
        if (combo == null || combo.split(" ").length != segements || !isEmail(combo.split(" ")[emailLocation]))
            return true;
        return false;
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 8)
            return false;

        return true;

    }

}

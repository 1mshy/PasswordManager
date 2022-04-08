package com.imshy.Backend;

public class Combo {
    private final String domain;
    private final String email;
    private final String password;


    public String getDomain() {
        return domain;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Combo(String[] combo) {

        this.domain = combo[0];
        this.email = combo[1];
        if (combo.length > 2 && combo[2] != null)
            this.password = combo[2];
        else
            this.password = null;

    }


}

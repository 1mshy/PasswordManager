package com.imshy.Backend;

import java.util.Arrays;

public class Combo {
    private String domain;
    private String email;
    private String password;


    public Combo(String[] combo) {

        this.domain = combo[0];
        if (combo.length > 1)
            this.email = combo[1];
        if (combo.length > 2 && combo[2] != null)
            this.password = combo[2];
    }

    public Combo() {

    }

    public String getDomain() {
        return domain;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

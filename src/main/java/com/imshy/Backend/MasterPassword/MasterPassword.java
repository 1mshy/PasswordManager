package com.imshy.Backend.MasterPassword;

import com.imshy.Encrypter.XorEncrypter;

public class MasterPassword {
    private String masterPassword;

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
        XorEncrypter.getInstance().setSalt(masterPassword);
    }

}

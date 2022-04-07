package com.imshy.Backend.MasterPassword;

import com.imshy.Encrypter.XorEncrypter;

public class MasterPassword {
    private String masterPassword;
    final XorEncrypter xorEncrypter;

    public MasterPassword() {
        xorEncrypter = XorEncrypter.getInstance();
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
        xorEncrypter.setSalt(masterPassword);
    }

}

package com.imshy.Backend.MasterPassword;

import com.imshy.Backend.Controls.PasswordUtil;
import com.imshy.Encrypter.XorEncrypter;

import java.io.*;

public class MasterPassword extends PasswordUtil {
    private String masterPassword;
    final MasterFileCollector masterFileCollector;
    final XorEncrypter xorEncrypter;

    public MasterPassword() {
        masterFileCollector = new MasterFileCollector();
        masterPassword = retrievePassword();
        xorEncrypter = new XorEncrypter();
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    private String retrievePassword() {
        try {
            return xorEncrypter.decrypt(masterFileCollector.readPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Could not retrieve password");
    }

    public void setMasterPassword(String masterPassword) {
        try {
            masterFileCollector.updatePassword(xorEncrypter.encrypt(masterPassword));
            this.masterPassword = masterPassword;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not set password");
        }
    }

}

package com.imshy.Encrypter;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
    MessageDigest md;

    Sha256() {
        md = setupDigest();
    }

    public String hash(String str) {
        byte[] bytes = md.digest(str.getBytes(StandardCharsets.UTF_8));
        return toHexString(bytes);
    }
    public String hash(char c) {
        byte[] bytes = md.digest(new byte[] {(byte) c});
        return toHexString(bytes);
    }

    // hash is 64 in length
    private String toHexString(byte[] hash) {
        BigInteger num = new BigInteger(1, hash);
        return num.toString(16);
    }

    private MessageDigest setupDigest() {
        MessageDigest temp = null;
        try {
            temp = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // will never happen
        }
        return temp;
    }
}
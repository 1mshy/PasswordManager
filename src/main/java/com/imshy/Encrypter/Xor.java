package com.imshy.Encrypter;

import java.math.BigInteger;

// will be used to store user passwords, excluding the master password
public class Xor {

    private static Xor instance;
    private final int RADIX = 20;
    private String key;

    private Xor() {
        key = "2349082340978235";
    }

    public static Xor getInstance() {
        if (instance == null) {
            instance = new Xor();
        }
        return instance;
    }

    // should only run once at the start
    public void setKey(String key) {
        StringBuilder sb = new StringBuilder();
        // changes the string to integers
        key.chars().boxed().forEach(sb::append);
        this.key = sb.toString();
    }

    public final String encrypt(String password) {
        if (password == null) throw new NullPointerException("Null cannot be encrypted");
        if (password.length() == 0) throw new IllegalArgumentException("Cannot encrypt empty string");

        BigInteger bi_passwd = new BigInteger(password.getBytes());

        BigInteger bi_r0 = new BigInteger(key);
        BigInteger bi_r1 = bi_r0.xor(bi_passwd);

        return bi_r1.toString(RADIX);
    }

    public final String decrypt(String encrypted) {
        if (encrypted == null) throw new NullPointerException("Null cannot be decrypted");
        if (encrypted.length() == 0)
        {
            System.err.println("Decrypted String cannot be empty. If you see a password file with no data inside, delete it");
            throw new IllegalArgumentException();
        }

        BigInteger bi_confuse = new BigInteger(key);

        try {
            BigInteger bi_r1 = new BigInteger(encrypted, RADIX);
            BigInteger bi_r0 = bi_r1.xor(bi_confuse);

//            System.out.println(new String(bi_r0.toByteArray()));
            return new String(bi_r0.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
}

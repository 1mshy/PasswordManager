package com.imshy.Encrypter;

import java.math.BigInteger;

public class Encrypt {
    private static final int RADIX = 16;
    private static final String SEED = "0933910847463829232312312";

    public static String encrypt(String password) {
        if (password == null)
            throw new NullPointerException("Null cannot be encrypted");
        if (password.length() == 0)
            throw new IllegalArgumentException("String cannot be empty");

        BigInteger bi_passwd = new BigInteger(password.getBytes());

        BigInteger bi_r0 = new BigInteger(SEED);
        BigInteger bi_r1 = bi_r0.xor(bi_passwd);

        return bi_r1.toString(RADIX);
    }

    public static String decrypt(String encrypted) {
        if (encrypted == null)
            throw new NullPointerException("Null cannot be encrypted");
        if (encrypted.length() == 0)
            throw new IllegalArgumentException("String cannot be empty");

        BigInteger bi_confuse = new BigInteger(SEED);

        try {
            BigInteger bi_r1 = new BigInteger(encrypted, RADIX);
            BigInteger bi_r0 = bi_r1.xor(bi_confuse);

            return new String(bi_r0.toByteArray());

        } catch (Exception e) {
            return "";
        }
    }
}

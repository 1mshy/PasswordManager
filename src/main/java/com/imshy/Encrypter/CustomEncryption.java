package com.imshy.Encrypter;

import java.util.OptionalDouble;

public class CustomEncryption {
    Sha256 sha256 = new Sha256();
    final int NUMOFLOOPS = 1000;
    public String hash(String raw) {
        String temp = sha256.hash(raw);
        for(int i = 0; i < NUMOFLOOPS; i++)
        {
            // resulting string has length 64
            temp = sha256.hash(temp.substring(31) + getAvg(temp));
        }
        return temp;
    }
    private String hash(char c) {
        return sha256.hash(c);
    }

    public double getAvg(String s) {
        OptionalDouble op = s.strip().chars().average();
        assert op.isPresent() : "String is empty";
        return op.getAsDouble();
    }
}

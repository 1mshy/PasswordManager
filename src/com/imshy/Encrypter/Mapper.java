package com.imshy.Encrypter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mapper {
    private String allCharacters = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
   
    public String encryptString(String string)
    {
        
        return null;
    }
    public String unEncryptString(String string)
    {
        return null;
    }
    public Map<Character, Character> generateMap()
    {
        List<Character> keys = new ArrayList<Character>();
        allCharacters.chars().forEach(c -> keys.add((char) c));
        List<Character> values = new ArrayList<Character>();
        allCharacters.chars().forEach(c -> values.add((char) c));

        int numOfCharacters = this.allCharacters.length();
        Map<Character,Character> map = new HashMap<Character,Character>();
        Random random = new Random();

        for(int i = 0; i < numOfCharacters-1; i++)
        {
            //length of remaining keys is equivalent to the length of remaining values
            int lengthOfRemainingPairs = keys.size();
            int randomKeyIndex = random.nextInt(lengthOfRemainingPairs);
            int randomValueIndex = random.nextInt(lengthOfRemainingPairs);

            map.put(keys.get(randomKeyIndex), values.get(randomValueIndex));

            keys.remove(randomKeyIndex);
            values.remove(randomValueIndex);
        }
        return map;
    }
}

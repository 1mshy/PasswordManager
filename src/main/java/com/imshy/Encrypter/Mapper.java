package com.imshy.Encrypter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Deprecated
public class Mapper {
    private final String ALL_CHARACTERS = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    private final String MAP_FILE_NAME = "map.json";

    public String encryptString(String string) {
        return null;
    }

    public String unEncryptString(String string) {
        return null;
    }

    // maps characters onto other characters
    public Map<Character, Character> generateMap() {
        List<Character> keys = new ArrayList<>();
        ALL_CHARACTERS.chars().forEach(c -> keys.add((char) c));
        List<Character> values = new ArrayList<>(keys);

        int numOfCharacters = this.ALL_CHARACTERS.length();
        Map<Character, Character> map = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < numOfCharacters - 1; i++) {
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
    public Map<Character, Character> getMap() {
        // TODO
        return generateMap();
    }
    // METHOD OVERRIDES PREVIOUS MAP
    // can cause old hashes using older maps to become invalid if not handled properly
    public void replaceMap() throws IOException {
        writeToFile(generateMap());
    }

    private void writeToFile(Map<Character, Character> map) throws IOException {
        FileWriter mapWriter = new FileWriter(MAP_FILE_NAME);
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        map.forEach((k, v) -> sb.append('"').append(k).append('"').append(':').append('"').append(v).append('"').append(','));
        // deletes last character, in this case the last comma
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        mapWriter.write(sb.toString());
        mapWriter.close();
    }

    private void writeToFile(String data) {
        try {
            if (!fileExists()) {
                createFile();
            }
            FileWriter map = new FileWriter(MAP_FILE_NAME);
            map.write(data);
            map.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() throws IOException {

        FileReader mapReader = new FileReader(createFileInstance());
        StringBuilder mapContent = new StringBuilder();
        int input;
        // -1 is the output when the reader is empty
        while ((input = mapReader.read()) != -1) {
            // the integer given is the character in integer form
            // must convert the integer back to a character to add it to the string
            mapContent.append((char) input);
        }
        mapReader.close();

        return mapContent.toString();
    }

    private void createFileIfMissing() {

        if (!fileExists()) {
            try {
                createFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean fileExists() {
        return createFileInstance().exists();
    }

    private void createFile() throws IOException {
        new File(MAP_FILE_NAME).createNewFile();
    }

    private File createFileInstance() {
        return new File(MAP_FILE_NAME);
    }

}

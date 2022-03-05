package com.imshy;

import com.imshy.prompt.ListPrompt;
import com.imshy.prompt.Prompt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UI {
    public UI()
    {

    }
    public void start()
    {
        System.out.println(options().structurePrompt());


    }

    public Prompt<String> options()
    {
        List<String> a = new ArrayList<>();
        // adds the labels of the options instead of the options itself
        // Ex: will add "Save Password" Instead of SAVE_PASSWORD
        Arrays.stream(OPTIONS.values()).forEach(option -> a.add(option.label));
        return new ListPrompt<>(a);
    }
    private enum OPTIONS {
        SAVE_PASSWORD("Save Password"),
        REMOVE_PASSWORD("Remove Password"),
        UPDATE_PASSWORD("Update Password");

        private final String label;
        private OPTIONS(String label) {
            this.label = label;
        }

    }
}

package com.imshy.UserInterface;

import com.imshy.UserInterface.Prompt.ListPrompt;
import com.imshy.UserInterface.Prompt.Prompt;

import java.util.*;

public class UI {
    public UI() {
    }
    public void start() {
        final Output OUTPUT = new Output();
        Prompt<String> options = new ListPrompt<>(stringOptions(getOptions()));
        OUTPUT.printPrompt(options);

        final Input INPUT = new Input();
        int chosen = INPUT.takeInputNumber(options.getValues().size());
    }

    private List<OPTION> getOptions() {
        return new ArrayList<>(EnumSet.allOf(OPTION.class));
    }
    private List<String> stringOptions(List<OPTION> options)
    {
        List<String> stringedOptions = new ArrayList<>();
        for(OPTION o : options)
        {
            stringedOptions.add(o.label);
        }
        return stringedOptions;
    }


    private enum OPTION {
        SAVE_PASSWORD("Save Password"),
        REMOVE_PASSWORD("Remove Password"),
        UPDATE_PASSWORD("Update Password");
        // label has to be defined here or enum will break
        private final String label;

        OPTION(String label) {
            this.label = label;
        }

    }
}



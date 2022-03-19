package com.imshy.UserInterface.Prompt;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MainPrompt extends ListPrompt<String> {
    public MainPrompt() {
        super(OPTION.getStringedOptions());
    }

    public enum OPTION {
        SAVE_PASSWORD("Save Password"),
        REMOVE_PASSWORD("Remove Password"),
        UPDATE_PASSWORD("Update Password");
        // label has to be defined here or enum will break
        private final String label;

        OPTION(String label) {
            this.label = label;
        }

        static List<OPTION> getOptions() {
            return new ArrayList<>(EnumSet.allOf(OPTION.class));
        }
        static List<String> getStringedOptions() {
            List<String> stringedOptions = new ArrayList<>();
            List<OPTION> options = getOptions();

            for (OPTION o : options) {
                stringedOptions.add(o.label);
            }
            return stringedOptions;
        }
    }


}

package com.imshy.UserInterface.Prompt;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MainPrompt extends ListPrompt<String> {
    public MainPrompt() {
        super(OPTION.getOptionLabels());
    }

    public enum OPTION {
        ADD_OR_UPDATE_PASSWORD("Add/Update Password"),
        REMOVE_PASSWORD("Remove Password"),
        SHOW_PASSWORD("Show Password");
        // label has to be defined here or enum will break
        private final String label;

        OPTION(String label) {
            this.label = label;
        }

        static List<OPTION> getOptions() {
            return new ArrayList<>(EnumSet.allOf(OPTION.class));
        }
        static List<String> getOptionLabels() {
            List<String> stringedOptions = new ArrayList<>();
            List<OPTION> options = getOptions();

            for (OPTION o : options) {
                stringedOptions.add(o.label);
            }
            return stringedOptions;
        }
    }


}

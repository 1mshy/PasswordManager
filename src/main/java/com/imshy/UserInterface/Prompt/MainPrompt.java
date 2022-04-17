package com.imshy.UserInterface.Prompt;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MainPrompt extends ListPrompt<String> {
    public MainPrompt() {
        super(MAIN_OPTIONS.getOptionLabels());
    }

    public enum MAIN_OPTIONS {
        ADD_OR_UPDATE_PASSWORD("Add/Update Password"),
        REMOVE_PASSWORD("Remove Password"),
        SHOW_PASSWORD("Show Password"),
        OTHER("Other");
        // label has to be defined here or enum will break
        private final String label;

        MAIN_OPTIONS(String label) {
            this.label = label;
        }

        static List<MAIN_OPTIONS> getOptions() {
            return new ArrayList<>(EnumSet.allOf(MAIN_OPTIONS.class));
        }
        static List<String> getOptionLabels() {
            List<String> stringedOptions = new ArrayList<>();
            List<MAIN_OPTIONS> MAINOPTIONS = getOptions();

            for (MAIN_OPTIONS o : MAINOPTIONS) {
                stringedOptions.add(o.label);
            }
            return stringedOptions;
        }
    }


}

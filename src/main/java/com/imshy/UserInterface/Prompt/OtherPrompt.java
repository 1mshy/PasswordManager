package com.imshy.UserInterface.Prompt;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class OtherPrompt extends ListPrompt<String> implements Prompt {
    public OtherPrompt() {
        super(OTHER_OPTIONS.getOptionLabels());
    }

    public enum OTHER_OPTIONS {
        CHANGE_MASTER_PASSWORD("Change master password"),
        SHOW_ALL_PASSWORDS("Show all passwords (NOT DONE)");

        // label has to be defined here or enum will break
        private final String label;

        OTHER_OPTIONS(String label) {
            this.label = label;
        }

        static List<OTHER_OPTIONS> getOptions() {
            return new ArrayList<>(EnumSet.allOf(OtherPrompt.OTHER_OPTIONS.class));
        }
        static List<String> getOptionLabels() {
            List<String> stringedOptions = new ArrayList<>();
            List<OTHER_OPTIONS> MAINOPTIONS = getOptions();

            for (OTHER_OPTIONS o : MAINOPTIONS) {
                stringedOptions.add(o.label);
            }
            return stringedOptions;
        }
    }
}

package com.imshy;

import com.imshy.prompt.AbstractPrompt;
import com.imshy.prompt.ListPrompt;

public class UI {
    public UI()
    {

    }
    public void start()
    {

    }
    //
    public AbstractPrompt options()
    {
        return new ListPrompt();
    }
    private enum OPTIONS {
        SAVE_PASSWORD("Save Password"),
        REMOVE_PASSWORD("Remove Password"),
        UPDATE_PASSWORD("Update Password");

        private String label;
        private OPTIONS(String label) {
            this.label = label;
        }

    }
}

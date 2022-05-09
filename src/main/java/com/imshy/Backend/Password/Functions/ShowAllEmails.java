package com.imshy.Backend.Password.Functions;

import com.imshy.Backend.Combo;

import java.util.Set;

public class ShowAllEmails extends AbstractPassword{
    public ShowAllEmails(Combo combo) {
        super(combo);
    }

    @Override
    public void runPasswordFunction() {
        Set<String> keys = this.lazyParseDomain().keySet();
        if(keys.size()==0)
            System.out.printf("The domain %s is not found.", combo.getDomain());
        else
            System.out.printf("The emails currently registered under %s are: %s", super.combo.getDomain(), String.join(", ", keys));
        //new line
        System.out.println();
    }
}

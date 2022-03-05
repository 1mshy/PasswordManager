package com.imshy.prompt;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPrompt<E> {
    final ArrayList<E> choices;
    public AbstractPrompt(List<E> choices) {
        this.choices = (ArrayList<E>) choices;
    }

    public abstract String structurePrompt();
}

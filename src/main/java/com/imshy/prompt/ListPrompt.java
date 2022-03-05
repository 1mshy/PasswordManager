package com.imshy.prompt;

import com.imshy.prompt.elements.Choice;
import com.imshy.prompt.elements.ListChoice;

import java.util.ArrayList;
import java.util.List;

public class ListPrompt<E> implements Prompt<E> {
    private final List<E> values;

    public ListPrompt(List<E> values) {
        this.values = values;
    }

    @Override
    public String structurePrompt() {
        ArrayList<Choice> choices = mapToChoices(values);
        return stringChoices(choices);
    }
    private ArrayList<Choice> mapToChoices(List<E> values) {
        ArrayList<Choice> choices = new ArrayList<>();
        for (int i = 1; i <= values.size(); i++) {
            choices.add(new ListChoice(values.get(i - 1).toString(), i));
        }
        return choices;
    }
    private String stringChoices(List<Choice> choices)
    {
        StringBuilder sb = new StringBuilder();
        for(Choice c : choices)
        {
            sb.append(c.toString()).append('\n');
        }
        return sb.toString();
    }
}
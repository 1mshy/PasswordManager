package com.imshy.UserInterface.Prompt;

import com.imshy.UserInterface.Prompt.elements.Choice;
import com.imshy.UserInterface.Prompt.elements.ListChoice;

import java.util.ArrayList;
import java.util.List;

public abstract class ListPrompt<E> implements Prompt {
    private final List<E> values;

    public ListPrompt(List<E> values) {
        this.values = values;
    }

    @Override
    public String structurePrompt() {
        ArrayList<Choice> choices = mapToChoices(values);
        return stringChoices(choices);
    }

    public int size() {
        return getValues().size();
    }
    public List<E> getValues(){
        return values;
    }
    private ArrayList<Choice> mapToChoices(List<E> values) {
        ArrayList<Choice> choices = new ArrayList<>();
        for (int i = 1; i <= values.size(); i++) {
            // first arguement is the position starting at 1
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
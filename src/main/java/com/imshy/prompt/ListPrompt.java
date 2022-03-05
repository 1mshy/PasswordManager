package com.imshy.prompt;

import com.imshy.prompt.elements.Choice;
import com.imshy.prompt.elements.ListChoice;

import java.util.ArrayList;
import java.util.List;

public class ListPrompt<E> extends AbstractPrompt<E> {
    public ListPrompt(List<E> values)
    {
        super(values);
    }
    @Override
    public String structurePrompt() {
        ArrayList<Choice> choices = mapToChoices(super.choices);

        return null;
    }
    private ArrayList<Choice> mapToChoices(List<E> values)
    {
        ArrayList<Choice> choices = new ArrayList<>();
        for(int i = 1; i <= values.size(); i++)
        {
            choices.add(new ListChoice((String) values.get(i - 1), i));
        }
        return choices;
    }
}

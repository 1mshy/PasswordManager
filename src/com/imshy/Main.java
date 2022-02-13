package com.imshy;

import java.util.Map;

import javax.swing.event.SwingPropertyChangeSupport;

import com.imshy.Encrypter.Mapper;

public class Main {
    public static void main(String[] args)
    {
        Mapper mapper = new Mapper();
        for(Map.Entry<Character,Character> entry : mapper.generateMap().entrySet())
        System.out.println(entry.getKey() + " " + entry.getValue());
        

        if(args.length > 2)
        {
            TaskManager.initialize();
        }
    }

}

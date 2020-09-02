package com.allianz.thailand.reader;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import org.springframework.batch.item.ItemReader;

@Component
public class DataReader implements ItemReader<String> {
    String message[]={"hi","hello","how"};
    int index;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(index<message.length){
            return message[index++];
        }else {
            index=0;
        }
        return null;
    }
}

package com.allianz.thailand.processor;

import org.springframework.stereotype.Component;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
@Component
public class DataProcessor implements ItemProcessor<String,String> {
    @Override
    public String process(String item) throws Exception {
        return item.toUpperCase();
    }
}

package com.allianz.thailand.batchconfig;

import com.allianz.thailand.listener.MyJobLIstener;
import com.allianz.thailand.processor.DataProcessor;
import com.allianz.thailand.writer.DataWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.allianz.thailand.reader.DataReader;
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jobA(){
        return jobBuilderFactory.get("jobA")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(stepA())
                .build();

    }

    public Step stepA() {
        return stepBuilderFactory.get("stepA")
                .<String,String>chunk(50)
                .reader(new DataReader())
                .processor(new DataProcessor())
                .writer(new DataWriter())
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return  new MyJobLIstener();
    }
}

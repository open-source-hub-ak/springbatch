package com.opensource.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Autowired
	private StepBuilderFactory sbf;

	@Autowired
	private JobBuilderFactory jbf;

	// JOB CONFIGURED
	@Bean
	public Job job1() {
		return jbf.get("job1").incrementer(new RunIdIncrementer()).listener(listner()).start(step1()).build();
	}

	// STEP CONFIGURED
	@Bean
	public Step step1() {
		return sbf.get("step1").<String, String>chunk(1).reader(reader()).processor(processor()).writer(writer())
				.build();
	}

	// EXPOSE Reader writer and processor as beans
	@Bean
	public Reader reader() {
		return new Reader();
	}

	@Bean
	public Processor processor() {
		return new Processor();
	}

	@Bean
	public Writer writer() {
		return new Writer();
	}

	@Bean
	public MyJobListner listner() {
		return new MyJobListner();
	}
}

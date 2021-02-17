package com.opensource.springbatch;

import javax.batch.api.listener.JobListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

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

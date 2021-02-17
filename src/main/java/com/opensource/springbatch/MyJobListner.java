package com.opensource.springbatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListner implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {

		System.out.println("Job Started");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {

		System.out.println("Job Ended " + jobExecution.getStatus());
	}

}

package com.opensource.springbatch;

import org.springframework.batch.item.ItemProcessor;

public class Processor2 implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {

		return "PROCESSED " + item + " MODIFIED";
	}

}

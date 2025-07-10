package com.hdfc.Utils;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class GeneratorUtil {

	private static final AtomicLong custIdCounter = new AtomicLong(1000); // starts from 1000
	private static final AtomicLong accNoCounter = new AtomicLong(1000000000); // starts from 1000000000

	
	public String generateCustomerId() {
		return "CUST" + custIdCounter.getAndIncrement();
	}

	public String generateAccountNumber() {
		return String.valueOf(accNoCounter.getAndIncrement());
	}
}

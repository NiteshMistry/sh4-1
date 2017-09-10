package com.sunbeam.sh4.spring;

import java.util.Date;

public class ConsoleLoggerImpl implements Logger {
	@Override
	public void log(String message) {
		System.out.println(new Date() + " => " +message);
	}
}

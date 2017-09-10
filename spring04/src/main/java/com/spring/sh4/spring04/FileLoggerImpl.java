package com.spring.sh4.spring04;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class FileLoggerImpl implements Logger {
	private String logFilePath;
	public FileLoggerImpl() {
		this.logFilePath = "application.log";
	}
	public String getLogFilePath() {
		return logFilePath;
	}
	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}
	@Override
	public void log(String message) {
		String logMessage = new Date() + " => " +message;
		try(FileOutputStream fout = new FileOutputStream(logFilePath, true)) {
			try(PrintStream out = new PrintStream(fout)) {
				out.println(logMessage);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

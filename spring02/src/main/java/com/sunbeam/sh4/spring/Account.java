package com.sunbeam.sh4.spring;

public interface Account {

	int getAccno();

	void setAccno(int accno);

	String getType();

	void setType(String type);

	double getBalance();

	void setBalance(double balance);

	Person getAccHolder();

	void setAccHolder(Person accHolder);

	void withdraw(double amount);

	void deposit(double amount);

}
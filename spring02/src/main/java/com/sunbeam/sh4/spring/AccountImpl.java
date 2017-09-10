package com.sunbeam.sh4.spring;

public class AccountImpl implements Account {
	private int accno;
	private String type;
	private double balance;
	private Person accHolder;
	private Logger logger;
	public AccountImpl() {
		this.accno = 0;
		this.type = "";
		this.balance = 0.0;
		this.accHolder = null;
		this.logger = null;
	}
	public AccountImpl(int accno, String type, double balance, Person accHolder) {
		this.accno = accno;
		this.type = type;
		this.balance = balance;
		this.accHolder = accHolder;
	}
	public AccountImpl(Logger logger) {
		this.logger = logger;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	@Override
	public int getAccno() {
		return accno;
	}
	@Override
	public void setAccno(int accno) {
		this.accno = accno;
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public double getBalance() {
		return balance;
	}
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public Person getAccHolder() {
		return accHolder;
	}
	@Override
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	@Override
	public void withdraw(double amount) {
		this.balance = this.balance - amount;
		logger.log("Account.withdraw() is called with amount Rs." + amount); 
	}
	@Override
	public void deposit(double amount) {
		this.balance = this.balance + amount;
		logger.log("Account.deposit() is called with amount Rs." + amount);
	}
	@Override
	public String toString() {
		return String.format("AccountImpl [accno=%s, type=%s, balance=%s, accHolder=%s]", accno, type, balance,
				accHolder);
	}
}

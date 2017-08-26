package com.sunbeam.sh4.jspbasics;

public class ArithBean {
	private int num1;
	private int num2;
	private String op;
	private int result;
	public ArithBean() {
		this.op = "";
		System.out.println("ArithBean object is created.");
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public void calc() {
		switch (op) {
		case "+":
			this.result = this.num1 + this.num2;
			break;
		case "-":
			this.result = this.num1 - this.num2;
			break;
		case "*":
			this.result = this.num1 * this.num2;
			break;
		case "/":
			this.result = this.num1 / this.num2;
			break;
		default:
			this.result = -1;
			break;
		}
	}
}














package com.sunbeam.sh4.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring02Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("spring02.xml");
		
		Account a1 = (Account) ctx.getBean("a1");
		System.out.println(a1);
		
		Account a2 = (Account) ctx.getBean("a2");
		System.out.println(a2);

		Account a3 = (Account) ctx.getBean("a3");
		System.out.println(a3);
		a3.deposit(500);
		System.out.println(a3);

		ctx.close();
	}
}

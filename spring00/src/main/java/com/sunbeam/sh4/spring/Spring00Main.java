package com.sunbeam.sh4.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring00Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("one.xml");
		Person p1 = (Person) ctx.getBean("p1");
		System.out.println(p1);
		ctx.close();
	}
}

package com.sunbeam.sh4.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring03Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Rectangle r1 = (Rectangle) ctx.getBean("r1");
		System.out.println("Area : " + r1.calcArea());
		
		Rectangle r2 = (Rectangle) ctx.getBean("r2");
		System.out.println("Area : " + r2.calcArea());

		ctx.close();
	}
}

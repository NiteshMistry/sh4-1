package com.spring.sh4.spring04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring04Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("spring04.xml");
		
		Box b1 = (Box) ctx.getBean("b1");
		System.out.println(b1);
		System.out.println("Volume : " + b1.calcVolume());
		b1.destroy(); // destroy() to be done manually for prototype bean
		
		b1 = (Box) ctx.getBean("b1");
		System.out.println(b1);
		System.out.println("Volume : " + b1.calcVolume());
		b1.destroy(); // destroy() to be done manually for prototype bean
		
		ctx.close(); // all singleton beans will auto destroyed when appcontext is closed.
	}
}

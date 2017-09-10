package com.sunbeam.sh4.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Spring01Main {
	public static void main(String[] args) {
		Box b1 = new BoxImpl();
		b1.setLength(10);
		b1.setBreadth(8);
		b1.setHeight(6);
		System.out.println("Volume : " + b1.calcVolume());
		
		Box b2 = new BoxImpl(5, 4, 3);
		System.out.println("Volume : " + b2.calcVolume());
		
		ClassPathResource res = new ClassPathResource("spring01.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(res);
		/*
		Box b3 = (Box) beanFactory.getBean("b3");
		System.out.println("Volume : " + b3.calcVolume());
		beanFactory.destroyBean(b3);
		
		Box b4 = (Box) beanFactory.getBean("b4");
		System.out.println("Volume : " + b4.calcVolume());
		beanFactory.destroyBean(b4);
		
		Box b5 = (Box) beanFactory.getBean("b5");
		b5 = (Box) beanFactory.getBean("b5");
		b5 = (Box) beanFactory.getBean("b5");
		System.out.println("Volume : " + b5.calcVolume());
		beanFactory.destroyBean(b5);
		*/
		
		ClassPathXmlApplicationContext ctx;
		ctx = new ClassPathXmlApplicationContext("spring01.xml");
		ctx.registerShutdownHook();
		
		Box b3 = (Box) ctx.getBean("b3");
		System.out.println("Volume : " + b3.calcVolume());
		
		Box b4 = (Box) ctx.getBean("b4");
		System.out.println("Volume : " + b4.calcVolume());

		Box b5 = (Box) ctx.getBean("b5");
		System.out.println("Volume : " + b5.calcVolume());
		//ctx.close();
	}
}

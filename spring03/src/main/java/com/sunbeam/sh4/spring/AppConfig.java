package com.sunbeam.sh4.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Rectangle r1() {
		Rectangle r1 = new RectangleImpl();
		r1.setLength(10);
		r1.setBreadth(5);
		return r1;
	}
	@Bean
	public Rectangle r2() {
		Rectangle r2 = new RectangleImpl(6, 4);
		return r2;
	}
}

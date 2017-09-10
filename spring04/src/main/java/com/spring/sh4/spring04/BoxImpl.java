package com.spring.sh4.spring04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BoxImpl implements Box {
	private int length;
	private int breadth;
	private int height;
	@Autowired //(required=false)
		//by-default autowire bean of Logger type.
		//if no bean found of Logger type and required is not false, raise exception NoSuchBeanFoundException.
		//if multiple beans found of Logger type, it will try to resolve it by name.
		//	e.g. if any bean with name "logger" is found, it will auto-wired.
		//if multiple beans found of Logger type and no bean has matching name "logger", raise exception NoUniqueBeanDefinitionException.
	//@Qualifier("consoleLogger")
		//to be used with @Autowired only.
		//if multiple beans found of Logger type, the @Qualifier is used to resolve ambiguity.
	private Logger logger;
	public BoxImpl() {
		this.length = 0;
		this.breadth = 0;
		this.height = 0;
		System.out.println("BoxImpl() called.");
	}
	public BoxImpl(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
		System.out.println("BoxImpl(int,int,int) called.");
	}
	@PostConstruct
	public void init() {
		System.out.println("BoxImpl.init() called.");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("BoxImpl.destroy() called.");
	}
	public Logger getLogger() {
		return logger;
	}
	//@Autowired
	//if @Autowired is written on field, the field will be initialized directly (not via setter).
	//if @Autowired is written on setter, the field will be initialized via setter.
	//*if @Autowired is written on single-arg ctor, the field will be initialized via constructor.
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		System.out.println("BoxImpl.setLength() called.");
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		System.out.println("BoxImpl.setBreadth() called.");
		this.breadth = breadth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		System.out.println("BoxImpl.setHeight() called.");
		this.height = height;
	}
	@Override
	public int calcVolume() {
		logger.log("BoxImpl.calcVolume() is called."); 
		return this.length * this.breadth * this.height;
	}
	@Override
	public String toString() {
		return String.format("BoxImpl [length=%s, breadth=%s, height=%s]", length, breadth, height);
	}
}

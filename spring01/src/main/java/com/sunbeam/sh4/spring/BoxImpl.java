package com.sunbeam.sh4.spring;

public class BoxImpl implements Box {
	private int length;
	private int breadth;
	private int height;
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
	public void init() {
		System.out.println("BoxImpl.init() called.");
	}
	public void destroy() {
		System.out.println("BoxImpl.destroy() called.");
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
		return this.length * this.breadth * this.height;
	}
	@Override
	public String toString() {
		return String.format("BoxImpl [length=%s, breadth=%s, height=%s]", length, breadth, height);
	}
}

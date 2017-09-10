package com.sunbeam.sh4.spring;

public class RectangleImpl implements Rectangle {
	private int length;
	private int breadth;
	public RectangleImpl() {
		this.length = 0;
		this.breadth = 0;		
	}
	public RectangleImpl(int length, int breadth) {
		this.length = length;
		this.breadth = breadth;
	}
	@Override
	public int getLength() {
		return length;
	}
	@Override
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public int getBreadth() {
		return breadth;
	}
	@Override
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	@Override
	public int calcArea() {
		return this.length * this.breadth;
	}
	@Override
	public String toString() {
		return String.format("Rectangle [length=%s, breadth=%s]", length, breadth);
	}
}

package com.sunbeam.sh4.spring;

public class Person {
	private String name;
	private Address address;
	private int age;
	public Person() {
		this.name = "";
		this.age = 0;
		this.address = null;
	}
	public Person(Address address) {
		this.address = address;
	}

	public Person(String name, Address address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("Person [name=%s, address=%s, age=%s]", name, address, age);
	}
}

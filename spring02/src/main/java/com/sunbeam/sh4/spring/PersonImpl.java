package com.sunbeam.sh4.spring;

public class PersonImpl implements Person {
	private String name;
	private String address;
	private String mobile;
	public PersonImpl() {
		this.name = "";
		this.address = "";
		this.mobile = "";		
	}
	public PersonImpl(String name, String address, String mobile) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String getMobile() {
		return mobile;
	}
	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return String.format("PersonImpl [name=%s, address=%s, mobile=%s]", name, address, mobile);
	}
}

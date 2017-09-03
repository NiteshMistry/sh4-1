package com.sunbeam.sh4.hib;

import java.io.Serializable;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name="EMPADDRESS")
public class Address implements Serializable {
	@GenericGenerator(name="gen", strategy="foreign", 
			parameters=@Parameter(name="property", value="emp"))
	@GeneratedValue(generator="gen")
	@Id
	@Column(name="EMPID")
	private int empid;
	@Column(name="ADDR")
	private String addr;
	@Column(name="COUNTRY")
	private String country;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Emp emp;
	public Address() {
		this(0, "", "");
	}
	public Address(int empid, String addr, String country) {
		this.empid = empid;
		this.addr = addr;
		this.country = country;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return String.format("Address [empid=%s, addr=%s, country=%s]", empid, addr, country);
	}
}

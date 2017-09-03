package com.sunbeam.sh4.hib;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Emp implements Serializable {
	@Id
	@Column
	private int empno;
	@Column(name="ename")
	private String name;
	@Column(name="sal")
	private double salary;
	@Column(name="deptno")
	private int deptNum;
	@OneToOne(mappedBy="emp", cascade=CascadeType.ALL)
	private Address address;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="EMPMEETING", 
				joinColumns={@JoinColumn(name="EMPID")}, 
				inverseJoinColumns={@JoinColumn(name="MEETINGID")})
	private List<Meeting> meetingList;
	public Emp() {
		this(0, "", 0.0, 0);
	}
	public Emp(int empno, String name, double salary, int deptNum) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
		this.deptNum = deptNum;
	}
	public List<Meeting> getMeetingList() {
		return meetingList;
	}
	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("Emp [empno=%s, name=%s, salary=%s, deptNum=%s]", empno, name, salary, deptNum);
	}
}


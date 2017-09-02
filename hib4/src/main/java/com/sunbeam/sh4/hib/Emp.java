package com.sunbeam.sh4.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Emp implements Serializable {
	@Id
	@Column
	private int empno;
	@Column
	private String ename;
	@Column
	private double sal;
	@Column
	private int deptno;
	public Emp() {
		this(0, "", 0.0, 0);
	}
	public Emp(int empno, String ename, double sal, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return String.format("Emp [empno=%s, ename=%s, sal=%s, deptno=%s]", empno, ename, sal, deptno);
	}
}

package com.sunbeam.sh4.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENTS")
public class Student implements Serializable {
	@Id
	private StudStdRoll stdRoll;
	@Column
	private String name;
	@Column
	private double marks;
	public Student() {
		this(new StudStdRoll(), "", 0.0);
	}
	public Student(StudStdRoll stdRoll, String name, double marks) {
		this.stdRoll = stdRoll;
		this.name = name;
		this.marks = marks;
	}
	public StudStdRoll getStdRoll() {
		return stdRoll;
	}
	public void setStdRoll(StudStdRoll stdRoll) {
		this.stdRoll = stdRoll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return String.format("Student [stdRoll=%s, name=%s, marks=%s]", stdRoll, name, marks);
	}
}

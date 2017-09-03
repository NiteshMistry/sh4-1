package com.sunbeam.sh4.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudStdRoll implements Serializable {
	@Column
	private int std;
	@Column
	private int roll;
	public StudStdRoll() {
		this(0, 0);
	}
	public StudStdRoll(int std, int roll) {
		this.std = std;
		this.roll = roll;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return String.format("StudStdRoll [std=%s, roll=%s]", std, roll);
	}
}

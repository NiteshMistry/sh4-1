package com.sunbeam.sh4.shop;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BOOKS")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String subject;
	@Column
	private double price;
	public Book() {
		this(0, "", "", "", 0.0);
	}
	public Book(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Book(int id, String name, String author, String subject, double price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Book [id=%s, name=%s, author=%s, subject=%s, price=%s]", id, name, author, subject,
				price);
	}
	
}

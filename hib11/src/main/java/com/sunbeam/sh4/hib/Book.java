package com.sunbeam.sh4.hib;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="BOOKS")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="AUTHOR")
	private String author;
	@Column//(name="SUBJECT")
	private String subject;
	//@Column(name="PRICE")
	private double price;
	@Transient
	private int temp;
	public Book() {
		this(0, "", "", "", 0.0);
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

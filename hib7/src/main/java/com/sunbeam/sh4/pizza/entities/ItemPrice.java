package com.sunbeam.sh4.pizza.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_PRICING")
public class ItemPrice implements Serializable{
	@Id
	@Column
	private int id;
	@Column(name="sizes")
	private String size;
	@Column
	private double price;
	@ManyToOne
	@JoinColumn(name="ITEMID")
	private Item item;
	public ItemPrice() {
		this(0, "", 0.0);
	}
	public ItemPrice(int id, String size, double price) {
		this.id = id;
		this.size = size;
		this.price = price;
		this.item = new Item();
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("ItemPrice [id=%s, size=%s, price=%s]", id, size, price);
	}
}	

package com.sunbeam.sh4.pizza.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PIZZA_ORDERDETAILS")
public class OrderDetail implements Serializable {
	@GenericGenerator(name="gen", strategy="native")
	@GeneratedValue(generator="gen")
	@Id
	@Column
	private int id;
	@ManyToOne
	@JoinColumn(name="PRICEID")
	private ItemPrice itemPrice;
	@ManyToOne
	@JoinColumn(name="ORDERID")
	private Order order;
	public OrderDetail() {
		this(0, new ItemPrice(), new Order());
	}
	public OrderDetail(int id, ItemPrice itemPrice, Order order) {
		this.id = id;
		this.itemPrice = itemPrice;
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ItemPrice getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return String.format("OrderDetail [id=%s]", id);
	}
}

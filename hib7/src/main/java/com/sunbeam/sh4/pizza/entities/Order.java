package com.sunbeam.sh4.pizza.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ORDERS")
public class Order implements Serializable {
	@Id
	@Column
	private int id;
	@Column
	private Date orderTime;
	@Column
	private String status;
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Customer customer;
	@OneToMany(mappedBy="order")
	private List<OrderDetail> detailsList;
	public Order() {
		this(0, new Date(), "Pending");
	}
	public Order(int id, Date orderTime, String status) {
		this.id = id;
		this.orderTime = orderTime;
		this.status = status;
		this.customer = new Customer();
	}
	public List<OrderDetail> getDetailsList() {
		return detailsList;
	}
	public void setDetailsList(List<OrderDetail> detailsList) {
		this.detailsList = detailsList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return String.format("Order [id=%s, orderTime=%s, status=%s]", id, orderTime,
				status);
	}
}

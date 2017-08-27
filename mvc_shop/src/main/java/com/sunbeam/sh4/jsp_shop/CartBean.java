package com.sunbeam.sh4.jsp_shop;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
	private String[] bookIds;
	private List<Integer> cart;
	public CartBean() {
		this.bookIds = new String[0];
		this.cart = new ArrayList<>();
	}
	public String[] getBookIds() {
		return bookIds;
	}
	public void setBookIds(String[] bookIds) {
		this.bookIds = bookIds;
	}
	public List<Integer> getCart() {
		return cart;
	}
	public void setCart(List<Integer> cart) {
		this.cart = cart;
	}
	public void addToCart() {
		for (String bkid : bookIds) {
			int id = Integer.parseInt(bkid);
			cart.add(id);
		}
	}
}

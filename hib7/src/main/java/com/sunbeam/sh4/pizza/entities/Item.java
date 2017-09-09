package com.sunbeam.sh4.pizza.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PIZZA_ITEMS")
public class Item implements Serializable {
	@GenericGenerator(name="gen", strategy="native")
	@GeneratedValue(generator="gen")
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String type;
	@Column
	private String category;
	@Column
	private String description;
	@OneToMany(mappedBy="item")
	private List<ItemPrice> priceList;
	public Item() {
		this(0, "", "", "", "");
	}
	public Item(int id, String name, String type, String category, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.priceList = new ArrayList<>();
	}
	public List<ItemPrice> getPriceList() {
		return priceList;
	}
	public void setPriceList(List<ItemPrice> priceList) {
		this.priceList = priceList;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, type=%s, category=%s, description=%s]", id, name, type, category,
				description);
	}
}

package com.sunbeam.sh4.pizza.main;

import java.util.List;

import com.sunbeam.sh4.pizza.daos.MenuDao;
import com.sunbeam.sh4.pizza.entities.Item;

public class Hib7Main {
	public static void main(String[] args) {
		MenuDao dao = new MenuDao();
		List<String> typeList = dao.getTypes();
		System.out.println(typeList);
		List<String> categoryList = dao.getCategories("NonVeg");
		for (String category : categoryList) {
			System.out.println(category);
		}
		List<Item> itemList = dao.getItems("NonVeg", "NonVeg Feast");
		for (Item item : itemList) {
			System.out.println(item);
		}
	}
}

package com.sunbeam.sh4.pizza.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sunbeam.sh4.pizza.daos.MenuDao;
import com.sunbeam.sh4.pizza.entities.Item;
import com.sunbeam.sh4.pizza.utils.HbUtil;

public class MenuDaoTest {
	private MenuDao menuDao = new MenuDao();
	
	@Before
	public void setUp() throws Exception {
		HbUtil.newTransaction();
	}

	@After
	public void tearDown() throws Exception {
		HbUtil.commitTransaction();
	}
	
	@Test
	public void testGetTypes() {
		List<String> typeList = menuDao.getTypes();
		System.out.println(typeList);
	}

	@Test
	public void testGetCategories() {
		List<String> categoryList = menuDao.getCategories("Veg");
		for (String category : categoryList) {
			System.out.println(category);
		}
	}

	@Test
	public void testGetItems() {
		List<Item> itemList = menuDao.getItems("Veg", "Sides");
		for (Item item : itemList) {
			System.out.println(item);
		}
	}
	
	@Test
	public void testGetItem() {
		Item item = menuDao.getItem(1);
		System.out.println("Item Found : " + item);
		assertNotNull(item);
	}
}

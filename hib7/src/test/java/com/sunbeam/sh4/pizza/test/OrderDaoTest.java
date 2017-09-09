package com.sunbeam.sh4.pizza.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sunbeam.sh4.pizza.daos.CustomerDao;
import com.sunbeam.sh4.pizza.daos.MenuDao;
import com.sunbeam.sh4.pizza.daos.OrderDao;
import com.sunbeam.sh4.pizza.entities.Customer;
import com.sunbeam.sh4.pizza.entities.ItemPrice;
import com.sunbeam.sh4.pizza.entities.Order;
import com.sunbeam.sh4.pizza.entities.OrderDetail;
import com.sunbeam.sh4.pizza.utils.HbUtil;

public class OrderDaoTest {
	private CustomerDao customerDao = new CustomerDao();
	private MenuDao menuDao = new MenuDao();
	private OrderDao orderDao = new OrderDao();
	@Before
	public void setUp() throws Exception {
		HbUtil.newTransaction();
	}

	@After
	public void tearDown() throws Exception {
		HbUtil.commitTransaction();
	}

	@Test
	public void testAddOrder() {
		Customer cust = customerDao.getCustomer("nilesh@sunbeaminfo.com");
		Order order = new Order(2, new Date(), "Pending");
		ItemPrice item1 = menuDao.getItemPrice(8);
		ItemPrice item2 = menuDao.getItemPrice(15);
		OrderDetail detail1 = new OrderDetail(3, item1, order);
		OrderDetail detail2 = new OrderDetail(4, item2, order);
		order.setCustomer(cust);
		order.getDetailsList().add(detail1);
		order.getDetailsList().add(detail2);
		orderDao.addOrder(order);
		System.out.println("Order Placed !");
	}
	
	@Test
	public void testGetOrder() {
		Order order = orderDao.getOrder(1);
		System.out.println(order.getCustomer());
		System.out.println(order);
		for (OrderDetail orderDetail : order.getDetailsList()) {
			ItemPrice itemPrice = orderDetail.getItemPrice();
			System.out.println("\t" + itemPrice.getItem() + itemPrice.getSize());
		}
	}
}

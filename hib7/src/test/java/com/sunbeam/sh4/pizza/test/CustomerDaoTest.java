package com.sunbeam.sh4.pizza.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sunbeam.sh4.pizza.daos.CustomerDao;
import com.sunbeam.sh4.pizza.entities.Customer;
import com.sunbeam.sh4.pizza.utils.HbUtil;

public class CustomerDaoTest {
	private CustomerDao customerDao = new CustomerDao();
	@Before
	public void setUp() throws Exception {
		HbUtil.newTransaction();
	}

	@After
	public void tearDown() throws Exception {
		HbUtil.commitTransaction();
	}

	@Test
	public void testGetCustomer() {
		 Customer cust = customerDao.getCustomer("nilesh@sunbeaminfo.com");
		 System.out.println(cust);
		 assertNotNull(cust);
	}
	
	@Test
	public void testAddCustomer() {
		Customer cust = new Customer(5, "sandeep", "sandeep", "sandeep@sunbeaminfo.com", "9822012345", "Nagar"); 
		customerDao.addCustomer(cust);
		System.out.println("Customer added");
	}
}

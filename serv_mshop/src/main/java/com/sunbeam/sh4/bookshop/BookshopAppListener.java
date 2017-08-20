package com.sunbeam.sh4.bookshop;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BookshopAppListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent e) {		
		System.out.println("BookShop application deployed.");
	}
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("BookShop application stopped.");
	}
}

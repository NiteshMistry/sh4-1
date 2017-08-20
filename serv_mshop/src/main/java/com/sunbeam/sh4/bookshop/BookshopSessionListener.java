package com.sunbeam.sh4.bookshop;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class BookshopSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		HttpSession session = e.getSession();
		session.setAttribute("cart", new ArrayList<Integer>());
		System.out.println("New Session created & Empty cart added into session.");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println("Session of user is destroyed.");
	}
}

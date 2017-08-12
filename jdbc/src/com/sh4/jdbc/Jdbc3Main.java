package com.sh4.jdbc;

import java.util.List;

public class Jdbc3Main {
	public static void main(String[] args) {
		//insert test
//		try(ContactDao dao = new ContactDao()) {
//			dao.open();
//			Contact c = new Contact(3, "Sandeep", "sandeep@sunbeam.com", "1234567890");
//			int cnt = dao.addContact(c);
//			System.out.println("Rows inserted : " + cnt);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}

		//update test
//		try(ContactDao dao = new ContactDao()) {
//			dao.open();
//			Contact c = new Contact(3, "Sandip", "sandeep@gmail.com", "1234567890");
//			int cnt = dao.updateContact(c);
//			System.out.println("Rows updated : " + cnt);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}

		// delete test
		try(ContactDao dao = new ContactDao()) {
			dao.open();
			int cnt = dao.deleteContact(3);
			System.out.println("Rows deleted : " + cnt);
		}catch (Exception e) {
			e.printStackTrace();
		}

		//select test
		try(ContactDao dao = new ContactDao()) {
			dao.open();
			List<Contact> list = dao.getContacts();
			for (Contact c : list) {
				System.out.println(c);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.sunbeam.sh4.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Hib6Main {
	public static void main(String[] args) {
		SessionFactory factory = HbUtil.getSessionFactory();
		Session hbSession = factory.openSession();
		
		Emp e = (Emp) hbSession.get(Emp.class, 7934);
		System.out.println(e);
		Address addr = e.getAddress();
		System.out.println(addr);
		
		List<Meeting> meetingList = e.getMeetingList();
		for (Meeting meeting : meetingList) {
			System.out.println(meeting);
		}
		
		Meeting meeting = (Meeting) hbSession.get(Meeting.class, 1);
		List<Emp> empList = meeting.getEmpList();
		for (Emp emp : empList) {
			System.out.println(emp);
		}
		hbSession.close();
		factory.close();
	}
}

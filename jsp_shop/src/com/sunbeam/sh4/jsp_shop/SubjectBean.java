package com.sunbeam.sh4.jsp_shop;

import java.util.ArrayList;
import java.util.List;

public class SubjectBean {
	private List<String> subjectList;
	public SubjectBean() {
		subjectList = new ArrayList<>();
	}
	public List<String> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}
	public void fetchSubjects() {
		try (BookDao dao = new BookDao()) {
			dao.open();
			subjectList = dao.getSubjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

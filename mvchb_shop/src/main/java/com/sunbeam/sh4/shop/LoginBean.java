package com.sunbeam.sh4.shop;

public class LoginBean {
	private String uname;
	private String upass;
	public LoginBean() {
		this.uname = "";
		this.upass = "";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public boolean getStatus() {
		boolean result = false;
		try (LoginDao dao = new LoginDao()) {
			dao.open();
			result = dao.checkLogin(uname, upass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

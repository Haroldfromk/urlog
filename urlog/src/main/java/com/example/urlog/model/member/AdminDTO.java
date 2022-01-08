package com.example.urlog.model.member;

public class AdminDTO {
	
	private String admin_userid;
	private String admin_passwd;
	private String admin_name;
	
	public AdminDTO() {
	
	}

	public String getAdmin_userid() {
		return admin_userid;
	}

	public void setAdmin_userid(String admin_userid) {
		this.admin_userid = admin_userid;
	}

	public String getAdmin_passwd() {
		return admin_passwd;
	}

	public void setAdmin_passwd(String admin_passwd) {
		this.admin_passwd = admin_passwd;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	@Override
	public String toString() {
		return "AdminDTO [admin_userid=" + admin_userid + ", admin_passwd=" + admin_passwd + ", admin_name="
				+ admin_name + "]";
	}

	public AdminDTO(String admin_userid, String admin_passwd, String admin_name) {
		this.admin_userid = admin_userid;
		this.admin_passwd = admin_passwd;
		this.admin_name = admin_name;
	}
	
	
	
	
	
}

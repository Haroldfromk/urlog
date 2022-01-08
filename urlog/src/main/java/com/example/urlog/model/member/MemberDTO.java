package com.example.urlog.model.member;

import java.util.Date;

public class MemberDTO {
	
	private String userid;			
	private String member_passwd;
	private String member_name;
	private String member_email;				
	private String member_tel;					
	private Date join_date;
	private String logo;
	
	public MemberDTO() {
	
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMember_passwd() {
		return member_passwd;
	}

	public void setMember_passwd(String member_passwd) {
		this.member_passwd = member_passwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", member_passwd=" + member_passwd + ", member_name=" + member_name
				+ ", member_email=" + member_email + ", member_tel=" + member_tel + ", join_date=" + join_date
				+ ", logo=" + logo + "]";
	}

	
}

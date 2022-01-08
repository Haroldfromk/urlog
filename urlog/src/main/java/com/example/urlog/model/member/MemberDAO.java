package com.example.urlog.model.member;

public interface MemberDAO {

	String login(MemberDTO dto);
	MemberDTO detail(String userid);
	void insert(MemberDTO dto);
	void delete(String userid);
	void update(MemberDTO dto);
	int idcheck(String userid);
	boolean check_passwd(String userid, String member_passwd);
	String logo(MemberDTO dto);
}

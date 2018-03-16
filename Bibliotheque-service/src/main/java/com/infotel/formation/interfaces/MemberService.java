package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Member;

public interface MemberService {

	public void insertMember(Member member);

	public void updateMember(Member member);

	public void deleteMember(Member member);

	public Member getMemberById(int idMember);

	public Member getUserByMail(String memberMail);

	public boolean isMailAlreadyExist(String memberMail);
	
	public boolean isAccountExistString(String email, String pw);
	
	public boolean isAccountExist(Member member);

	public Member login(String email, String pw) throws Exception;

	public String encryptPw(String pw);	
	
	public List<Member> getMembers();

}

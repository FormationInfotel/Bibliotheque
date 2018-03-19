package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Member;

public interface MemberService {

	public void insertMember(Member member) throws Exception;

	public void updateMember(Member member) throws Exception;

	public void deleteMember(Member member) throws Exception;

	public Member getMemberById(long idMember);

	public Member getUserByMail(String memberMail);

	public boolean isMailAlreadyExist(String memberMail);
	
	public boolean isAccountExistString(String email, String pw);
	
	public boolean isAccountExist(Member member);

	public Member login(String email, String pw) throws Exception;

	public String encryptPw(String pw);	
	
	public List<Member> getMembers();

}

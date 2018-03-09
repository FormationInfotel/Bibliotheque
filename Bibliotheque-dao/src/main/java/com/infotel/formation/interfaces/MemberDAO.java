package com.infotel.formation.interfaces;

import java.util.List;

import com.infotel.formation.entity.Member;

public interface MemberDAO {

	void insertMember(Member member);

	public Member getMemberById(int memberId);

	Member getMember(String memberFirstName, String memberLastName);

	List<Member> getMembers();

	public Member getUserByMail(String memberMail);

	public boolean isMailAlreadyExist(String memberMail);

	public boolean isAccountExist(Member member);

}
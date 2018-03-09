package com.infotel.formation.interfaces;

import com.infotel.formation.entity.Member;

public interface MemberService {

	public void insertMember(Member member);

	public boolean isAccountExist(Member member);

	public Member getUserByMail(String memberMail);

	public boolean isMailAlreadyExist(String memberMail);

	public String encryptPw(String pw);

}
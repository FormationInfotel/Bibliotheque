package com.infotel.formation.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.formation.entity.Member;
import com.infotel.formation.exception.ErrorConstants;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.MemberDAO;
import com.infotel.formation.interfaces.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public void insertMember(Member member) {
		memberDAO.insertMember(member);
	}

	@Override
	public void updateMember(Member member) {
		memberDAO.updateMember(member);
	}

	@Override
	public void deleteMember(Member member) {
		memberDAO.deleteMember(member);
	}

	@Override
	public boolean isAccountExist(Member member) {
		return memberDAO.isAccountExist(member);
	}

	@Override
	public Member getUserByMail(String memberMail) {
		return memberDAO.getUserByMail(memberMail);
	}

	@Override
	public boolean isMailAlreadyExist(String memberMail) {
		return memberDAO.isMailAlreadyExist(memberMail);
	}

	@Override
	public String encryptPw(String pw) {

		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(pw.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}

		return generatedPassword;
	}

	@Override
	public List<Member> getMembers() {
		return memberDAO.getMembers();
	}

	@Override
	public Member getMemberById(long idMember) {
		return memberDAO.getMemberById(idMember);
	}
	
	@Override
	public Member login(String email, String pw) throws Exception {
		
		if (!memberDAO.isAccountExistString(email, pw))
			throw new ServiceException(ErrorConstants.ACCOUNT_NOT_EXISTING);
		else 
			return memberDAO.getUserByMail(email);
		
	}

	@Override
	public boolean isAccountExistString(String email, String pw) {
		return memberDAO.isAccountExistString(email, pw);
	}


}

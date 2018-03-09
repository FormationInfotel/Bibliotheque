package com.infotel.formation.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.formation.entity.Member;
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


}
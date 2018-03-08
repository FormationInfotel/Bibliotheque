package com.infotel.formation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.MemberDAO;
import com.infotel.formation.interfaces.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	public void insertMember(Member member) {
		memberDAO.insertMember(member);
	}

	
}

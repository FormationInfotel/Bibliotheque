package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.infotel.formation.DTO.MemberDTO;
import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.MemberService;


public class MemberController2 {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping(value = "/book/get")
	public List<MemberDTO> getMembers() {
		List<MemberDTO> getAllMembers = new ArrayList<MemberDTO>();
		
		List<Member> members = memberService.getMembers();
		
		for (Member m : members) {
			MemberDTO mDTO = new MemberDTO();
			
		}
		
		
		
		return null;
		
		
	}

}

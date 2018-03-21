package com.infotel.formation.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infotel.formation.DTO.MemberDTO;
import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.LibraryService;

@Component
public class MemberMapper {

	@Autowired
	LibraryService libraryService;

	public Member mapIntoMember(MemberDTO memberDTO) {
		System.out.println(memberDTO.getMember_lastname());
		System.out.println(memberDTO.getMember_firstname());
		System.out.println(memberDTO.getMember_email());
		System.out.println(memberDTO.getMember_address());
		System.out.println(memberDTO.getMember_password());
		System.out.println(memberDTO.isMemberAdmin());
		System.out.println(memberDTO.getMember_LibraryId());
		System.out.println(libraryService.getLibraryById(memberDTO.getMember_LibraryId()));
		Member member = new Member(memberDTO.getMember_lastname(), memberDTO.getMember_firstname(),
				memberDTO.getMember_email(), memberDTO.getMember_address(), memberDTO.getMember_password(),
				memberDTO.isMemberAdmin());
		// member.setMember_id(memberDTO.getMember_id());
		member.setMember_Library(libraryService.getLibraryById(memberDTO.getMember_LibraryId()));

		return (member);
	}

	public MemberDTO mapIntoMemberDTO(Member member) {
		MemberDTO memberDTO = new MemberDTO(member.getMember_lastname(), member.getMember_firstname(),
				member.getMember_email(), member.getMember_address(), member.getMember_password(),
				member.isMemberAdmin());
		memberDTO.setMember_id(member.getMember_id());
		memberDTO.setMember_LibraryId(member.getMember_Library().getLibrary_code());

		return (memberDTO);
	}

}

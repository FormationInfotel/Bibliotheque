package com.infotel.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.BookDTO;
import com.infotel.formation.DTO.MemberDTO;
import com.infotel.formation.Mapper.MemberMapper;
import com.infotel.formation.entity.Book;
import com.infotel.formation.entity.Member;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.MemberService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;

@RestController
public class MemberController2 {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberMapper mapper;

	@GetMapping(value = "/member/get")
	public Resultat getMembers() {
		List<MemberDTO> viewMembers = new ArrayList<MemberDTO>();
		List<Member> members = new ArrayList<Member>();
		Resultat res = new Resultat();

		try {
			members = memberService.getMembers();

			for (Member member : members) {
				viewMembers.add(mapper.mapIntoMemberDTO(member));
			}

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.GET_SUCCES);
			res.setPayload(viewMembers);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}
	
	@PostMapping(value = "/member/getOne")
	public Resultat getMemberById(@RequestBody long Id) throws ServiceException {
		Resultat res = new Resultat();
		try {
			List<MemberDTO> viewMembers = new ArrayList<MemberDTO>();

			Member member = memberService.getMemberById(Id);

			viewMembers.add(mapper.mapIntoMemberDTO(member));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.GET_SUCCES);
			res.setPayload(viewMembers);

		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PutMapping(value = "/member/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat addMember(@RequestBody MemberDTO memberDTO) {
		Resultat res = new Resultat();
		try {
			System.out.println(memberDTO);
			memberService.insertMember(mapper.mapIntoMember(memberDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.INSERT_SUCCESS);
			res.setPayload(memberDTO);
		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}

		return res;
	}

	@PostMapping(value = "/member/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat updateMember(@RequestBody MemberDTO memberDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			memberService.updateMember(mapper.mapIntoMember(memberDTO));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(memberDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

	@DeleteMapping(value = "/member/delete", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Resultat deleteMember(@RequestBody MemberDTO memberDTO) throws Exception {
		Resultat res = new Resultat();

		try {
			memberService.deleteMember(memberService.getMemberById(memberDTO.getMember_id()));

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.UPDATE_SUCCESS);
			res.setPayload(memberDTO);

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("Err");
		}
		return res;
	}

}

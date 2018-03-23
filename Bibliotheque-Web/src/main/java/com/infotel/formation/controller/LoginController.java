package com.infotel.formation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.MemberDTO;
import com.infotel.formation.Mapper.MemberMapper;
import com.infotel.formation.entity.Member;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.MemberService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;
import com.infotel.formation.viewmodel.IdentifiantsVM;

@RestController
public class LoginController {

	@Autowired
	private MemberService memberService;

	@Autowired
	MemberMapper mapper;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String connexionMembre(Model model) {

		Member membre = new Member();
		model.addAttribute("membre", membre);
		return "login";
	}

	@PostMapping(value = "/login")
	private Resultat connexionMembre(MemberDTO memberDTO, @RequestBody IdentifiantsVM identifiants,
			HttpServletRequest request) {
		Resultat res = new Resultat();
		try {
			HttpSession session = request.getSession();

			Member membre = memberService.login(identifiants.getEmail(), identifiants.getPassword());

			memberDTO = mapper.mapIntoMemberDTO(membre);

			session.setAttribute(ControllerConstants.MEMBRE_SESSION, memberDTO);

			res.setIsSucces(true);
			res.setMessage(ControllerConstants.LOGIN_SUCCESS);
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

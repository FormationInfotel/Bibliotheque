package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.formation.DTO.MemberDTO;
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String connexionMembre(Model model) {

		Member membre = new Member();
		model.addAttribute("membre", membre);
		return "login";
	}

	// private String connexionMembre(Model model, HttpServletRequest request) {
	// String email = request.getParameter("txtboxEmail");
	// String pswd = request.getParameter("txtboxPswd");
	//
	// if (memberService.isAccountExistString(email, pswd)) {
	// return "redirect:/";
	// }
	//
	// return "login";
	// }

	@PostMapping(value = "/login")
	private Resultat connexionMembre(MemberDTO memberDTO, @RequestBody IdentifiantsVM identifiants) {
		Resultat res = new Resultat();
		try {
			Member membre = memberService.login(identifiants.getEmail(), identifiants.getPassword());

			memberDTO.setMember_firstname(membre.getMember_firstname());
			memberDTO.setMember_lastname(membre.getMember_lastname());
			memberDTO.setMember_address(membre.getMember_address());

			memberDTO.setMember_email(membre.getMember_email());
			memberDTO.setMember_password(membre.getMember_password());

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

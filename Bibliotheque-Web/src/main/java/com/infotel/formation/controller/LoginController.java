package com.infotel.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Member;
import com.infotel.formation.exception.ServiceException;
import com.infotel.formation.interfaces.MemberService;
import com.infotel.formation.utils.ControllerConstants;
import com.infotel.formation.utils.Resultat;
import com.infotel.formation.viewmodel.IdentifiantsVM;

@Controller
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private Resultat connexionMembre(@RequestBody IdentifiantsVM identifiants) {
		Resultat res = new Resultat();
				
		try {
			memberService.login(identifiants.getEmail(), identifiants.getPassword());
			
			res.setIsSucces(true);
			res.setMessage(ControllerConstants.LOGIN_SUCCESS);
			

		} catch (ServiceException serviceException) {
			res.setIsSucces(false);
			res.setMessage(serviceException.getMessage());
		} catch (Exception e) {
			res.setIsSucces(false);
			res.setMessage("");
		}

		return res;
	}

}

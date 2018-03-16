package com.infotel.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.MemberDAO;

@Controller
public class LoginController {
	
	@Autowired
	private MemberDAO memberDAO;

	// @Autowired
	// private MemberService memberService;
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    private String connexionMembre(Model model) {

        Member membre = new Member();
        model.addAttribute("membre", membre);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String connexionMembre(Model model, HttpServletRequest request) {
    	String email = request.getParameter("txtboxEmail");
    	String pswd = request.getParameter("txtboxPswd");
    	
    	if (memberDAO.isAccountExistString(email, pswd)) {
    		return "redirect:/";
    	}
    	
    	return "login";
    }

}


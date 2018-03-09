package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private String connexionMembre(@ModelAttribute("login") Member membre, Model model) {

    	
    	
    	System.out.println("email " + membre.getMember_email());
    	System.out.println("pw " +membre.getMember_password());
    	
        //String pw = memberDAO.cryptageMdp(nouveauMembre);
    	String pw = null;
    	membre.setMember_password(pw);
    	
    	 return "redirect:/";
    	
//        if (memberDAO.identification(nouveauMembre.getMember_email(), nouveauMembre.getMember_password()) == null) {
//            model.addAttribute("msgErreur", "Veuillez saisir un identifiant et un mot de passe valide");
//            return "connexion";
//        } else {
//            return "redirect:/";
//        }
    }

}


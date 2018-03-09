package com.infotel.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String ajoutMembre(Model model) {

        Member nouveauMembre = new Member();
        model.addAttribute("nouveauMembre", nouveauMembre);
        return "registration";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String ajoutMembre(@ModelAttribute("nouveauMembre") Member nouveauMembre, Model model) {
    	
        //String pass = membreService.cryptageMdp(newMembre);
        //newMembre.setPassword(pass);
//        if (membreService.findByEmail(newMembre.getEmail()) != null) {
//            model.addAttribute("msgErreur", "Cet email est déjà utilisé");
//            newMembre.setPassword("");
//            return "inscription";
//        } else {
//        	memberDAO.save(nouveauMembre);
//        return "redirect:/";
//        }
    	  			
    			memberService.insertMember(nouveauMembre);
    	
    	return "redirect:/";
    }
	
}

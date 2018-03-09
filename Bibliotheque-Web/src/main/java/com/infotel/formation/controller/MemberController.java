package com.infotel.formation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infotel.formation.entity.Library;
import com.infotel.formation.entity.Member;
import com.infotel.formation.interfaces.LibraryService;
import com.infotel.formation.interfaces.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	LibraryService libraryService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String ajoutMembre(Model model) {

        Member nouveauMembre = new Member();
		Library biblioDuMembre = new Library();
        model.addAttribute("nouveauMembre", nouveauMembre);
		model.addAttribute("biblioDuMembre", biblioDuMembre);
        return "registration";
    }

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String ajoutMembre(@ModelAttribute("nouveauMembre") Member nouveauMembre,
			@ModelAttribute("biblioDuMembre") Library biblioDuMembre, Model model) {
		String pass = memberService.encryptPw(nouveauMembre.getMember_password());
		nouveauMembre.setMember_password(pass);

		System.out.println("bibliomembre" + biblioDuMembre);

		nouveauMembre.setMember_Library(biblioDuMembre);

		if (memberService.isMailAlreadyExist(nouveauMembre.getMember_email()) == true
				&& memberService.isAccountExist(nouveauMembre) == false) {
			model.addAttribute("msgErreur", "Cet email est déjà utilisé");

			return "redirect:/";

		} else {
			memberService.insertMember(nouveauMembre);
			return "registration";
		}

	}

	@ModelAttribute("libraryList")
	public Map<Integer, String> getLibraryList() {
		Map<Integer, String> libraryList = new HashMap<Integer, String>();

		List<Library> libraries = libraryService.getLibraries();

		for (int i = 1; i <= libraries.size(); i++) {

			libraryList.put(i, libraryService.getLibraryById(i).getLibrary_name());
		}
		return libraryList;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String connexionMembre(Model model) {
		Member membre = new Member();
		model.addAttribute("membre", membre);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String connexionMembre(@ModelAttribute("login") Member membre, Model model) {
		String pw = memberService.encryptPw(membre.getMember_password());
		membre.setMember_password(pw);

		// model.addAttribute("membre", membre);
		model.addAttribute("membre", membre);

		if (memberService.isAccountExist(membre)) {
			return "login";
		} else {
			model.addAttribute("errMsg", "Password incorrect");
			return "redirect:/";
		}
    }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
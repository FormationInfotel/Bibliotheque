package com.infotel.formation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		nouveauMembre.setMember_Library(biblioDuMembre);

		if (memberService.isMailAlreadyExist(nouveauMembre.getMember_email()) == true
				&& memberService.isAccountExist(nouveauMembre) == false) {
			model.addAttribute("msgErreur", "Cet email est déjà utilisé");

			return "redirect:/";

		} else {
			// memberService.insertMember(nouveauMembre);
			return "registration";
		}

	}

	// @ModelAttribute("libraryList")
	// public Map<Long, String> getLibraryList() {
	// Map<Long, String> libraryList = new HashMap<Long, String>();
	//
	// for (Library L : libraryService.getLibraries()) {
	// libraryList.put(L.getLibrary_code(), L.getLibrary_name());
	// }
	//
	// return libraryList;
	// }


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// list page
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String showAllUsers(Model model) throws Exception {

		model.addAttribute("users", memberService.getMembers());

		return "list";
	}

	// save or update user
	// 1. @ModelAttribute bind form value
	// 2. @Validated form validator
	// 3. RedirectAttributes for flash value
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") Member membre, BindingResult result, Model model,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) {

				//A debug dropdownlist
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Member user = memberService.getMemberById(id);
		Member tmpMember = new Member();
		System.out.println(membre);
		tmpMember = memberService.getMemberById((int) membre.getMember_id());
		String libname = "Mediathèque Angers";
		// String libname = request.getParameterValues("ListeLib");
		// System.out.println(libname);
		// System.out.println(libraryService.getLibraryByName(libname));
		membre.setMember_Library(libraryService.getLibraryByName(libname));

		if (tmpMember == membre) {
			// memberService.insertMember(membre);
		} else {
			// memberService.updateMember(membre);
		}

		
		return "redirect:/users/" + membre.getMember_id();

	}

	// show add user form
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Member user = new Member();

		// set default value
		// user.setMember_firstname(member_firstname);
		// user.setMember_email(member_email);

		model.addAttribute("userForm", user);

		return "users/userform";

	}

	// show update form
	@RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

		Member user = memberService.getMemberById(id);
		model.addAttribute("userForm", user);

		return "userform";
	}

	// delete user
	// @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		Member tmpMembre = new Member();
		tmpMembre = memberService.getMemberById(id);

		// memberService.deleteMember(tmpMembre);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/users";
	}

	// show user
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {

		Member membre = memberService.getMemberById(id);

		if (membre == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", membre);

		return "show";

	}

}

package com.infotel.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageBaseController {
	
	@RequestMapping("/test")
	public String getHeader() {
		return "pageBase";
	}

}



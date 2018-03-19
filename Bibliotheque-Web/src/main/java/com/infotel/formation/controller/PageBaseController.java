package com.infotel.formation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageBaseController {
	
	@GetMapping(value = "/test")
	public String getHeader() {
		return "pageBase";
	}

}



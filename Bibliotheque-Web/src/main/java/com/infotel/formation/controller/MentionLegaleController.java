package com.infotel.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentionLegaleController {

	@RequestMapping("/MentionLegale")
	public String getMentionLegale() {
		return "MentionLegale";
	}
}

package com.arun.word.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tag")
public class TagController {

	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String trainGet(Model model) {
		System.out.println("Tag GET Method");
		return "tag/stats";
	}

}

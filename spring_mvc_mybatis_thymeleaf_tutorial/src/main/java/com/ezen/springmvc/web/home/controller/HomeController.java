package com.ezen.springmvc.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {
	
	public String home(Model model) {
		log.info("home request");
		return "index";
	}
}

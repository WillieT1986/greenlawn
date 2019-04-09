package com.wrthompsonjr.greenlawn.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrthompsonjr.greenlawn.data.CemeterySectionRepository;

@Controller
public class CemeterySectionController {

	@Resource
	private CemeterySectionRepository cemeterySectionRepo;

	@RequestMapping(value = "cemeterySections")
	public String findAllCemeterySections(Model model) {
		model.addAttribute("cemeterySections", cemeterySectionRepo.findAll());
		return "cemeterySections";
	}

	@RequestMapping("cemeterySection")
	public String findOneCemeterySection(@RequestParam Long id, Model model) {
		model.addAttribute("cemeterySection", cemeterySectionRepo.getOne(id));
		return "cemeterySection";
	}
}
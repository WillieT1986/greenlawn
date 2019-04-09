package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CemeterySectionController {

	@Resource
	private CemeterySectionRepository cemeterySectionRepo;

	@ResponseBody
	@GetMapping(value = "cemeterySections")
	public String findAllCemeterySections(Model model) {
		model.addAttribute("cemeterySections", cemeterySectionRepo.findAll());
		return "cemeterySections";
	}

	@ResponseBody
	@GetMapping("cemeterySection")
	public String findOneCemeterySection(@RequestParam Long id, Model model) {
		model.addAttribute("cemeterySection", cemeterySectionRepo.getOne(id));
		return "cemeterySection";
	}

}

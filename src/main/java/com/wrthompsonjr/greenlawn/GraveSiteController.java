package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GraveSiteController {

	@Resource
	private GraveSiteRepository graveSiteRepo;

	@ResponseBody
	@GetMapping(value = "graveSites")
	public String findAllGraveSites(@RequestParam Long id, Model model) {
		model.addAttribute("graveSites", graveSiteRepo.findAll());
		return "graveSites";

	}

	@ResponseBody
	@GetMapping("graveSite")
	public String findOneGraveSite(@RequestParam Long id, Model model) {
		model.addAttribute("graveSite", graveSiteRepo.getOne(id));
		return "graveSite";
	}
}
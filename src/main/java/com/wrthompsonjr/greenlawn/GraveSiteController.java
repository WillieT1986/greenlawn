package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraveSiteController {

	@Resource
	private GraveSiteRepository graveSiteRepo;

	@RequestMapping("graveSite")
	public String findOneGraveSite(@RequestParam long id, Model model) {
		model.addAttribute("graveSite", graveSiteRepo.getOne(id));
		return "graveSite";
	}

}

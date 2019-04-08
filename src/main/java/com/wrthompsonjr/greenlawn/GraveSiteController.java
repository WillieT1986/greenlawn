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

	@Resource
	private CemeterySectionRepository cemeterySectionRepo;

	@Resource
	private TagRepository tagRepo;

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

	@ResponseBody
	@GetMapping(value = "cemeterySections")
	public String findAllCemeterySections(@RequestParam Long id, Model model) {
		model.addAttribute("cemeterySections", cemeterySectionRepo.findAll());
		return "cemeterySections";
	}

	@ResponseBody
	@GetMapping("cemeterySection")
	public String findOneCemeterySection(@RequestParam Long id, Model model) {
		model.addAttribute("cemeterySection", cemeterySectionRepo.getOne(id));
		return "cemeterySection";
	}

	@ResponseBody
	@GetMapping(value = "tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@ResponseBody
	@GetMapping("tag")
	public String findOneTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.getOne(id));
		return "tag";
	}

}

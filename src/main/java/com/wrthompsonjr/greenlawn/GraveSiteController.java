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

	@Resource
	private CemeterySectionRepository cemeterySectionRepo;

	@Resource
	private TagRepository tagRepo;

	@RequestMapping(value = "graveSites")
	public String findAllGraveSites(@RequestParam Long id, Model model) {
		model.addAttribute("graveSites", graveSiteRepo.getAll());
		return "graveSites";

	}

	@RequestMapping("graveSite")
	public String findOneGraveSite(@RequestParam long id, Model model) {
		model.addAttribute("graveSite", graveSiteRepo.getOne(id));
		return "graveSite";
	}

	@RequestMapping(value = "cemeterySections")
	public String findAllCemeterySections(@RequestParam Long id, Model model) {
		model.addAttribute("cemeterySections", cemeterySectionRepo.getAll());
		return "cemeterySections";
	}

	@RequestMapping("cemeterySection")
	public String findOneCemeterySection(@RequestParam long id, Model model) {
		model.addAttribute("cemeterySection", cemeterySectionRepo.getOne(id));
		return "cemeterySection";
	}

	@RequestMapping(value = "tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.getAll());
		return "tags";
	}

	@RequestMapping("tag")
	public String findOneTag(@RequestParam long id, Model model) {
		model.addAttribute("tag", tagRepo.getOne(id));
		return "tag";
	}

}

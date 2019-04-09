package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController {

	@Resource
	private TagRepository tagRepo;

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
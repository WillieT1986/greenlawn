package com.wrthompsonjr.greenlawn.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wrthompsonjr.greenlawn.data.TagRepository;

@Controller
public class TagController {

	@Resource
	private TagRepository tagRepo;

	@RequestMapping(value = "tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("tag")
	public String findOneTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.getOne(id));
		return "tag";
	}
}
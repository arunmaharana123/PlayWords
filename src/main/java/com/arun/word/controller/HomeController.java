package com.arun.word.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arun.word.domain.Tag;
import com.arun.word.domain.Word;
import com.arun.word.service.CategoryService;
import com.arun.word.service.RelatedTagService;
import com.arun.word.service.TagService;
import com.arun.word.service.WordService;

@Controller
public class HomeController {

	@Autowired
	private WordService wordService;

	@Autowired
	private TagService tagService;

	@Autowired
	private RelatedTagService relatedTagService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("WORDCOUNT", wordService.count());
		model.addAttribute("TAGCOUNT", tagService.count());
		model.addAttribute("RELATEDTAGCOUNT", relatedTagService.count());
		model.addAttribute("CATEGORYCOUNT", categoryService.count());

		List<Word> words = wordService.findLastestWords();
		model.addAttribute("WORD100", words);

		List<Tag> tags = tagService.findLastestTags();
		model.addAttribute("TAG100", tags);
		return "home";
	}

}

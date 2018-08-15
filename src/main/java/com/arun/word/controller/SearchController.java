package com.arun.word.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arun.word.domain.Tag;
import com.arun.word.service.RelatedTagService;
import com.arun.word.service.TagService;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
	@Autowired
	private TagService tagService;

	@Autowired
	private RelatedTagService relatedTagService;

	@RequestMapping(value = "/related", method = RequestMethod.GET)
	public String trainGet(Model model, @RequestParam(value = "search", required = true) String search) {
		model.addAttribute("SEARCH", search);
		if (!StringUtils.isEmpty(search)) {
			Tag tag = tagService.existsByTag(search.toLowerCase());
			if (tag == null) {
				model.addAttribute("MESSAGE", "\"" + search + "\" word not found.");
			} else {
				List<String> tags = relatedTagService.findRelatedTagByParentId(tag.getTagId());
				model.addAttribute("TAGLIST", tags);
			}
		}
		return "search/related";
	}

}

package com.arun.word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arun.word.service.WordService;
import com.arun.word.util.TextEncoding;

@Controller
@RequestMapping(value = "/word")
public class WordController {

	@Autowired
	private WordService wordService;

	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String stats(Model model) {
		return "word/stats";
	}

	@RequestMapping(value = "/train", method = RequestMethod.GET)
	public String train(Model model, @ModelAttribute("MESSAGE") String message) {
		if (!StringUtils.isEmpty(message)) {
			model.addAttribute("MESSAGE", message);
		}
		return "word/train";
	}

	@RequestMapping(value = "/train", method = RequestMethod.POST)
	public String trainWords(RedirectAttributes redirectAttributes, Model model,
			@RequestParam(value = "wordtext", required = false) String wordText) {
		try {
			if (!StringUtils.isEmpty(wordText)) {
				System.out.println(wordText);
				String words[] = wordText.split(",");
				int saveCount = 0;
				for (String singleWord : words) {
					singleWord = StringUtils.trimWhitespace(singleWord);
					if (!StringUtils.isEmpty(singleWord)) {
						boolean result = wordService.save(TextEncoding.encoding(singleWord));
						if (result) {
							saveCount++;
						}
					}

				}
				redirectAttributes.addAttribute("MESSAGE",
						saveCount + " saved out of " + words.length + " Successfully.");
			}
			return "redirect:train";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addAttribute("MESSAGE", "Failed");
			return "redirect:/word/train";
		}
	}

}

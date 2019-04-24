package com.arun.word.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arun.word.domain.CombineWord;
import com.arun.word.domain.Paragraph;
import com.arun.word.service.CombineWordService;
import com.arun.word.service.ParagraphService;
import com.arun.word.service.StopWordService;
import com.arun.word.util.NewsApi;

@Controller
@RequestMapping(value = "/paragraph")
public class ParagraphController {

	final static private String pattern = "[-+.^:,!@#$%^&*()<>?~:;\"|\\/-=+]";

	@Autowired
	private ParagraphService paragraphService;
	@Autowired
	private CombineWordService combineWordService;

	@Autowired
	private StopWordService stopWordService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Model model) {
		List<Paragraph> paragraphs = paragraphService.findParagraphs();
		model.addAttribute("PARAGRAPH", paragraphs);
		return "paragraph/view";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		Paragraph paragraphs = paragraphService.findOneParagraphs();
		model.addAttribute("PARAGRAPH", paragraphs);
		return "paragraph/add";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String add(Model model, HttpServletRequest request) {
		String words = request.getParameter("words");
		String id = request.getParameter("id");
		if (!StringUtils.isEmpty(id)) {
			try {
				long para_id = Long.parseLong(id);
				Optional<Paragraph> paragraph = paragraphService.findById(para_id);
				paragraph.get().setStatus(1);
				paragraph.get().setWords(words);
				paragraphService.save(paragraph.get());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}
		return "redirect:/paragraph/add";
	}

	@RequestMapping(value = "/train/{id}", method = RequestMethod.GET)
	public String train(Model model, @PathVariable("id") String id) {
		if (!StringUtils.isEmpty(id)) {
			try {
				long para_id = Long.parseLong(id);
				Optional<Paragraph> paragraph = paragraphService.findById(para_id);
				paragraph.get().setActive(false);
				paragraphService.save(paragraph.get());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}
		return "redirect:/paragraph/view";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable("id") String id) {
		if (!StringUtils.isEmpty(id)) {
			try {
				long para_id = Long.parseLong(id);
				Optional<Paragraph> paragraph = paragraphService.findById(para_id);
				paragraph.get().setActive(false);
				paragraphService.save(paragraph.get());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}
		return "redirect:/paragraph/view";
	}

	@RequestMapping(value = "/getnews", method = RequestMethod.GET)
	public String getnews(Model model) {
		List<String> stopwords = stopWordService.findLastestStopWord();
		List<String> paragraphs = NewsApi.getNews();
		for (String sentence : paragraphs) {
			if (!StringUtils.isEmpty(sentence)) {
				sentence = sentence.replaceAll(pattern, "");

				Paragraph paragraph = paragraphService.findOneParagraphBySentence(sentence);
				if (paragraph != null) {
					continue;
				}
				String[] words = sentence.split(" ");

				String wordsList = "";
				for (String word : words) {
					if (word != "") {
						word = word.trim();
						if (!stopwords.contains(word)) {
							wordsList = wordsList + ", " + word;
						}
					}
				}

				paragraph = new Paragraph();
				paragraph.setCreatedDate(new Date());
				paragraph.setCreatedTime(new Date());
				paragraph.setSentence(sentence);
				paragraph.setWords(wordsList);
				paragraphService.save(paragraph);

				words = wordsList.split(",");
				for (int i = 0; i < words.length - 1; i++) {
					String combineWord = words[i].trim() + " " + words[i + 1].trim();
					CombineWord combineWord2 = combineWordService.findCombineWordByWord(combineWord);
					if (combineWord2 != null && combineWord2.isActive()) {
						combineWord2.setCount(combineWord2.getCount() + 1);
						combineWordService.save(combineWord2);
					} else {
						CombineWord combineWord3 = new CombineWord();
						combineWord3.setCount(1);
						combineWord3.setCreatedDate(new Date());
						combineWord3.setCreatedTime(new Date());
						combineWord3.setWord(combineWord);
						combineWordService.save(combineWord3);
					}
				}
			}
		}

		model.addAttribute("PARAGRAPHS", paragraphs);
		return "redirect:/paragraph/view";
	}

}

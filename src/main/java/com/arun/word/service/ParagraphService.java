package com.arun.word.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.domain.Paragraph;
import com.arun.word.domain.Word;
import com.arun.word.repository.ParagraphRepository;

@Service
public class ParagraphService {
	@Autowired
	ParagraphRepository repository;

	public long count() {
		return repository.count();
	}

	public List<Paragraph> findParagraphs() {
		return repository.findParagraphs();
	}

	public boolean save(Paragraph paragraph) {
		try {
			repository.save(paragraph);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Paragraph findById(long para_id) {
		return repository.findOne(para_id);
	}

	public Paragraph findOneParagraphs() {
		return repository.findOneParagraphs();
	}

	public Paragraph findOneParagraphBySentence(String sentence) {
		return repository.findOneParagraphBySentence(sentence);
	}

	public Paragraph findParagraphWords() {
		return repository.findParagraphWords();
	}

}

package com.arun.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.domain.CombineWord;
import com.arun.word.domain.Paragraph;
import com.arun.word.repository.CombineWordRepository;

@Service
public class CombineWordService {
	@Autowired
	CombineWordRepository repository;

	public long count() {
		return repository.count();
	}

	public boolean save(CombineWord combineWord) {
		try {
			repository.save(combineWord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public CombineWord findCombineWordByWord(String word) {
		return repository.findCombineWordByWord(word);
	}

}

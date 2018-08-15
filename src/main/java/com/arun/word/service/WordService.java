package com.arun.word.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.domain.Word;
import com.arun.word.repository.WordRepository;

@Service
public class WordService {
	@Autowired
	WordRepository repository;

	public long count() {
		return repository.count();
	}

	public List<Word> findLastestWords() {
		return repository.findLastestWords();
	}

	public boolean save(String singleWord) {
		Word word = repository.findByWord(singleWord);
		if (word == null) {
			word = new Word();
			word.setWord(singleWord);
			repository.save(word);
			return true;
		}
		return false;
	}

}

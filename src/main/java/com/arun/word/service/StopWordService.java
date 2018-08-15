package com.arun.word.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.domain.StopWords;
import com.arun.word.repository.StopWordRepository;

@Service
public class StopWordService {
	@Autowired
	StopWordRepository repository;

	public long count() {
		return repository.count();
	}

	public List<String> findLastestStopWord() {
		return repository.findLastestStopWord();
	}

}

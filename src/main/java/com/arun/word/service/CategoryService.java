package com.arun.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository repository;

	public long count() {
		return repository.count();
	}

}

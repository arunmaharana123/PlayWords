package com.arun.word.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.domain.Tag;
import com.arun.word.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	TagRepository repository;

	public long count() {
		return repository.count();
	}

	public List<Tag> findLastestTags() {
		return repository.findLastestTags();
	}

	public Tag existsByTag(String parent) {
		return repository.existsByTag(parent);
	}

	public Tag save(Tag tag) {
		try {
			return repository.save(tag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}

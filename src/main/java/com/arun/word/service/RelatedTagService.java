package com.arun.word.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.word.domain.RelatedTag;
import com.arun.word.repository.RelatedTagRepository;

@Service
public class RelatedTagService {
	@Autowired
	RelatedTagRepository repository;

	public long count() {
		return repository.count();
	}

	public RelatedTag findRelatedTagByParentChildId(long parent, long child) {
		return repository.findRelatedTagByParentChildId(parent, child);
	}

	public boolean save(RelatedTag relatedTag) {
		try {
			repository.save(relatedTag);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<String> findRelatedTagByParentId(Long tagId) {
		return repository.findRelatedTagByParentId(tagId);
	}

}

package com.arun.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.StopWords;

@Repository
public interface StopWordRepository extends CrudRepository<StopWords, Long> {

	@Query(nativeQuery = true, value = "select stopword from stopwords where is_active=1")
	List<String> findLastestStopWord();
}
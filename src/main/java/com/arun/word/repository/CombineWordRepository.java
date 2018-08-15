package com.arun.word.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.CombineWord;

@Repository
public interface CombineWordRepository extends CrudRepository<CombineWord, Long> {

	@Query(nativeQuery = true, value = "select * from combine_word where word=:word LIMIT 1")
	public CombineWord findCombineWordByWord(@Param("word") String word);

}
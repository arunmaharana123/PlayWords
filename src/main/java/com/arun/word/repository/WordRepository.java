package com.arun.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.Word;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {

	@Query(nativeQuery = true, value = "select * from master_word where is_active=1 order by word_id desc limit 100")
	public List<Word> findLastestWords();

	@Query(nativeQuery = true, value = "select * from master_word m where m.word=:word AND m.is_active=1 limit 1")
	public Word findByWord(@Param("word") String word);
}
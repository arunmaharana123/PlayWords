package com.arun.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.Paragraph;

@Repository
public interface ParagraphRepository extends CrudRepository<Paragraph, Long> {

	@Query(nativeQuery = true, value = "select * from paragraph where is_active=1 LIMIT 100")
	public List<Paragraph> findParagraphs();

	@Query(nativeQuery = true, value = "select * from paragraph where is_active=1 AND status=0 LIMIT 1")
	public Paragraph findOneParagraphs();

	@Query(nativeQuery = true, value = "select * from paragraph where sentence=:sentence LIMIT 1")
	public Paragraph findOneParagraphBySentence(@Param("sentence") String sentence);

	@Query(nativeQuery = true, value = "select * from paragraph where is_active=1 AND status=1 LIMIT 1")
	public Paragraph findParagraphWords();

}
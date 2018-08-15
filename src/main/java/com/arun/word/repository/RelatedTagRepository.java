package com.arun.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.RelatedTag;

@Repository
public interface RelatedTagRepository extends CrudRepository<RelatedTag, Long> {

	@Query(nativeQuery = true, value = "select * from related_tag where is_active=1 AND parent_id=:parent_id AND child_id=:child_id limit 1")
	public RelatedTag findRelatedTagByParentChildId(@Param("parent_id") long parent_id,
			@Param("child_id") long child_id);

	@Query(nativeQuery = true, value = "select tag from master_tag where is_active=1 AND tag_id IN (select child_id from related_tag where is_active=1 AND parent_id=:parent_id ORDER BY repeat_times DESC)  limit 20")
	public List<String> findRelatedTagByParentId(@Param("parent_id") Long parent_id);
}
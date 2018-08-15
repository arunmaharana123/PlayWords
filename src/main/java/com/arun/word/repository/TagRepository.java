package com.arun.word.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	@Query(nativeQuery = true, value = "select * from master_tag where is_active=1 order by tag_id desc limit 100")
	public List<Tag> findLastestTags();

	@Query(nativeQuery = true, value = "select * from master_tag where is_active=1 AND tag=:tag limit 1")
	public Tag existsByTag(@Param("tag") String tag);
}
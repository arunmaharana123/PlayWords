package com.arun.word.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
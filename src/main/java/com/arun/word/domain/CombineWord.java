package com.arun.word.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "combine_word")
public class CombineWord extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "combine_word_id")
	private Long combineWordId;

	@Column(name = "word")
	private String word;

	@Column(name = "repeat_count")
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getCombineWordId() {
		return combineWordId;
	}

	public void setCombineWordId(Long combineWordId) {
		this.combineWordId = combineWordId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
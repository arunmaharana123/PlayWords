package com.arun.word.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stopwords")
public class StopWords implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stopword_id")
	private Long stopwordId;

	@Column(name = "stopword")
	private String stopword;

	@Column(name = "is_active")
	private boolean isActive;

	public Long getStopwordId() {
		return stopwordId;
	}

	public void setStopwordId(Long stopwordId) {
		this.stopwordId = stopwordId;
	}

	public String getStopword() {
		return stopword;
	}

	public void setStopword(String stopword) {
		this.stopword = stopword;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
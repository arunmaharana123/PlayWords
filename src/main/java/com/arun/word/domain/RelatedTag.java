package com.arun.word.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "related_tag")
public class RelatedTag extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "related_tag_id")
	private Long relatedTagId;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Tag parentId;

	@ManyToOne
	@JoinColumn(name = "child_id")
	private Tag childId;

	@Column(name = "repeat_times")
	private Long repeatTimes;

	public Long getRelatedTagId() {
		return relatedTagId;
	}

	public void setRelatedTagId(Long relatedTagId) {
		this.relatedTagId = relatedTagId;
	}

	public Tag getParentId() {
		return parentId;
	}

	public void setParentId(Tag parentId) {
		this.parentId = parentId;
	}

	public Tag getChildId() {
		return childId;
	}

	public void setChildId(Tag childId) {
		this.childId = childId;
	}

	public Long getRepeatTimes() {
		return repeatTimes;
	}

	public void setRepeatTimes(Long repeatTimes) {
		this.repeatTimes = repeatTimes;
	}

}
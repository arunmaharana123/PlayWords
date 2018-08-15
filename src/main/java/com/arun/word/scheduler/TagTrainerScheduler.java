package com.arun.word.scheduler;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.arun.word.constant.Constant;
import com.arun.word.domain.Paragraph;
import com.arun.word.domain.RelatedTag;
import com.arun.word.domain.Tag;
import com.arun.word.service.ParagraphService;
import com.arun.word.service.RelatedTagService;
import com.arun.word.service.TagService;

@Component
public class TagTrainerScheduler {

	@Autowired
	private ParagraphService paragraphService;

	@Autowired
	private TagService tagService;

	@Autowired
	private RelatedTagService relatedService;

	@Scheduled(fixedRate = 60000)
	public void reportCurrentTime() {
		try {
			Paragraph paragraph = paragraphService.findParagraphWords();
			if (paragraph != null && paragraph.getWords() != null && paragraph.getWords() != "") {

				paragraph.setStatus(Constant.INPROGRESS);// inprogress
				paragraphService.save(paragraph);

				String[] tags = paragraph.getWords().split(",");
				Set<String> tag_set = new HashSet<String>();
				for (String string : tags) {
					String word = string.trim();
					if (word != "") {
						tag_set.add(word);
					}

				}
				for (String parent : tag_set) {
					Tag parentTag = tagService.existsByTag(parent);
					if (parentTag == null) {
						parentTag = new Tag();
						parentTag.setActive(true);
						parentTag.setCreatedDate(new Date());
						parentTag.setCreatedTime(new Date());
						parentTag.setRepeatCount(1);
						parentTag.setTag(parent);
						parentTag = tagService.save(parentTag);
					} else {
						parentTag.setRepeatCount(parentTag.getRepeatCount() + 1);
						parentTag = tagService.save(parentTag);
					}
					for (String child : tag_set) {
						Tag childTag = tagService.existsByTag(child);
						if (childTag == null) {
							childTag = new Tag();
							childTag.setActive(true);
							childTag.setCreatedDate(new Date());
							childTag.setCreatedTime(new Date());
							childTag.setRepeatCount(1);
							childTag.setTag(child);
							childTag = tagService.save(childTag);
						} else {
							childTag.setRepeatCount(childTag.getRepeatCount() + 1);
							childTag = tagService.save(childTag);
						}
						if (!parent.equalsIgnoreCase(child)) {
							RelatedTag relatedTag = relatedService.findRelatedTagByParentChildId(parentTag.getTagId(),
									childTag.getTagId());
							if (relatedTag == null) {
								relatedTag = new RelatedTag();
								relatedTag.setActive(true);
								relatedTag.setCreatedDate(new Date());
								relatedTag.setCreatedTime(new Date());
								relatedTag.setRepeatTimes(1l);
								relatedTag.setParentId(parentTag);
								relatedTag.setChildId(childTag);
								relatedService.save(relatedTag);
							} else {
								relatedTag.setRepeatTimes(relatedTag.getRepeatTimes() + 1);
								relatedService.save(relatedTag);
							}

						}
					}
				}

				paragraph.setStatus(Constant.COMPLETED);// complete
				paragraphService.save(paragraph);
				System.out.println("Relation updated...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
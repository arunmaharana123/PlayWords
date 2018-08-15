package com.arun.word.util;

public class TextEncoding {
	public static String encoding(String text) {
		if (text != null)
			text = text.toLowerCase();
			text = text.replaceAll("&", "and");
		return text;
	}
}
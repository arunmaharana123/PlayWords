package com.arun.word.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewsApi {

	private static final String NEWSAPIKEY_AKM3791 = "82331cc1404346f2808155e5e01d0b96";

	public static List<String> getNews() {
		List<String> list = new ArrayList<String>();
		list.add("https://newsapi.org/v2/top-headlines?country=in&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=bbc-sport&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=bloomberg&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=cnbc&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=entertainment-weekly&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=espn-cric-info&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=mtv-news&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=national-geographic&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=news24&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=the-economist&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=the-hindu&apiKey=" + NEWSAPIKEY_AKM3791);
		list.add("https://newsapi.org/v2/top-headlines?sources=the-times-of-india&apiKey=" + NEWSAPIKEY_AKM3791);
		List<String> paragraphs = new ArrayList<String>();
		for (String url : list) {
			try {
				JSONObject json = readJsonFromUrl(url);
				JSONArray array = json.getJSONArray("articles");
				for (int i = 0; i < 100; i++) {
					JSONObject object = array.getJSONObject(i);
					if (object != JSONObject.NULL) {
						String line = object.getString("description");
						if (line != null && line != "") {
							paragraphs.add(line.toLowerCase());
						}
					}
				}
			} catch (Exception e) {
			}
		}
		return paragraphs;
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
}

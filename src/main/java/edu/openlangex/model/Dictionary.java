package edu.openlangex.model;

import org.springframework.data.annotation.Id;

public class Dictionary {
	
	@Id
	private String id;
	
	private String language;
	private String word;
	private String wordclass;
	private String gender;
	private String meaning;
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWordclass() {
		return wordclass;
	}
	public void setWordclass(String wordclass) {
		this.wordclass = wordclass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

}

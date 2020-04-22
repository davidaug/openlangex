package edu.openlangex.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import edu.openlangex.model.Dictionary;

public class DictionaryDTO {
	
	private String word;
	private String wordclass;
	private String gender;
	private String meaning;
	
	public DictionaryDTO() {
		
	}
	
	public DictionaryDTO(Dictionary dictionary) {
		this.word = dictionary.getWord();
		this.wordclass = dictionary.getWordclass();
		this.gender = dictionary.getGender();
		this.meaning = dictionary.getMeaning();
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
	
	public static Page<DictionaryDTO> converter(Page<Dictionary> dictionary_page){
		return dictionary_page.map(DictionaryDTO::new);
	}
	
	public static List<DictionaryDTO> converter(List<Dictionary> dictionary_list) {
		return dictionary_list.stream().map(DictionaryDTO::new).collect(Collectors.toList());
	}

}

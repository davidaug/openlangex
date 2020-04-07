package edu.openlangex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.openlangex.dto.DictionaryDTO;
import edu.openlangex.repository.DictionaryRepository;

@RestController
@RequestMapping(value="/dictionary")
public class DictionaryController {
	
	@Autowired
	DictionaryRepository dictionaryRepository;

    @GetMapping
    @Cacheable(value = "dictionary-cache")
    public Page<DictionaryDTO> getLanguageDictionary(@RequestParam(required = true) String language,
    		@PageableDefault(page=0,size = 50,sort="word",direction = Direction.ASC)
    		Pageable pageable){
    	
        return DictionaryDTO.converter(dictionaryRepository.findByLanguage(language, pageable));
    }
}

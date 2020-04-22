package edu.openlangex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.openlangex.model.Dictionary;

public interface DictionaryRepository extends MongoRepository<Dictionary,String> {
	
	public Page<Dictionary> findByLanguage(String language, Pageable pageable);
	
	@Aggregation("{ $sample: { size: 30 }}")
	public List<Dictionary> findRandomByLanguage(String language);

}

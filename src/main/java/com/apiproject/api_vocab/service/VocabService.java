package com.apiproject.api_vocab.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiproject.api_vocab.model.Vocab;
import com.apiproject.api_vocab.repository.VocabRepository;


@Service
public class VocabService {
	
	@Autowired
	VocabRepository repository;
	 
	/* ------------ 1. GETTING ALL VOCAB ---------------- */
	public List<Vocab> getAllVocab()
	{
		List<Vocab> vocabList = repository.findAll();
	    if(vocabList.size() > 0) {return vocabList;} 
	    else{return new ArrayList<Vocab>();}
	}
	
	/* ------------ 2. ADD NEW VOCAB ---------------- */
	public Vocab addVocab(Vocab inputVocab) {
		inputVocab = repository.save(inputVocab);
		return inputVocab;
	}
	
	/* ------------ 3. EDIT VOCAB ---------------- */
	public Vocab editVocab(Vocab inputVocab) {
		Optional<Vocab> vocabVar = repository.findByIdAndVocab_word(inputVocab.getId(), inputVocab.getVocab_word());
		
		if(vocabVar.isPresent())
		{
			Vocab newEntity = vocabVar.get();
			newEntity.setVocab_word(inputVocab.getVocab_word());
        	newEntity.setVocab_word_meaning(inputVocab.getVocab_word_meaning());
        	newEntity.setVocab_word_sentence(inputVocab.getVocab_word_sentence());
        	newEntity = repository.save(newEntity);
        	return newEntity;	
		}
		else
		{
			return null;
		}
	}
	
	/* ------------ 4. DELETE VOCAB ---------------- */
	public void deleteVocabByIdAndVocab_word(Integer id, String vocab_word) {
		 Optional<Vocab> vocabVal = repository.findByIdAndVocab_word(id, vocab_word);
         
	        if(vocabVal.isPresent()) 
	        {
	            repository.deleteByIdAndVocab_word(id, vocab_word);
	        } 
		
	}

}

package com.apiproject.api_vocab.controller;
import org.springframework.web.bind.annotation.RestController;

import com.apiproject.api_vocab.model.Vocab;
import com.apiproject.api_vocab.service.VocabService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/vocab")
public class VocabController {
	
	@Autowired
	VocabService vocabService;
	
	Logger log = LoggerFactory.getLogger(VocabController.class);
	
	/* ------------ 1. GETTING ALL VOCAB ---------------- */
	@RequestMapping(value = "/allvocab", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Vocab Words", notes = "Get All Vocab Words")
	@ResponseBody
    public ResponseEntity<List<Vocab>> getAllVocab() 
	{
		double requestID =  Math.floor((Math.random() * 1000)*100) / 100;
		log.info("RequestID: {} - GET ALL VOCAB REQUEST - STARTED", requestID);
		
        List<Vocab> vocabList = vocabService.getAllVocab();
        log.info("RequestID: {} - GET ALL VOCAB REQUEST - Vocab List : {}", requestID, Arrays.toString(vocabList.toArray()));
        
        log.info("RequestID: {} - GET ALL VOCAB REQUEST - COMPLETED", requestID);
 
        return new ResponseEntity<List<Vocab>>(vocabList, HttpStatus.OK);
    }
	
	/* ------------ 2. ADD NEW VOCAB ---------------- */
	@RequestMapping(value = "/addvocab", method = RequestMethod.POST)
    @ApiOperation(value = "Add new Vocab", notes = "Add new Vocab")
    @ResponseBody
	public ResponseEntity<Vocab> addVocab(
			@ApiParam(value = "Word", required = true) @RequestParam final String vocab_word,
			@ApiParam(value = "Word Meaning", required = true) @RequestParam final String vocab_word_meaning,
			@ApiParam(value = "Word Sentence", required = true) @RequestParam final String vocab_word_sentence
			)
	{
		double requestID =  Math.floor((Math.random() * 1000)*100) / 100;
		log.info("RequestID: {} - ADD NEW VOCAB REQUEST - STARTED", requestID);
		
		Vocab inputVocab = new Vocab(vocab_word, vocab_word_meaning, vocab_word_sentence);
		Vocab newVocab = vocabService.addVocab(inputVocab);
		if(newVocab!=null)
		{
			log.info("RequestID: {} - ADD NEW VOCAB REQUEST - New Vocab : {}", requestID, newVocab.toString());
		}
		
		log.info("RequestID: {} - ADD NEW VOCAB REQUEST - COMPLETED", requestID);
		return new ResponseEntity<Vocab>(newVocab, new HttpHeaders(), HttpStatus.OK);
	}
	
	/* ------------ 3. EDIT VOCAB ---------------- */
	@RequestMapping(value = "/editvocab", method = RequestMethod.POST)
    @ApiOperation(value = "Edit Vocab", notes = "Edit Vocab")
    @ResponseBody
	public ResponseEntity<Vocab> EditVocab(
			@ApiParam(value = "id", required = true) @RequestParam final Integer id,
			@ApiParam(value = "Word", required = true) @RequestParam final String vocab_word,
			@ApiParam(value = "Word Meaning", required = true) @RequestParam final String vocab_word_meaning,
			@ApiParam(value = "Word Sentence", required = true) @RequestParam final String vocab_word_sentence
			)
	{
		double requestID =  Math.floor((Math.random() * 1000)*100) / 100;
		log.info("RequestID: {} - EDIT VOCAB REQUEST - STARTED", requestID);
		
		Vocab inputVocab = new Vocab(id, vocab_word, vocab_word_meaning, vocab_word_sentence);
		Vocab editedVocab = vocabService.editVocab(inputVocab);
		if(editedVocab!=null)
		{
			log.info("RequestID: {} - EDIT VOCAB REQUEST - New Vocab : {}", requestID, editedVocab.toString());
		}
		
		log.info("RequestID: {} - EDIT VOCAB REQUEST - COMPLETED", requestID);
		return new ResponseEntity<Vocab>(editedVocab, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	/* ------------ 4. DELETE VOCAB ---------------- */
	@RequestMapping(value = "/deletevocab", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Vocab", notes = "Delete Vocab")
    @ResponseBody
	public ResponseEntity<Vocab> DeleteVocab(
			@ApiParam(value = "ID", required = true, defaultValue = "") @RequestParam final Integer id,
			@ApiParam(value = "Word", required = true, defaultValue = "") @RequestParam final String vocab_word)
	{
		double requestID =  Math.floor((Math.random() * 1000)*100) / 100;
		log.info("RequestID: {} - DELETE VOCAB REQUEST - STARTED", requestID);
		
		vocabService.deleteVocabByIdAndVocab_word(id, vocab_word);
		
		log.info("RequestID: {} - DELETE VOCAB REQUEST - COMPLETED", requestID);
        return new ResponseEntity<>(HttpStatus.OK);
	}
	

}

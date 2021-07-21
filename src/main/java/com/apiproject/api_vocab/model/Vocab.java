package com.apiproject.api_vocab.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_VOCAB")
public class Vocab {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOCAB_SEQ_ID")
    @SequenceGenerator(name = "VOCAB_SEQ_ID", sequenceName = "VOCAB_SEQ_ID", allocationSize = 1)
	private Integer id;
	 
	@Column(name="vocab_word")
	private String vocab_word;
	     
	@Column(name="vocab_word_meaning")
	private String vocab_word_meaning;
	 
	@Column(name="vocab_word_sentence")
	private String vocab_word_sentence;
	 
	public Vocab() {}

	public Vocab(Integer id, String vocab_word, String vocab_word_meaning, String vocab_word_sentence) {
		super();
		this.id = id;
		this.vocab_word = vocab_word;
		this.vocab_word_meaning = vocab_word_meaning;
		this.vocab_word_sentence = vocab_word_sentence;
	}
	
	public Vocab(String vocab_word, String vocab_word_meaning, String vocab_word_sentence) {
		super();
		this.vocab_word = vocab_word;
		this.vocab_word_meaning = vocab_word_meaning;
		this.vocab_word_sentence = vocab_word_sentence;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVocab_word() {
		return vocab_word;
	}

	public void setVocab_word(String vocab_word) {
		this.vocab_word = vocab_word;
	}

	public String getVocab_word_meaning() {
		return vocab_word_meaning;
	}

	public void setVocab_word_meaning(String vocab_word_meaning) {
		this.vocab_word_meaning = vocab_word_meaning;
	}

	public String getVocab_word_sentence() {
		return vocab_word_sentence;
	}

	public void setVocab_word_sentence(String vocab_word_sentence) {
		this.vocab_word_sentence = vocab_word_sentence;
	}

	@Override
	public String toString() {
		return "Vocab [id=" + id + ", vocab_word=" + vocab_word + ", vocab_word_meaning=" + vocab_word_meaning
				+ ", vocab_word_sentence=" + vocab_word_sentence + "]";
	}
	

}
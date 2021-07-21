package com.apiproject.api_vocab.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apiproject.api_vocab.model.Vocab;


@Repository
@Transactional
public interface VocabRepository extends JpaRepository<Vocab, Integer>{
	
	@Query(value="select * from TABLE_VOCAB a where a.id = :id and a.vocab_word = :vocab_word",nativeQuery = true)
	Optional<Vocab> findByIdAndVocab_word(Integer id, String vocab_word);
	
	@Modifying
	@Query(value = "DELETE FROM TABLE_VOCAB a WHERE a.id = :id AND a.vocab_word = :vocab_word", nativeQuery = true)
	void deleteByIdAndVocab_word(Integer id, String vocab_word);

}

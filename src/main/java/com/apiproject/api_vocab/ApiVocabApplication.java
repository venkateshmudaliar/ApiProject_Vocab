package com.apiproject.api_vocab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class ApiVocabApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVocabApplication.class, args);
	}

}

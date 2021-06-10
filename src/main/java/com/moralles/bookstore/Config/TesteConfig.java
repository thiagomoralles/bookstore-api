package com.moralles.bookstore.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.moralles.bookstore.services.DBService;

@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	DBService dbService;
	
	@Bean
	public void instanciaBaseDados() {
		this.dbService.populaBDInicial();
	}
}

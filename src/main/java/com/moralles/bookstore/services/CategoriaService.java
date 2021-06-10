package com.moralles.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moralles.bookstore.domain.Categoria;
import com.moralles.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		return categoriaRepository.findById(id).get();
	}
}

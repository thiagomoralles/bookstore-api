package com.moralles.bookstore.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moralles.bookstore.domain.Categoria;
import com.moralles.bookstore.domain.Livro;
import com.moralles.bookstore.repositories.LivroRepository;
import com.moralles.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Livro create(Livro livro, Integer id_categoria) {
		livro.setCategoria(new Categoria());
		livro.getCategoria().setId(id_categoria);
		return livroRepository.save(livro);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Livro update(Integer id, Livro livro) {
		livro.setId(id);
		return livroRepository.save(livro);
	}
	
	public void delete(Integer id) {
		livroRepository.deleteById(id);
	}

}

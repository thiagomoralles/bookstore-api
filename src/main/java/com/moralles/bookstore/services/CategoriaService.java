package com.moralles.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moralles.bookstore.domain.Categoria;
import com.moralles.bookstore.repositories.CategoriaRepository;
import com.moralles.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Categoria create(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Integer id, Categoria categoria) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		try {
			categoriaRepository.deleteById(id);;			
		} catch (DataIntegrityViolationException e) {
			throw new com.moralles.bookstore.services.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
		}
	}
}

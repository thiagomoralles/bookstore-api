package com.moralles.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moralles.bookstore.domain.Categoria;
import com.moralles.bookstore.dtos.CategoriaDTO;
import com.moralles.bookstore.services.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(categoriaService.findById(id));
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
		categoria = categoriaService.create(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Integer id, @Valid @RequestBody Categoria categoria) {
		categoria = categoriaService.update(id, categoria);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			categoriaService.delete(id);
		} catch (Exception e) {
			throw new com.moralles.bookstore.services.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
		}
		return ResponseEntity.noContent().build();
	}
}

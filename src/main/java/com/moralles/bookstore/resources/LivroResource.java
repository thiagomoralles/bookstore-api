package com.moralles.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moralles.bookstore.domain.Livro;
import com.moralles.bookstore.dtos.LivroDTO;
import com.moralles.bookstore.services.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livro")
public class LivroResource {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(livroService.findById(id));
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<LivroDTO>> findAll() {
		return ResponseEntity.ok().body(livroService.findAll().stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
	}
	
	@GetMapping(value = "/findAllByCategoria")
	public ResponseEntity<List<LivroDTO>> findAllByCategoria(@RequestParam Integer idCategoria) {
		return ResponseEntity.ok().body(livroService.findAllByCategoria(idCategoria).stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria, @Valid @RequestBody Livro livro) {
		return ResponseEntity.ok().body(livroService.create(livro, id_categoria));
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livro){
		livro = livroService.update(id, livro);
		return ResponseEntity.ok().body(livro);
	}
	
	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @Valid @RequestBody Livro livro){
		livro = livroService.update(id, livro);
		return ResponseEntity.ok().body(livro);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

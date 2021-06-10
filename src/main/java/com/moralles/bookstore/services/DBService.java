package com.moralles.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moralles.bookstore.domain.Categoria;
import com.moralles.bookstore.domain.Livro;
import com.moralles.bookstore.repositories.CategoriaRepository;
import com.moralles.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void populaBDInicial() {
		Categoria categoria = new Categoria(null, "informática", "Livros de TI", null);
		Categoria categoria2 = new Categoria(null, "biologia", "Livros de biologia", null);
		Categoria categoria3 = new Categoria(null, "história", "Livros de história", null);
		Livro livro = new Livro(null, "Java - como programar", "Deitel", "Lorem ipsum", categoria);
		Livro livro2 = new Livro(null, "Spring na prática", "Deitel", "Lorem ipsum", categoria);
		Livro livro3 = new Livro(null, "Corpo humano", "Dr. Martin", "Lorem ipsum", categoria2);
		Livro livro4 = new Livro(null, "Independência do Brasil", "Pedro A. Cabral", "Lorem ipsum", categoria3);
		categoria.setLivros(Arrays.asList(livro, livro2));
		categoria2.setLivros(Arrays.asList(livro3));
		categoria3.setLivros(Arrays.asList(livro4));
		
		categoriaRepository.saveAll(Arrays.asList(categoria, categoria2, categoria3));
		livroRepository.saveAll(Arrays.asList(livro, livro2, livro3, livro4));
	}
}

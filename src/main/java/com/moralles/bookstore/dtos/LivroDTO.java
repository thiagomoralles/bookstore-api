package com.moralles.bookstore.dtos;

import com.moralles.bookstore.domain.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
	
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getNomeAutor();
		this.texto = livro.getTexto();
	}

	
}

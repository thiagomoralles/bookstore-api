package com.moralles.bookstore.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Livros implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	private Categoria categoria;
}

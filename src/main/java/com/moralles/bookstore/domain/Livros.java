package com.moralles.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "titulo")
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
}

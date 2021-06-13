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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "O campo TITULO é obrigatório!")
	@Length(min = 5, max = 100, message = "O campo TITULO deve ter entre 3 e 100 caracteres!")
	@Column(name = "TITULO")
	private String titulo;
	
	@NotEmpty(message = "O campo NOME DO AUTOR é obrigatório!")
	@Length(min = 5, max = 100, message = "O campo NOME DO AUTOR deve ter entre 3 e 100 caracteres!")
	@Column(name = "NOME_AUTOR")
	private String nomeAutor;
	
	@NotEmpty(message = "O campo TEXTO é obrigatório!")
	@Length(min = 5, max = 1000, message = "O campo TEXTO deve ter entre 3 e 1000 caracteres!")
	@Column(name = "TEXTO")
	private String texto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
}

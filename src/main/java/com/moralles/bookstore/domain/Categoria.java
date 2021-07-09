package com.moralles.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "O campo NOME é obrigatório!")
	@Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres!")
	@Column(name = "NOME")
	private String nome;

	@NotEmpty(message = "O campo DESCRIÇÃO é obrigatório!")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres!")
	@Column(name = "DESCRICAO")
	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Livro> livros = new ArrayList<>();
}

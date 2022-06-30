package com.augusto.example.augustin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "dinheiro")
	private Integer dinheiro;

	public Conta() {
	}

	public Integer getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(Integer dinheiro) {
		this.dinheiro = dinheiro;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

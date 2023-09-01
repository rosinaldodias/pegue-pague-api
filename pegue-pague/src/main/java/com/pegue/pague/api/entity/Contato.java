package com.pegue.pague.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_contato;
	@ManyToOne 
	private Pessoa pessoa;
	private String nome;
	
	//private Telefone telefones;

}

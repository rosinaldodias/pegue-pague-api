package com.pegue.pague.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transportadora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_transpotadora;
	@OneToOne
	private Pessoa pessoa;
	private Boolean ativo;

}

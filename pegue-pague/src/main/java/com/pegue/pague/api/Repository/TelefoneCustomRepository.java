package com.pegue.pague.api.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.pegue.pague.api.entity.Telefone;

@Repository
public class TelefoneCustomRepository {

private final EntityManager em;
	
	public TelefoneCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Telefone> findAllTelefone(Long codigo){
		String query = "select * from telefone where id_pessoa = :parid";
		var q = em.createNativeQuery(query, Telefone.class); 
		q.setParameter("parid", codigo);
		return q.getResultList();
	}
	
}	
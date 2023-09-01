package com.pegue.pague.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pegue.pague.api.entity.Telefone;

public interface TelefoneRepository  extends JpaRepository<Telefone, Long> {
	
	@Query(value = "SELECT * FROM telefone  where id_pessoa = :id ", 
			  nativeQuery = true)
     List<Telefone> findByIdPessoa(@Param("id") Long id);

}

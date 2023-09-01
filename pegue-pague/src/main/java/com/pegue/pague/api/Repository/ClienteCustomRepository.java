package com.pegue.pague.api.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.pegue.pague.api.controller.dto.ClienteDto;
import com.pegue.pague.api.entity.Cliente;

@Repository
public class ClienteCustomRepository {

private final EntityManager em;
	
	public ClienteCustomRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Cliente> findByAllCliente(){
		String query = "select c.id_cliente, c.ativo, c.data_cadastro, c.informacoes_adicionais, c.limite_credido, "
				+ "p.id_pessoa, p.nome, p.cpf_cnpj, p.email  "
				+ "from cliente c join pessoa p on p.id_pessoa = c.id_pessoa";
				
		var q = em.createNativeQuery(query, Cliente.class); 
		
		return q.getResultList();
	}

	public ClienteDto findByIdCliente(Long id_cliente){
		String query = "select c.id_cliente, c.ativo, c.data_cadastro, c.informacoes_adicionais, c.limite_credido, "
				+ "p.id_pessoa, p.nome, p.cpf_cnpj, p.email  "
				+ "from cliente c join pessoa p on p.id_pessoa = c.id_pessoa where c.id_cliente = :parid";
		var q = em.createNativeQuery(query, ClienteDto.class); 
		q.setParameter("parid", id_cliente);
		return   (ClienteDto)q.getResultStream();
	}
	
	
	
//	public List<Membro> findByMembro(String nome, String profissao){
//		String query = "select p.id, p.nome, pr.nome, m.* from membro m "
//				+ "left join pessoa p on p.id = m.id_pessoa "
//				+ "left join profissao pr on pr.id = p.profissao_id";
//		String condicao = " where";
//		
//		if(nome != null) {
//			query += condicao + " TRANSLATE(p.nome,'ÁÀÂÃÄáàâãäÉÈÊËéèêëÍÌÎÏíìîïÓÒÕÔÖóòôõöÚÙÛÜúùûüÇç', \r\n"
//					+ "		             'AAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUUuuuuÇc')  ilike :nome";
//			condicao = " and";
//		}
//		 String teste = "%null%";
//		if((!profissao.equals(teste)) &&(profissao != null)) {
//			query += condicao + " TRANSLATE(pr.nome, 'ÁÀÂÃÄáàâãäÉÈÊËéèêëÍÌÎÏíìîïÓÒÕÔÖóòôõöÚÙÛÜúùûüÇç', \r\n"
//					+ "		             'AAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUUuuuuÇc')  ilike :profissao";
//		}
//		
//		var q = em.createNativeQuery(query, Membro.class); 
//		
//		if(nome != null) {
//			q.setParameter("nome", nome);
//		}
//		if((!profissao.equals(teste)) &&(profissao != null)) {
//			q.setParameter("profissao", profissao);
//		}
//		
//		return q.getResultList();
//	}
	
	
	


}	
package com.pegue.pague.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pegue.pague.api.Repository.ClienteCustomRepository;
import com.pegue.pague.api.Repository.ClienteRepository;
import com.pegue.pague.api.Repository.PessoaRepository;
import com.pegue.pague.api.Repository.TelefoneRepository;
import com.pegue.pague.api.controller.dto.ClienteDto;
import com.pegue.pague.api.entity.Cliente;
import com.pegue.pague.api.entity.Pessoa;
import com.pegue.pague.api.entity.Telefone;
import com.pegue.pague.api.service.serviceImpl.ClienteServiceImpl;
@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImpl service;
	
	
	@Autowired
	private ClienteCustomRepository repoCustomCli;
	@Autowired
	private PessoaRepository repoPessoa;
	
	@Autowired
	private ClienteRepository repoCli;
	
	@Autowired
	private TelefoneRepository repoTel;
	

	@PostMapping("/new")
	public ResponseEntity<Cliente> novo(@Valid @RequestBody ClienteDto clienteDto, 
			HttpServletResponse response ) {
		Cliente clienteSalvo = service.save(clienteDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				 .buildAndExpand(clienteSalvo.getId_cliente()).toUri();
		 response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(clienteSalvo);
		
	}
	
	
	@GetMapping
	private List<Cliente> buscaTodos(){
	   return repoCli.findAll();
//			   .stream()
//			   .map(cliente -> toClienteDtoResult(cliente) )
//			   .collect(Collectors.toList());
	}
//	private ClienteDtoResult toClienteDtoResult(Cliente cliente) {
//		ClienteDtoResult dto = new ClienteDtoResult();
//		dto.setId(cliente.getId_cliente());
//		dto.setNome(cliente.getPessoa().getNome());
//		dto.setEmail(cliente.getPessoa().getEmail());
//		dto.setCpfCnpj(cliente.getPessoa().getCpfCnpj());
//		dto.setId(cliente.getId_cliente());
//		return dto;
//		
//	}
	
	
	@PutMapping("edit/{codigo}")
	public ResponseEntity<Pessoa> editPes(@PathVariable Long codigo,  @Valid @RequestBody 
			Pessoa pes, 
			HttpServletResponse response ) {
		Pessoa pessoaSalva = service.editar(pes, codigo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				 .buildAndExpand(pessoaSalva.getId_pessoa()).toUri();
		 response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(pessoaSalva);
		
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> findById(@PathVariable Long codigo) {
		return repoCli.findById(codigo).
				map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/dto/{codigo}")
	public ClienteDto findByIdDto(@PathVariable Long codigo) {
		return repoCustomCli.findByIdCliente(codigo);
	}
	
	@GetMapping("teste")
	public List<Pessoa> buscaId(){
		return repoPessoa.findAll();
	}
	
	@GetMapping("cli")
	public List<Cliente> listaCliente(){
		return repoCli.findAll();
	}

	@GetMapping("tel")
	public List<Telefone> listTel(){
		return repoTel.findAll();
	}
	
	@GetMapping("pes")
	public List<Pessoa> lista(){
		return repoPessoa.findAll();
	}
	
}

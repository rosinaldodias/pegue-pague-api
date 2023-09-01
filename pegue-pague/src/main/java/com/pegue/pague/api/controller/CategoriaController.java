package com.pegue.pague.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pegue.pague.api.entity.Categoria;
import com.pegue.pague.api.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<Categoria> findByAll(){
		return service.findByAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = service.save(categoria);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().
		path("/{codigo}").buildAndExpand(categoriaSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString()); 
		return ResponseEntity.created(uri).body(categoriaSalva);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> findById(@PathVariable Long codigo) {
		return service.findById(codigo)
				.map(categoria -> ResponseEntity.ok(categoria))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		this.service.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> edit(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria) {
		Categoria categoriaSalva = service.edit(codigo, categoria);
		return  ResponseEntity.ok(categoriaSalva);
	
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizaAtivo (@PathVariable Long codigo, @RequestBody Boolean ativo) {
		service.atualizaPropriedadeAtivo(codigo, ativo);
	}
	
	
}

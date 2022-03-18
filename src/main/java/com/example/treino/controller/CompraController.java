package com.example.treino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.treino.entites.Compra;
import com.example.treino.repository.CompraRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/compras")
public class CompraController {

	
	@Autowired
	private CompraRepository compraRepository;
	
	@GetMapping
	public ResponseEntity<List<Compra>> findAll(){
		List<Compra> compras = compraRepository.findAll();
		return ResponseEntity.ok().body(compras);
	}
	
	// GET POR ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Compra> findById(@PathVariable Long id){
		Compra compras = compraRepository.findById(id).get();
		return ResponseEntity.ok().body(compras);
	}
	
	//CREATE
	@PostMapping
	public Compra create(@RequestBody Compra compra) {
		return compraRepository.save(compra);
	}
	
	// UPDATE
	@PutMapping("{id}")
	public ResponseEntity<Compra> update(@PathVariable long id, @RequestBody Compra compraDetails){
		Compra updateCompra = compraRepository.findById(id).get();
		updateCompra.setQuantidade(compraDetails.getQuantidade());
		compraRepository.save(updateCompra);
		return ResponseEntity.ok(updateCompra);
	}
	
	//DELETE
	public ResponseEntity<HttpStatus> delete(@PathVariable long id){
		Compra compra = compraRepository.findById(id).get();
		compraRepository.delete(compra);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

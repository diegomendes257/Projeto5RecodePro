package com.example.treino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.treino.entites.Empresa;
import com.example.treino.repository.EmpresaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping
	public ResponseEntity<List<Empresa>> findAll() {

		List<Empresa> empresas = empresaRepository.findAll();

		return ResponseEntity.ok().body(empresas);
	}

	// GET POR ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Long id) {

		Empresa empresa = empresaRepository.findById(id).get();

		return ResponseEntity.ok().body(empresa);
	}

	// CREATE
	@PostMapping
	public Empresa create(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	// UPDATE
	@PutMapping("{id}")
	public ResponseEntity<Empresa> update(@PathVariable long id, @RequestBody Empresa empresaDetails) {
		Empresa updateEmpresa = empresaRepository.findById(id).get();

		updateEmpresa.setNome_empresa(empresaDetails.getNome_empresa());
		updateEmpresa.setCnpj_empresa(empresaDetails.getCnpj_empresa());
		updateEmpresa.setPlaca_onibus(empresaDetails.getPlaca_onibus());

		empresaRepository.save(updateEmpresa);

		return ResponseEntity.ok(updateEmpresa);
	}

	// DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
		Empresa empresa = empresaRepository.findById(id).get();
		empresaRepository.delete(empresa);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
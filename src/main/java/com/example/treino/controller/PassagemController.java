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
import com.example.treino.entites.Passagem;
import com.example.treino.entites.Usuario;
import com.example.treino.repository.EmpresaRepository;
import com.example.treino.repository.PassagemRepository;
import com.example.treino.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/passagens")
public class PassagemController {

	
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	// GET POR ID
	@GetMapping
	public ResponseEntity<List<Passagem>> findAll(){
		List<Passagem> passagens = passagemRepository.findAll();
		return ResponseEntity.ok().body(passagens);
	}
	
	//CREATE
	@GetMapping(value = "/{id}")
	public ResponseEntity<Passagem> findById(@PathVariable Long id){
		Passagem passagens = passagemRepository.findById(id).get();
		return ResponseEntity.ok().body(passagens);
	}
	
	//CREATE
    @PostMapping
    public Passagem createEmployee(@RequestBody Passagem passagem) {
    	
        return passagemRepository.save(passagem);
    }
	
	//UPDATE
	@PutMapping("{id}")
	public ResponseEntity<Passagem> update(@PathVariable long id, @RequestBody Passagem passagemDetails){
		Passagem updatePassagem = passagemRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(passagemDetails.getUsuario().getId_cliente()).get();
		Empresa empresa = empresaRepository.findById(passagemDetails.getEmpresa().getId_empresa()).get();
		
		updatePassagem.setOrigem(passagemDetails.getOrigem());
		updatePassagem.setDestino(passagemDetails.getDestino());
		updatePassagem.setHora(passagemDetails.getHora());
		updatePassagem.setTarifa(passagemDetails.getTarifa());
		updatePassagem.setUsuarios(usuario);
		updatePassagem.setEmpresa(empresa);
		
		passagemRepository.save(updatePassagem);
		return ResponseEntity.ok(updatePassagem);
	}
	
	//DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable long id){
		Passagem passagem = passagemRepository.findById(id).get();
		passagemRepository.delete(passagem);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

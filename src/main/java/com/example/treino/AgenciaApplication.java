package com.example.treino;


import java.util.Arrays;
//import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

//import com.example.treino.entites.Compra;
import com.example.treino.entites.Empresa;
import com.example.treino.entites.Passagem;
import com.example.treino.entites.Usuario;
//import com.example.treino.repository.CompraRepository;
import com.example.treino.repository.EmpresaRepository;
import com.example.treino.repository.PassagemRepository;
import com.example.treino.repository.UsuarioRepository;

@SpringBootApplication
@RestController
public class AgenciaApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PassagemRepository passagemRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	//private CompraRepository compraRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
	
		//Date data1 = new Date(System.currentTimeMillis());
		
		
		//Usuario usuario2 = new Usuario(null, "Cicero Mendes", "12455637559",
		//		 "cicero@teste.com", "Rua do Mato", "Recife", "PE", "51540620", "81999690528",
		//		 200.00);
		//usuarioRepository.save(usuario2);
		 
		
		//Empresa empresa2 = new Empresa(null, "Jambur Tur", "12435648500178", "PDF1544");
		//empresaRepository.save(empresa2);
		
		
		//Passagem passagem2 = new Passagem(null, "Sergipe", "Fortaleza", "01:15h", data1, 400.0, usuario2, empresa2);
		
		//usuario2.getPassagens().addAll(Arrays.asList(passagem2));
		//empresa2.getPassagens().addAll(Arrays.asList(passagem2));
		
		//passagemRepository.save(passagem2);
	}
}
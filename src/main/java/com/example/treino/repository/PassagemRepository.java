package com.example.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.treino.entites.Passagem;

@Repository


public interface PassagemRepository extends JpaRepository<Passagem, Long>{
	
}

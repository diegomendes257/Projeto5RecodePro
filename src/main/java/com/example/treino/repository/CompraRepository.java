package com.example.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.treino.entites.Compra;

@Repository


public interface CompraRepository extends JpaRepository<Compra, Long>{
	
}

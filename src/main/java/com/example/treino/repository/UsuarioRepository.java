package com.example.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.treino.entites.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

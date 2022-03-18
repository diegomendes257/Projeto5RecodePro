package com.example.treino.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


//import java.util.ArrayList;
//import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
//import javax.persistence.OneToMany;
import javax.persistence.TemporalType;

//import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Passagem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String origem;
	private String destino;
	private String hora;
	private Double tarifa;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_viagem = new Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name = "Usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "Empresa_id")
	private Empresa empresa;


	public Passagem() {
		super();
	}
	
	
	public Passagem(Long id, String origem, String destino, String hora, Date data_viagem, Double tarifa,
			Usuario usuario, Empresa empresa) {
		super();
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.data_viagem = data_viagem;
		this.hora = hora;
		this.tarifa = tarifa;
		this.usuario = usuario;
		this.empresa = empresa;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getData_viagem() {
		return data_viagem;
	}

	public void setData_viagem(Date data_viagem) {
		this.data_viagem = data_viagem;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuarios(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

package com.example.treino.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_empresa;
	private String nome_empresa;
	private String cnpj_empresa;
	private String placa_onibus;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "empresa")
	private List<Passagem> passagens = new ArrayList<Passagem>();
	
	
	public Empresa() {
		super();
	}
	
	public Empresa(Long id_empresa, String nome_empresa, String cnpj_empresa, String placa_onibus) {
		super();
		this.id_empresa = id_empresa;
		this.nome_empresa = nome_empresa;
		this.cnpj_empresa = cnpj_empresa;
		this.placa_onibus = placa_onibus;
	}
	
	
	public List<Passagem> getPassagens() {
		return passagens;
	}
	

	public Long getId_empresa() {
		return id_empresa;
	}


	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}


	public String getNome_empresa() {
		return nome_empresa;
	}


	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}


	public String getCnpj_empresa() {
		return cnpj_empresa;
	}


	public void setCnpj_empresa(String cnpj_empresa) {
		this.cnpj_empresa = cnpj_empresa;
	}


	public String getPlaca_onibus() {
		return placa_onibus;
	}


	public void setPlaca_onibus(String placa_onibus) {
		this.placa_onibus = placa_onibus;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cnpj_empresa, id_empresa, nome_empresa, placa_onibus);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id_empresa, other.id_empresa);
	}	
	
}

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
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_cliente;
	private String Nome_cliente;
	private String Cpf_cliente;
	private String Email_cliente;
	private String Endereco_cliente;
	private String Cidade_cliente;
	private String Uf_cliente;
	private String Cep_cliente;
	private String Celular_cliente;
	private Double Saldo_cliente;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Passagem> passagens = new ArrayList<Passagem>();
	
	
	public Usuario() {
		super();
	}

	public Usuario(Long id_cliente, String nome_cliente, String cpf_cliente, String email_cliente,
			String endereco_cliente, String cidade_cliente, String uf_cliente, String cep_cliente,
			String celular_cliente, Double saldo_cliente) {
		super();
		this.Id_cliente = id_cliente;
		this.Nome_cliente = nome_cliente;
		this.Cpf_cliente = cpf_cliente;
		this.Email_cliente = email_cliente;
		this.Endereco_cliente = endereco_cliente;
		this.Cidade_cliente = cidade_cliente;
		this.Uf_cliente = uf_cliente;
		this.Cep_cliente = cep_cliente;
		this.Celular_cliente = celular_cliente;
		this.Saldo_cliente = saldo_cliente;
	}

	public Long getId_cliente() {
		return Id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		Id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return Nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		Nome_cliente = nome_cliente;
	}

	public String getCpf_cliente() {
		return Cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		Cpf_cliente = cpf_cliente;
	}

	public String getEmail_cliente() {
		return Email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		Email_cliente = email_cliente;
	}

	public String getEndereco_cliente() {
		return Endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		Endereco_cliente = endereco_cliente;
	}

	public String getCidade_cliente() {
		return Cidade_cliente;
	}

	public void setCidade_cliente(String cidade_cliente) {
		Cidade_cliente = cidade_cliente;
	}

	public String getUf_cliente() {
		return Uf_cliente;
	}

	public void setUf_cliente(String uf_cliente) {
		Uf_cliente = uf_cliente;
	}

	public String getCep_cliente() {
		return Cep_cliente;
	}

	public void setCep_cliente(String cep_cliente) {
		Cep_cliente = cep_cliente;
	}

	public String getCelular_cliente() {
		return Celular_cliente;
	}

	public void setCelular_cliente(String celular_cliente) {
		Celular_cliente = celular_cliente;
	}

	public Double getSaldo_cliente() {
		return Saldo_cliente;
	}

	public void setSaldo_cliente(Double saldo_cliente) {
		Saldo_cliente = saldo_cliente;
	}
	
	

	public List<Passagem> getPassagens() {
		return passagens;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Id_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(Id_cliente, other.Id_cliente);
	}

}

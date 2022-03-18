package com.example.treino.entites;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_compra;
	private int quantidade;
	private Date data_compra = new Date(System.currentTimeMillis());
	
	
	@ManyToOne
	@JoinColumn(name = "Usuario_id")
	private Usuario usuario;
	

	/*@ManyToOne
	@JoinColumn(name = "Passagem_id")
	private Passagem passagem;*/
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "compra")
	public List<Compra> compra = new ArrayList<Compra>();
	
	public List<Compra> getCompra() {
		return compra;
	}

	public void setCompra(List<Compra> compra) {
		this.compra = compra;
	}

	public Compra() {
		super();
	}
	
	public Compra(Long id_compra, Usuario usuario, int quantidade, Date data_compra) {
		super();
		this.id_compra = id_compra;
		this.usuario = usuario;
		this.quantidade = quantidade;
		this.data_compra = data_compra;
	}

	
	public Long getId_compra() {
		return id_compra;
	}

	public void setId_compra(Long id_compra) {
		this.id_compra = id_compra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData_compra() {
		return data_compra;
	}

	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}
	
	/*public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}*/

	@Override
	public int hashCode() {
		return Objects.hash(data_compra, usuario, id_compra, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(data_compra, other.data_compra) && usuario == other.usuario
				&& id_compra == other.id_compra && quantidade == other.quantidade;
	}
	
}

package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingrediente")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ingrediente")
	protected Integer idIngredientes;
	
	@Column(name="nome_ingrediente")
	protected String nomeIngredientes;
	
	public Integer getIdIngredientes() {
		return idIngredientes;
	}
	
	public void setIdIngredientes(Integer idIngredientes) {
		this.idIngredientes = idIngredientes;
	}
	
	public String getNomeIngredientes() {
		return nomeIngredientes;
	}
	
	public void setNomeIngredientes (String nomeIngredientes) {
		this.nomeIngredientes = nomeIngredientes;
	}

}

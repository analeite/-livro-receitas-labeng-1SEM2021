package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medida")
public class Medida {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medida")
	protected Integer idMedidas;
	
	@Column(name="nome_medida")
	protected String nomeMedidas;
	
	public Integer getIdMedidas() {
		return idMedidas;
	}
	
	public void setIdMedidas(Integer idMedidas) {
		this.idMedidas = idMedidas;
	}
	
	public String getNomeMedidas() {
		return nomeMedidas;
	}
	
	public void setNomeMedidas (String nomeMedidas) {
		this.nomeMedidas = nomeMedidas;
	}

}

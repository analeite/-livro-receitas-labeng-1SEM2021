package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="receita")
@Entity
public class Receita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_receita")
	private Integer idReceitas;
	
	@Column(name="nome_receita")
	private String nomeReceitas;
	
	@Column(name="descricao")
	private String desc;
	
	@Column(name="modo_preparo")
	private String modoPreparo;

	public Integer getIdReceitas() {
		return idReceitas;
	}
	
	public void setIdReceitas(Integer idReceitas) {
		this.idReceitas = idReceitas;
	}
	
	public String getNomeReceitas() {
		return nomeReceitas;
	}
	
	public void setNomeReceitas(String nomeReceitas) {
		this.nomeReceitas = nomeReceitas;
	}
	
	public String getDescricao() {
		return desc;
	}
	
	public void setDescricao(String desc) {
		this.desc = desc;
	}
	
	public String getModoPreparo() {
		return modoPreparo;
	}
	
	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

}

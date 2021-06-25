package main.java.model;

import javax.persistence.*;

import main.java.model.Receita;

import main.java.model.Ingrediente;
import main.java.model.ReceitaCompletaIngrediente;

import java.util.List;

@Entity
@Table(name="receitacompleta")
public class ReceitaCompleta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_receitacompleta")
	private Integer idReceitaCompleta;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(name = "idrec")
	private Receita receita;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "receitaCompleta",
						cascade =  {CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
	private List<ReceitaCompletaIngrediente> receitaCompletaIngrediente;
	
	public Integer getIdReceitaCompleta() {
		return idReceitaCompleta;
	}
	
	public void setIdReceitaCompleta(Integer idReceitaCompleta) {
		this.idReceitaCompleta = idReceitaCompleta;
	}
	
	public Receita getReceita() {
		return receita;
	}
	
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

		public List<ReceitaCompletaIngrediente> getReceitaCompletaIngrediente() {
				return receitaCompletaIngrediente;
		}

		public void setReceitaCompletaIngrediente(List<ReceitaCompletaIngrediente> receitaCompletaIngrediente) {
				this.receitaCompletaIngrediente = receitaCompletaIngrediente;
		}

}

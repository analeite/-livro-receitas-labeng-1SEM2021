package main.java.model;

import javax.persistence.*;

import main.java.model.Ingrediente;

@Entity
@Table(name="receitacompleta_ingrediente")
public class ReceitaCompletaIngrediente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_receitacompleta")
	private Integer idReceitaCompletaIngrediente;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_receita_completa")
	private ReceitaCompleta receitaCompleta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ingrediente")
	private Ingrediente idIngrediente;
	
	@Column(name="quantidade")
	private String quantidade;

		public Integer getIdReceitaCompletaIngrediente() {
				return idReceitaCompletaIngrediente;
		}

		public void setIdReceitaCompletaIngrediente(Integer idReceitaCompletaIngrediente) {
				this.idReceitaCompletaIngrediente = idReceitaCompletaIngrediente;
		}

		public ReceitaCompleta getReceitaCompleta() {
		return receitaCompleta;
	}

	public void setReceitaCompleta(ReceitaCompleta receitaCompleta) {
		this.receitaCompleta = receitaCompleta;
	}

	public Ingrediente getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Ingrediente idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	

}

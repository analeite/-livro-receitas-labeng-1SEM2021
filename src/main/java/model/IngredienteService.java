package main.java.model;

import java.util.List;

public interface IngredienteService {
	
	public Ingrediente insert(String nomeIngrediente);
	
	public Ingrediente findById(Integer id);
	
	public List<Ingrediente> findByNome(String nome);
	
	public List<Ingrediente> findAll();
	
	public Ingrediente update (Ingrediente ingredienteNovo);
	
	public String delete (Ingrediente ingrediente);

}

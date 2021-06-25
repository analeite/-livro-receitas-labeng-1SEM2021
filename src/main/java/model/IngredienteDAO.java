package main.java.model;

import java.util.List;

public interface IngredienteDAO {
	
	public Ingrediente insert(Ingrediente ingrediente);
	
	public Ingrediente findById(Integer id);
	
	public List <Ingrediente> findByNome(String nome);
	
	public List<Ingrediente> findAll();
	
	public Ingrediente update(Ingrediente ingrediente);
	
	public String delete (Ingrediente ingrediente);
	
}

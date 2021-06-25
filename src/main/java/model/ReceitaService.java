package main.java.model;

import java.util.List;

public interface ReceitaService {
	
	public Receita insert(String nomeReceita, String desc, String modoPreparo);
	
	public Receita findById(Integer id);
	
	public List<Receita> findByNome(String nome);
	
	public List<Receita> findAll();
	
	public Receita update (Receita receitaNova);
	
	public String delete (Receita receita);

}

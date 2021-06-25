package main.java.model;

import java.util.List;

public interface ReceitaDAO {
	
	public Receita insert(Receita receita);
	
	public Receita findById(Integer id);
	
	public List <Receita> findByNome(String nome);
	
	public List<Receita> findAll();
	
	public Receita update(Receita receitaNova);
	
	public String delete (Receita receita);

}

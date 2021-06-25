package main.java.model;

import java.util.List;

import main.java.model.ReceitaCompleta;

public interface ReceitaCompletaDAO {
	
	public ReceitaCompleta insert(ReceitaCompleta receitaCompleta);
	
	public ReceitaCompleta findById(Integer id);
	
	public List <ReceitaCompleta> findByNome(String nome);
	
	public List<ReceitaCompleta> findAll();
	
	public ReceitaCompleta update(ReceitaCompleta receitaCompletaNova);
	
	public String delete (ReceitaCompleta receitaCompleta);


}

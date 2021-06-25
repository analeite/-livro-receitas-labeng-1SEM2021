package main.java.model;

import java.util.List;

public interface MedidaService {

	public Medida insert(String nomeMedida);
	
	public Medida findById(Integer id);
	
	public List<Medida> findAll();
	
	public List<Medida> findByNome(String nome);
	
	public Medida update (Medida medidaNova);
	
	public String delete (Medida medida);
	
}

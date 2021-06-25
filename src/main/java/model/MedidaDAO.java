package main.java.model;

import java.util.List;

public interface MedidaDAO {
	
	public Medida insert(Medida medida);
	
	public Medida findById(Integer id);
	
	public List<Medida> findByNome(String nome);
	
	public List<Medida> findAll();
	
	public Medida update(Medida medida);
	
	public String delete (Medida medida);

}

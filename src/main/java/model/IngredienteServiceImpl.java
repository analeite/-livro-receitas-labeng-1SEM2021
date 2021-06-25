package main.java.model;

import java.util.List;

public class IngredienteServiceImpl implements IngredienteService {

	@Override
	public Ingrediente insert(String nomeIngredientes) {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNomeIngredientes(nomeIngredientes);
		
		IngredienteDAO iDAO = new IngredienteDAOImpl();
		
		iDAO.insert(ingrediente);
		
		return ingrediente;
	}

	@Override
	public Ingrediente findById(Integer id) {
		IngredienteDAO iDAO = new IngredienteDAOImpl();
		Ingrediente ingrediente = iDAO.findById(id);
		return ingrediente;
	}
	
	@Override
	public List <Ingrediente> findByNome(String nome) {
		IngredienteDAO iDAO = new IngredienteDAOImpl();
		List<Ingrediente> itens = iDAO.findByNome(nome);
		return itens;
	}

	@Override
	public List<Ingrediente> findAll() {
		IngredienteDAO iDAO = new IngredienteDAOImpl();
		List<Ingrediente> itens = iDAO.findAll();
		return itens;
	}

	@Override
	public Ingrediente update(Ingrediente ingredienteNovo) {
		IngredienteDAO iDAO = new IngredienteDAOImpl();
		Ingrediente ingrediente = iDAO.update(ingredienteNovo);
		return ingrediente;
	}

	@Override
	public String delete(Ingrediente ingrediente) {
		IngredienteDAO iDAO = new IngredienteDAOImpl();
		String msg = iDAO.delete(ingrediente);
		return msg;
	}

}

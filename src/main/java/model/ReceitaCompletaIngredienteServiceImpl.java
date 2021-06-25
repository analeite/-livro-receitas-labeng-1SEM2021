package main.java.model;

public class ReceitaCompletaIngredienteServiceImpl implements ReceitaCompletaIngredienteService{

	@Override
	public ReceitaCompletaIngrediente insert(ReceitaCompletaIngrediente receitaCompletaIngrediente) {		
		ReceitaCompletaIngredienteDAO iDAO = new ReceitaCompletaIngredienteDAOImpl();

		return iDAO.insert(receitaCompletaIngrediente);
	}

	public ReceitaCompletaIngrediente update(ReceitaCompletaIngrediente receitaCompletaIngrediente) {
			ReceitaCompletaIngredienteDAO iDAO = new ReceitaCompletaIngredienteDAOImpl();

			return iDAO.update(receitaCompletaIngrediente);
	}

}

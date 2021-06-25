package main.java.model;

import java.util.List;

public class ReceitaCompletaServiceImpl implements ReceitaCompletaService{

	@Override
	public ReceitaCompleta insert(ReceitaCompleta receitaCompleta) {		
		ReceitaCompletaDAO iDAO = new ReceitaCompletaDAOImpl();
		
		iDAO.insert(receitaCompleta);
		
		return receitaCompleta;
	}

	@Override
	public ReceitaCompleta findById(Integer id) {
			ReceitaCompletaDAOImpl iDAO = new ReceitaCompletaDAOImpl();
			ReceitaCompleta receitaCompleta = iDAO.findById(id);
			return receitaCompleta;
	}

	@Override
	public List <ReceitaCompleta> findByNome(String nome) {
		ReceitaCompletaDAO iDAO = new ReceitaCompletaDAOImpl();
		List<ReceitaCompleta> itens = iDAO.findByNome(nome);
		return itens;
	}

	@Override
	public List<ReceitaCompleta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceitaCompleta update(ReceitaCompleta receitaCompletaNova) {
		ReceitaCompletaDAO iDAO = new ReceitaCompletaDAOImpl();
		ReceitaCompleta receitaCompleta = iDAO.update(receitaCompletaNova);
		return receitaCompleta;
	}

	@Override
	public String delete(ReceitaCompleta receitaCompleta) {
			ReceitaCompletaDAOImpl iDAO = new ReceitaCompletaDAOImpl();
			String msg = iDAO.delete(receitaCompleta);
			return msg;
	}

}

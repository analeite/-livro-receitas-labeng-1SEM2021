package main.java.model;

import java.util.List;

public class ReceitaServiceImpl implements ReceitaService{

	@Override
	public Receita insert(String nomeReceita, String desc, String modoPreparo) {
		Receita receita = new Receita();
		receita.setNomeReceitas(nomeReceita);
		receita.setDescricao(desc);
		receita.setModoPreparo(modoPreparo);
		
		ReceitaDAO iDAO = new ReceitaDAOImpl();
		
		return iDAO.insert(receita);
	}

	@Override
	public Receita findById(Integer id) {
		ReceitaDAO iDAO = new ReceitaDAOImpl();
		Receita receita = iDAO.findById(id);
		return receita;
	}

	@Override
	public List<Receita> findAll() {
		ReceitaDAO iDAO = new ReceitaDAOImpl();
		List<Receita> itens = iDAO.findAll();
		return itens;
	}

	@Override
	public Receita update(Receita receitaNova) {
		ReceitaDAO iDAO = new ReceitaDAOImpl();
		Receita receita = iDAO.update(receitaNova);
		return receita;
	}

	@Override
	public String delete(Receita receita) {
		ReceitaDAO iDAO = new ReceitaDAOImpl();
		String msg = iDAO.delete(receita);
		return msg;
	}

	@Override
	public List <Receita> findByNome(String nome) {
		ReceitaDAO iDAO = new ReceitaDAOImpl();
		List<Receita> itens = iDAO.findByNome(nome);
		return itens;
	}

}

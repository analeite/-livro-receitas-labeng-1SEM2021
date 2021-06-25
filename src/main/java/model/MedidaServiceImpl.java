package main.java.model;

import java.util.List;

public class MedidaServiceImpl implements MedidaService{

	@Override
	public Medida insert(String nomeMedida) {
		Medida medida = new Medida();
		medida.setNomeMedidas(nomeMedida);
		
		MedidaDAO iDAO = new MedidaDAOImpl();
		
		iDAO.insert(medida);
		
		return medida;
	}

	@Override
	public Medida findById(Integer id) {
		MedidaDAO iDAO = new MedidaDAOImpl();
		Medida medida = iDAO.findById(id);
		return medida;
	}
	
	@Override
	public List <Medida> findByNome(String nome) {
		MedidaDAO iDAO = new MedidaDAOImpl();
		List<Medida> itens = iDAO.findByNome(nome);
		return itens;
	}

	@Override
	public List<Medida> findAll() {
		MedidaDAO iDAO = new MedidaDAOImpl();
		List<Medida> itens = iDAO.findAll();
		return itens;
	}

	@Override
	public Medida update(Medida medidaNova) {
		MedidaDAO iDAO = new MedidaDAOImpl();
		Medida medida = iDAO.update(medidaNova);
		return medida;
	}

	@Override
	public String delete(Medida medida) {
		MedidaDAO iDAO = new MedidaDAOImpl();
		String msg = iDAO.delete(medida);
		return msg;
	}

}

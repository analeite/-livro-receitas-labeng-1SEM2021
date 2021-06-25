package main.java.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceitaCompletaIngredienteDAOImpl implements ReceitaCompletaIngredienteDAO{

	@Override
	public ReceitaCompletaIngrediente insert(ReceitaCompletaIngrediente receitaCompletaIngrediente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(receitaCompletaIngrediente);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return receitaCompletaIngrediente;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReceitaCompletaIngrediente update(ReceitaCompletaIngrediente receitaCompletaIngrediente) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
			EntityManager em= emf.createEntityManager();

			try {

					main.java.model.ReceitaCompletaIngrediente
							receitaAntiga = em.find(main.java.model.ReceitaCompletaIngrediente.class, receitaCompletaIngrediente.getIdReceitaCompletaIngrediente());

					em.getTransaction().begin();

					receitaAntiga.setQuantidade(receitaCompletaIngrediente.getQuantidade());

					em.getTransaction().commit();

					em.close();
					emf.close();

					return receitaCompletaIngrediente;
			} catch(Exception e) {
					e.printStackTrace();
			}

			return null;
	}

}

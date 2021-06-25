package main.java.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import main.java.model.ReceitaCompleta;
import main.java.model.ReceitaCompletaDAO;
import main.java.model.Receita;

public class ReceitaCompletaDAOImpl implements ReceitaCompletaDAO {

	@Override
	public ReceitaCompleta insert(ReceitaCompleta receitaCompleta) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(receitaCompleta);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return receitaCompleta;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReceitaCompleta findById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em= emf.createEntityManager();
		
		try {
			Query query = em.createQuery("SELECT r FROM ReceitaCompleta r join fetch r.receita re where r.idReceitaCompleta = :id ORDER BY re.nomeReceitas");
			query.setParameter("id", id);

			ReceitaCompleta receitaCompleta = (ReceitaCompleta) query.getSingleResult();
			
			em.close();
			emf.close();

			return receitaCompleta;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<ReceitaCompleta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceitaCompleta update(ReceitaCompleta receitaCompletaNova) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em= emf.createEntityManager();
		
		try {
			
			ReceitaCompleta receitaAntiga = em.find(ReceitaCompleta.class, receitaCompletaNova.getIdReceitaCompleta());
			
			em.getTransaction().begin();
			
			receitaAntiga.getReceita().setNomeReceitas(receitaCompletaNova.getReceita().getNomeReceitas());
			receitaAntiga.getReceita().setDescricao(receitaCompletaNova.getReceita().getDescricao());
			receitaAntiga.getReceita().setModoPreparo(receitaCompletaNova.getReceita().getModoPreparo());
			receitaAntiga.setReceitaCompletaIngrediente(receitaCompletaNova.getReceitaCompletaIngrediente());
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return receitaCompletaNova;
		} catch(Exception e) {
			e.printStackTrace();
		} return null;
	}

	@Override
	public String delete(ReceitaCompleta receitaCompleta) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
			EntityManager em= emf.createEntityManager();

			try {
					ReceitaCompleta receitaADeletar = em.find(ReceitaCompleta.class, receitaCompleta.getIdReceitaCompleta());
					em.getTransaction().begin();
					em.remove(receitaADeletar);
					em.getTransaction().commit();

					em.close();
					emf.close();

					return "Removido";
			} catch (Exception e) {
					e.printStackTrace();
			} return "";
	}

	@Override
	public List<ReceitaCompleta> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select rc from ReceitaCompleta rc join fetch rc.receita re where re.nomeReceitas like concat(concat('%', :nome), '%')");
			
			query.setParameter("nome", nome);

			List <ReceitaCompleta> receitaCompleta = query.getResultList();

			em.close();
			emf.close();

			return receitaCompleta;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

package main.java.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReceitaDAOImpl implements ReceitaDAO{

	@Override
	public Receita insert(Receita receita) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(receita);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return receita;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Receita findById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select r from Receita r where idReceitas = :id");
			
			query.setParameter("id", id);

			Receita receita = (Receita) query.getSingleResult();

			em.close();
			emf.close();

			return receita;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Receita> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select r from Receita r order by r.nomeReceitas");

			List<Receita> receita = query.getResultList();

			em.close();
			emf.close();
			
			return receita;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Receita update(Receita receitaNova) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em= emf.createEntityManager();
		
		try {
			Receita receitaAntiga = em.find(Receita.class, receitaNova.getIdReceitas());
			
			em.getTransaction().begin();
			
			receitaAntiga.setNomeReceitas(receitaNova.getNomeReceitas());
			receitaAntiga.setDescricao(receitaNova.getDescricao());
			receitaAntiga.setModoPreparo(receitaNova.getModoPreparo());
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return receitaAntiga;
		} catch(Exception e) {
			e.printStackTrace();
		} return null;
	}

	@Override
	public String delete(Receita receita) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em= emf.createEntityManager();
		
		try {
			Receita receitaADeletar = em.find(Receita.class, receita.getIdReceitas());
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
	public List<Receita> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select r from Receita r where nomeReceitas like concat(concat('%', :nome), '%')");
			
			query.setParameter("nome", nome);

			List <Receita> receita = query.getResultList();

			em.close();
			emf.close();

			return receita;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

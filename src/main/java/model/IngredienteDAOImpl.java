package main.java.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class IngredienteDAOImpl implements IngredienteDAO {

	@Override
	public Ingrediente insert(Ingrediente ingrediente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(ingrediente);
			em.getTransaction().commit();

			em.close();
			emf.close();

			return ingrediente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ingrediente findById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select i from Ingrediente i where idIngredientes = :id");
			
			query.setParameter("id", id);

			Ingrediente ingrediente = (Ingrediente) query.getSingleResult();

			em.close();
			emf.close();

			return ingrediente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Ingrediente> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select i from Ingrediente i where nomeIngredientes like concat(concat('%', :nome), '%')");
			
			query.setParameter("nome", nome);

			List <Ingrediente> ingrediente = query.getResultList();

			em.close();
			emf.close();

			return ingrediente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ingrediente> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select i from Ingrediente i order by i.nomeIngredientes");

			List<Ingrediente> ingrediente = query.getResultList();

			em.close();
			emf.close();
			
			return ingrediente;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Ingrediente update(Ingrediente ingredienteNovo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Ingrediente ingredienteAntigo = em.find(Ingrediente.class, ingredienteNovo.getIdIngredientes());

			em.getTransaction().begin();

			ingredienteAntigo.setNomeIngredientes(ingredienteNovo.getNomeIngredientes());

			em.getTransaction().commit();

			em.close();
			emf.close();

			return ingredienteAntigo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Ingrediente ingrediente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Ingrediente ingredienteADeletar = em.find(Ingrediente.class, ingrediente.getIdIngredientes());
			em.getTransaction().begin();
			em.remove(ingredienteADeletar);
			em.getTransaction().commit();

			em.close();
			emf.close();

			return "Removido";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}

package main.java.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MedidaDAOImpl implements MedidaDAO {

	@Override
	public Medida insert(Medida medida) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(medida);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return medida;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Medida findById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select m from Medida m where idMedidas = :id");
			
			query.setParameter("id", id);

			Medida medida = (Medida) query.getSingleResult();

			em.close();
			emf.close();

			return medida;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Medida> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select m from Medida m order by m.nomeMedidas");

			List<Medida> medida = query.getResultList();

			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Medida> findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("select m from Medida m where nomeMedidas like concat(concat('%', :nome), '%')");
			
			query.setParameter("nome", nome);

			List <Medida> medida = query.getResultList();

			em.close();
			emf.close();

			return medida;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Medida update(Medida medidaNova) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em= emf.createEntityManager();
		
		try {
			Medida medidaAntiga = em.find(Medida.class, medidaNova.getIdMedidas());
			
			em.getTransaction().begin();
			
			medidaAntiga.setNomeMedidas(medidaNova.getNomeMedidas());
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return medidaAntiga;
		} catch(Exception e) {
			e.printStackTrace();
		} return null;
	}

	@Override
	public String delete(Medida medida) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");
		EntityManager em= emf.createEntityManager();
		
		try {
			Medida medidaADeletar = em.find(Medida.class, medida.getIdMedidas());
			em.getTransaction().begin();
			em.remove(medidaADeletar);
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			return "Removido";
		} catch (Exception e) {
			e.printStackTrace();
		} return "";
	}

}

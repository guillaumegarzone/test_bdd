package testbdd1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import testbdd1.model.Personne;

public class PersonneDAO {
	protected EntityManagerFactory emf;
	protected EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	private void open() {
		if (em == null) {
			em = EMF.getEm();
			em.getTransaction().begin();
		}
	}

	private void close() {
		if (em != null)
			em.close();
		em = null;
	}

	public PersonneDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void updateObj(Personne objRef, Personne objToUpdate) {
		objToUpdate.setNom(objRef.getNom());
		objToUpdate.setPrenom(objRef.getPrenom());
		objToUpdate.setAdresse(objRef.getAdresse());
		objToUpdate.setProjets(objRef.getProjets());
		// TODO missing fields
	}

	public boolean create(Personne obj) {
		Boolean res = false;
		try {
			open();
			em.persist(obj);
			em.getTransaction().commit();
			res = true;
		} finally {
			close();
		}
		return res;
	}

	public boolean lazyCreate(Personne obj) {
		Boolean res = false;
		open();
		em.persist(obj);
		// em.getTransaction().commit();
		res = true;
		return res;
	}

	public Personne find(int id) {
		Personne result = null;
		try {
			open();
			result = em.find(Personne.class, id);
		} finally {
			close();
		}
		return result;
	}

	public boolean delete(Personne obj) {
		Boolean res = false;
		try {
			open();
			Personne toDelete = em.find(Personne.class, obj.getId());
			em.remove(toDelete);
			em.getTransaction().commit();
			res = true;
		} finally {
			close();
		}
		return res;
	}

	public boolean update(Personne obj) {
		Boolean res = false;
		try {
			open();
			Personne objToUpdate = em.find(Personne.class, obj.getId());
			updateObj(obj, objToUpdate);
			em.getTransaction().commit();
			res = true;
		} finally {
			close();
		}
		return res;
	}

}

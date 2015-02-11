package testbdd1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class DAOJpa<T> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public DAOJpa(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private void open() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		em.getTransaction().begin();
	}

	private void close() {
		if (em != null)
			em.close();
		em = null;
	}

	protected abstract T findObj(Object id);

	protected abstract Object getIdObj(T obj);

	protected abstract void updateObj(T objRef, T objToUpdate);

	public boolean create(T obj) {
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

	public T find(Object id) {
		T result = null;
		try {
			open();
			result = findObj(id);
		} finally {
			close();
		}
		return result;
	}

	public boolean delete(T obj) {
		Boolean res = false;
		try {
			open();
			T toDelete = findObj(getIdObj(obj));
			em.remove(toDelete);
			em.getTransaction().commit();
			res = true;
		} finally {
			close();
		}
		return res;
	}

	public boolean update(T obj) {
		Boolean res = false;
		try {
			open();
			T objToUpdate = findObj(getIdObj(obj));
			updateObj(obj, objToUpdate);
			em.getTransaction().commit();
			res = true;
		} finally {
			close();
		}
		return res;
	}

}

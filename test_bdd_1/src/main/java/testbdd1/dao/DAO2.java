package testbdd1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class DAO2<T, I> {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected Class<T> clazz;

	public EntityManager getEm() {
		return em;
	}

	public DAO2(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void beginTransaction() {
		if (em == null) {
			em = DB.getEm();
			em.getTransaction().begin();
		}
	}

	public void endTransaction() {
		if (em != null) {
			em.getTransaction().commit();
			em.close();
		}
		em = null;
	}

	public void close() {
		if (em != null) {
			em.close();
		}
		em = null;
	}

	protected abstract void updateObj(T objRef, T objToUpdate);

	protected abstract T findObject(T obj);

	public boolean create(T obj) {
		Boolean res = false;
		try {
			beginTransaction();
			em.persist(obj);
			// em.getTransaction().commit();
			res = true;
		} finally {
			// close();
			endTransaction();
		}
		return res;
	}

	public boolean lazyCreate(T obj) {
		Boolean res = false;
		beginTransaction();
		em.persist(obj);
		// em.getTransaction().commit();
		res = true;
		// close();
		return res;
	}

	public T find(I id) {
		T result = null;
		try {
			beginTransaction();
			// em.getTransaction().commit();
			result = em.find(clazz, id);
		} finally {
			// close();
			// endTransaction();
		}
		return result;
	}

	public boolean delete(T obj) {
		Boolean res = false;
		try {
			beginTransaction();
			T toDelete = findObject(obj);
			em.remove(toDelete);
			// em.getTransaction().commit();
			res = true;
		} finally {
			// close();
			endTransaction();
		}
		return res;
	}

	public boolean update(T obj) {
		Boolean res = false;
		try {
			beginTransaction();
			T objToUpdate = findObject(obj);
			updateObj(obj, objToUpdate);
			em.flush();
			res = true;
		} finally {
			// close();
			endTransaction();
		}
		return res;
	}

	public void commit() {

	}

}

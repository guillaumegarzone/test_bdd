package testbdd1.dao;

import javax.persistence.EntityManager;

public abstract class DAOjpa<T, I> {

	protected EntityManager em;
	protected Class<T> clazz;
	private Object mutex;

	public DAOjpa(Class<T> clazz) {
		this.clazz = clazz;
		mutex = new Object();
	}

	private void open() {
		if (em == null) {
			em = EMF.getEm();
			em.getTransaction().begin();
		}
	}

	private void close() {
		if (em != null) {
			em.close();
			em = null;
		}
	}

	// public void commit() {
	// synchronized (mutex) {
	// if (em != null) {
	// em.getTransaction().commit();
	// close();
	// }
	// }
	// }

	public boolean create(T obj) {
		synchronized (mutex) {
			open();
			em.persist(obj);
		}
		commit();
		return true;
	}

	public boolean lazyCreate(T obj) {
		synchronized (mutex) {
			open();
			em.persist(obj);
		}
		return true;
	}

	public boolean delete(T obj) {
		boolean res = false;
		synchronized (mutex) {
			open();
			T toDelete = em.find(clazz, getObjId(obj));
			if (toDelete != null) {
				em.remove(toDelete);
				res = true;
			}
		}
		return res;
	}

	public boolean update(T obj) {
		boolean res = false;
		synchronized (mutex) {
			open();
			T toUpdate = em.find(clazz, getObjId(obj));
			if (toUpdate != null) {
				updateObj(toUpdate, obj);
				em.flush();
				res = true;
			}
		}
		return res;
	}

	public T find(I id) {
		T res = null;
		synchronized (mutex) {
			open();
			res = em.find(clazz, id);
		}
		// commit();
		return res;
	}

	public void commit() {
		new Thread() {
			@Override
			public void run() {
				synchronized (mutex) {
					if (em != null) {
						em.getTransaction().commit();
						close();
					}
				}
			}
		}.start();
	}

	protected abstract void updateObj(T toUpdate, T ref);

	protected abstract I getObjId(T obj);
}

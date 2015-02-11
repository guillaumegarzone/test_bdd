package testbdd1.dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public abstract class DAO<T, I> {

	protected Dao<T, I> objectDao;

	protected boolean create(T obj) {
		boolean result = false;
		try {
			result = (objectDao.create(obj) == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected boolean delete(T obj) {
		boolean result = false;
		try {
			result = (objectDao.delete(obj) == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected boolean update(T obj) {
		boolean result = false;
		try {
			result = (objectDao.update(obj) == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	protected T find(I id) {
		T result = null;
		try {
			result = objectDao.queryForId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public DAO(ConnectionSource conn, Class<T> clazz) throws SQLException {
		objectDao = DaoManager.createDao(conn, clazz);
	}

}

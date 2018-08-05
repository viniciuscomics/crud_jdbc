package br.com.system_rh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.system_rh.dao.configBD.ConnectionFactory;

public abstract class AbstractRepository<T> implements RepositoryEntity<T> {

	private final String selectAll = "select * from ";

	abstract String getTableName();

	abstract String getIdColumnName();

	public abstract T persistResultSet(ResultSet rs);

	private ConnectionFactory connectionFactory;
	private Connection connection = null;

	public AbstractRepository(ConnectionFactory connection) {
		this.connectionFactory = connection;
	}

	private PreparedStatement execQuery(String query_sql) {
		try {
			connection = connectionFactory.getConnection();
			return connection.prepareStatement(query_sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	protected List<T> executeQuery(String query_sql) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = execQuery(query_sql);
			rs = ps.executeQuery();
			return iteratorResultSet(rs);

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			closeResultSet(rs, ps);
			closeConnection(connection);
		}

	}

	public T findToId(Integer id) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = execQuery(selectAll + getTableName() + " where " + getIdColumnName() + " = " + id);
			rs = ps.executeQuery();
			rs.next();
			return persistResultSet(rs);
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		} finally {

			closeResultSet(rs, ps);
			closeConnection(connection);
		}
	}

	public List<T> findAll() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = execQuery(selectAll + getTableName());
			rs = ps.executeQuery();
			return iteratorResultSet(rs);
			
		} catch (SQLException | NullPointerException e) {
			throw new RuntimeException(e);
		} finally {
			closeResultSet(rs, ps);
			closeConnection(connection);
		}
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}

	private List<T> iteratorResultSet(ResultSet rs) throws SQLException {
		List<T> listEntity = new ArrayList<>();
		while (rs.next()) {
			listEntity.add(persistResultSet(rs));
		}

		return listEntity == null ? new ArrayList<>() : listEntity;
	}

	private void closeResultSet(ResultSet rs, PreparedStatement ps) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

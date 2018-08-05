package br.com.system_rh.dao.configBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {
	
	
	public abstract String getDriverName();

	public abstract String getUrl();

	public abstract String getUsuario();

	public abstract String getSenha();

	public Connection getConnection() {		
		
		try {
			return DriverManager.getConnection(getUrl(),getUsuario(), getSenha());

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

package br.com.system_rh.dao.configBD;

public class ConnectMySQL extends ConnectionFactory{
	
	private String usuario = "root";
	private String senha = "123456";
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/system_rh?useTimezone=true&serverTimezone=UTC";
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
	
}


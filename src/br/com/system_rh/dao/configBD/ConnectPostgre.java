package br.com.system_rh.dao.configBD;

public class ConnectPostgre extends ConnectionFactory{
	
	private String usuario = "postgres";
	private String senha = "251011";
	private String driverName = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://127.0.0.1:5234/system_rh";
	
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

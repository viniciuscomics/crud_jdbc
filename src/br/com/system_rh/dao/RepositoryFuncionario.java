package br.com.system_rh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.system_rh.dao.configBD.ConnectionFactory;
import br.com.system_rh.model.Funcionario;

public class RepositoryFuncionario extends AbstractRepository<Funcionario> {

	public RepositoryFuncionario(ConnectionFactory connection) {
		super(connection);
	}
	
	@Override
	String getTableName() {
		return "funcionario";
	}

	@Override
	public Funcionario persistResultSet(ResultSet rs) {
		Funcionario funcionario = new Funcionario();
		try {
			funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
			funcionario.setNmcliente(rs.getString("nm_cliente"));
			funcionario.setVlSalarioBruto(rs.getBigDecimal("vl_salario_bruto"));
			return funcionario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	String getIdColumnName() {
		return "id_funcionario";
	}

}

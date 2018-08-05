package br.com.system_rh.dao;

import java.sql.ResultSet;
import java.util.List;

import br.com.system_rh.dao.configBD.ConnectionFactory;
import br.com.system_rh.model.Desconto;

public class RepositoryDesconto extends AbstractRepository<Desconto> {
	
	private final String namedQuery = "select * from descontos d inner join funcionario f on d.id_funcionario = f.id_funcionario";
	
	private RepositoryFuncionario entityFuncionario;

	public RepositoryDesconto(ConnectionFactory connection) {
		super(connection);
		entityFuncionario = new RepositoryFuncionario(connection);
	}

	public void setEntityFuncionario(RepositoryFuncionario entityFuncionario) {
		this.entityFuncionario = entityFuncionario;
	}
	
	@Override
	public List<Desconto> findAll() {		
		return executeQuery(namedQuery);		
	}
	
	@Override
	public Desconto persistResultSet(ResultSet rs) {
		try {
			Desconto desconto = new Desconto();
			desconto.setIdDesconto(rs.getInt("id_desconto"));
			desconto.setVldesconto(rs.getBigDecimal("vl_desconto"));
			desconto.setFuncionario(entityFuncionario.persistResultSet(rs));
			return desconto;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	String getTableName() {
		return "descontos";
	}

	@Override
	String getIdColumnName() {
		return "id_desconto";
	}
	
}

package br.com.system_rh.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import br.com.system_rh.dao.configBD.ConnectionFactory;
import br.com.system_rh.model.Desconto;
import br.com.system_rh.service.DescontoService;

public class RepositoryDesconto extends AbstractRepository<Desconto> {
	
	private final String namedQuery = "select * from descontos d inner join funcionario f on d.id_funcionario = f.id_funcionario";
	
	private RepositoryFuncionario entityFuncionario;
	private DescontoService descontoService;

	public RepositoryDesconto(ConnectionFactory connection) {
		super(connection);
		entityFuncionario = new RepositoryFuncionario(connection);
		descontoService = new DescontoService();
	}

	public void setEntityFuncionario(RepositoryFuncionario entityFuncionario) {
		this.entityFuncionario = entityFuncionario;
	}
	
	public List<Desconto>obterListaSalarioLiquidoOrdemDecrescente(){
		return descontoService.obterListaSalarioLiquidoOrdemDecrescente(findAll());
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
			BigDecimal vlDesc = rs.getBigDecimal("vl_desconto");
			desconto.setVldesconto(vlDesc == null?new BigDecimal(0):vlDesc);			
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

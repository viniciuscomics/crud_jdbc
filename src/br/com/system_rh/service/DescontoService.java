package br.com.system_rh.service;

import java.sql.Connection;
import java.util.Comparator;
import java.util.List;

import br.com.system_rh.dao.AbstractRepository;
import br.com.system_rh.dao.RepositoryDesconto;
import br.com.system_rh.dao.configBD.ConnectMySQL;
import br.com.system_rh.dao.configBD.ConnectionFactory;
import br.com.system_rh.model.Desconto;

public class DescontoService {

	private AbstractRepository repositoryDesconto;
	
	public DescontoService() {
		initRepository(new ConnectMySQL());		
	}
	
	public DescontoService(ConnectionFactory connectBD){		
		initRepository(connectBD);
	}
	
	private void initRepository(ConnectionFactory connectBD) {
		repositoryDesconto = new RepositoryDesconto(connectBD);
	}

	public List<Desconto> obterListaSalarioLiquidoOrdemDecrescente() {
		List<Desconto> listDesconto = repositoryDesconto.findAll();
		listDesconto.sort(Comparator.comparing(
				(Desconto e) -> e.getFuncionario().getVlSalarioBruto().subtract(e.getVldesconto())).reversed());		
		return listDesconto;
	}

}

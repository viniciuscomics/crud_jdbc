package br.com.system_rh.controller;

import java.util.List;

import br.com.system_rh.dao.RepositoryDesconto;
import br.com.system_rh.dao.configBD.ConnectMySQL;
import br.com.system_rh.dao.configBD.ConnectionFactory;
import br.com.system_rh.model.Desconto;

public class DescontoController {	
	
	private RepositoryDesconto repositoryDesconto;
	
	public DescontoController() {
		initRepository(new ConnectMySQL());
	}
	
	public DescontoController(ConnectionFactory connectionFactory) {
		initRepository(connectionFactory);
	}
	
	private void initRepository(ConnectionFactory connectBD) {
		repositoryDesconto = new RepositoryDesconto(connectBD);
	}
	
	public List<Desconto> getListOrdenadaVlLiquido(){		
		return repositoryDesconto.obterListaSalarioLiquidoOrdemDecrescente();		
	}

}

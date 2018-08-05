package br.com.system_rh.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.system_rh.model.Desconto;

public class DescontoService {	
	
	public List<Desconto> obterListaSalarioLiquidoOrdemDecrescente(List<Desconto> listDesconto) {
		
		if(listDesconto == null) {
			return new ArrayList<>();
		}
		
		listDesconto.sort(Comparator.comparing(
				(Desconto e) -> e.getFuncionario().getVlSalarioBruto().subtract(e.getVldesconto())).reversed());		
		return listDesconto;
	}

}

package br.com.system_rh;

import java.util.List;

import br.com.system_rh.model.Desconto;
import br.com.system_rh.service.DescontoService;

public class SystemRhApplication {

	public static void main(String[] args) {		
		List<Desconto> listDesc = new DescontoService().obterListaSalarioLiquidoOrdemDecrescente();		
		listDesc.forEach(u->System.out.println(u.getFuncionario().getNmcliente() +" Salario Liquido -> " +
		u.getFuncionario().getVlSalarioBruto().subtract(u.getVldesconto())));		
	}

}

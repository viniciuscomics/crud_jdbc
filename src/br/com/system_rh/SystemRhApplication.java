package br.com.system_rh;

import java.util.List;

import br.com.system_rh.controller.DescontoController;
import br.com.system_rh.model.Desconto;

public class SystemRhApplication {

	public static void main(String[] args) {		
		List<Desconto> listDesc = new DescontoController().getListOrdenadaVlLiquido();		
		listDesc.forEach(u->System.out.println(u.getFuncionario().getNmcliente() +" Salario Liquido -> " +
		u.getFuncionario().getVlSalarioBruto().subtract(u.getVldesconto())));		
	}

}

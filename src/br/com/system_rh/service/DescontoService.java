package br.com.system_rh.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.system_rh.model.Desconto;

public class DescontoService {

	public List<Desconto> obterListaSalarioLiquidoOrdemDecrescente(List<Desconto> listDesconto) {

		if (listDesconto == null) {
			return new ArrayList<>();
		}

		List<Desconto> listFilter = listDesconto.stream()
				.collect(Collectors.groupingBy(Desconto::getFuncionario,
						Collectors.groupingBy(d -> d.getFuncionario().getIdFuncionario(),
								Collectors.reducing(BigDecimal.ZERO, Desconto::getVldesconto, BigDecimal::add))))
				.entrySet().stream().flatMap(e1 -> e1.getValue().entrySet().stream()
						.map(e2 -> new Desconto(e1.getKey(), e2.getKey(), e2.getValue())))
				.collect(Collectors.toList());

		listFilter.sort(Comparator
				.nullsLast(Comparator
						.comparing((Desconto e) -> e.getFuncionario().getVlSalarioBruto().subtract(e.getVldesconto())))
				.reversed());

		return listFilter;
	}

}

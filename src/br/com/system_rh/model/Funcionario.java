package br.com.system_rh.model;

import java.math.BigDecimal;

public class Funcionario {

	private int idFuncionario;
	private String nmcliente;
	private BigDecimal vlSalarioBruto;
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNmcliente() {
		return nmcliente;
	}
	public void setNmcliente(String nmcliente) {
		this.nmcliente = nmcliente;
	}
	public BigDecimal getVlSalarioBruto() {
		return vlSalarioBruto;
	}
	public void setVlSalarioBruto(BigDecimal vlSalarioBruto) {
		this.vlSalarioBruto = vlSalarioBruto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFuncionario;
		result = prime * result + ((nmcliente == null) ? 0 : nmcliente.hashCode());
		result = prime * result + ((vlSalarioBruto == null) ? 0 : vlSalarioBruto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		if (nmcliente == null) {
			if (other.nmcliente != null)
				return false;
		} else if (!nmcliente.equals(other.nmcliente))
			return false;
		if (vlSalarioBruto == null) {
			if (other.vlSalarioBruto != null)
				return false;
		} else if (!vlSalarioBruto.equals(other.vlSalarioBruto))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nmcliente=" + nmcliente + ", vlSalarioBruto="
				+ vlSalarioBruto + "]";
	}
		
}

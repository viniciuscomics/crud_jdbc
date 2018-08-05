package br.com.system_rh.model;

import java.math.BigDecimal;

public class Desconto {

	private int idDesconto;
	private BigDecimal vldesconto;
	private Funcionario funcionario;
	
	public Desconto() {	
	}
	
	public Desconto(Funcionario funcionario,int idDesconto, BigDecimal vlDesconto) {
		this.idDesconto = idDesconto;
		this.vldesconto = vlDesconto;
		this.funcionario = funcionario;
	}

	public int getIdDesconto() {
		return idDesconto;
	}

	public void setIdDesconto(int idDesconto) {
		this.idDesconto = idDesconto;
	}

	public BigDecimal getVldesconto() {
		return vldesconto;
	}

	public void setVldesconto(BigDecimal vldesconto) {
		this.vldesconto = vldesconto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + idDesconto;
		result = prime * result + ((vldesconto == null) ? 0 : vldesconto.hashCode());
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
		Desconto other = (Desconto) obj;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (idDesconto != other.idDesconto)
			return false;
		if (vldesconto == null) {
			if (other.vldesconto != null)
				return false;
		} else if (!vldesconto.equals(other.vldesconto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Desconto [idDesconto=" + idDesconto + ", vldesconto=" + vldesconto + ", funcionario=" + funcionario
				+ "]";
	}
		
}

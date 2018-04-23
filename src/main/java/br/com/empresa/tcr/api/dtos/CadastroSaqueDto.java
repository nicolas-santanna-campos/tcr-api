package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

public class CadastroSaqueDto {

	private String 		idAtivo;
	private String   	idExibeInventario;
	private String   	idBalanceamentoCedulas;
	private BigDecimal	vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	
	public CadastroSaqueDto() {
	
	}
	
	@NotEmpty(message = "O identificador de operação ativa para saque não pode ser nulo.")
	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}

	@NotEmpty(message = "O identificador de exibição do inventário para saque não pode ser nulo.")
	public String getIdExibeInventario() {
		return idExibeInventario;
	}

	public void setIdExibeInventario(String idExibeInventario) {
		this.idExibeInventario = idExibeInventario;
	}

	@NotEmpty(message = "O identificador de balanceamento de cédulas para saque não pode ser nulo.")
	public String getIdBalanceamentoCedulas() {
		return idBalanceamentoCedulas;
	}

	public void setIdBalanceamentoCedulas(String idBalanceamentoCedulas) {
		this.idBalanceamentoCedulas = idBalanceamentoCedulas;
	}

	@NotEmpty(message = "O valor máximo diário para a operação de saque não pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}

	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}

	@NotEmpty(message = "O valor máximo da operação para a saque não pode ser nulo.")
	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}

	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}

	@Override
	public String toString() {
		return "SaqueDto [idAtivo=" + idAtivo + ", idExibeInventario=" + idExibeInventario
				+ ", idBalanceamentoCedulas=" + idBalanceamentoCedulas + ", vlMaxDiario=" + vlMaxDiario
				+ ", vlMaxOperacao=" + vlMaxOperacao + "]";
	}
}

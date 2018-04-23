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
	
	@NotEmpty(message = "O identificador de opera��o ativa para saque n�o pode ser nulo.")
	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}

	@NotEmpty(message = "O identificador de exibi��o do invent�rio para saque n�o pode ser nulo.")
	public String getIdExibeInventario() {
		return idExibeInventario;
	}

	public void setIdExibeInventario(String idExibeInventario) {
		this.idExibeInventario = idExibeInventario;
	}

	@NotEmpty(message = "O identificador de balanceamento de c�dulas para saque n�o pode ser nulo.")
	public String getIdBalanceamentoCedulas() {
		return idBalanceamentoCedulas;
	}

	public void setIdBalanceamentoCedulas(String idBalanceamentoCedulas) {
		this.idBalanceamentoCedulas = idBalanceamentoCedulas;
	}

	@NotEmpty(message = "O valor m�ximo di�rio para a opera��o de saque n�o pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}

	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}

	@NotEmpty(message = "O valor m�ximo da opera��o para a saque n�o pode ser nulo.")
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

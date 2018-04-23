package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CadastroRetiradaDto {

	private String 		idAtivo;
	private BigDecimal  vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	
	public CadastroRetiradaDto() {
	
	}

	@NotEmpty(message = "O identificador de operação ativa para retirada não pode ser nulo.")
	@Length(min = 1, max = 1, message = "O identificador de operação ativa para retirada deve conter um caracter (S ou N).")
	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}

	@NotEmpty(message = "O valor máximo diário para a operação de retirada não pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}

	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}

	@NotEmpty(message = "O valor máximo da operação para a retirada não pode ser nulo.")
	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}

	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}

	@Override
	public String toString() {
		return "RetiradaDto [idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + "]";
	}

}

package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CadastroDepositoDto {

	private String 		idAtivo;
	private BigDecimal  vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	
	public CadastroDepositoDto() {
	
	}
	
	@NotEmpty(message = "O identificador de opera��o ativa para dep�sito n�o pode ser nulo.")
	@Length(min = 1, max = 2, message = "O identificador de opera��o ativa para dep�sito deve conter um caracter (S ou N).")
	public String getIdAtivo() {
		return idAtivo;
	}
	
	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}
	
	@NotEmpty(message = "O valor m�ximo di�rio para a opera��o de dep�sito n�o pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}
	
	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}
	
	@NotEmpty(message = "O valor m�ximo da opera��o para a dep�sito n�o pode ser nulo.")
	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}
	
	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}

	@Override
	public String toString() {
		return "DepositoDto [idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + "]";
	}
}

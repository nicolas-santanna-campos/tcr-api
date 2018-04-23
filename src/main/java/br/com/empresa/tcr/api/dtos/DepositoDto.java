package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class DepositoDto {

	private Long 		id;
	private String 		idAtivo;
	private BigDecimal  vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	
	
	public DepositoDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "O identificador de operação ativa para depósito não pode ser nulo.")
	@Length(min = 1, max = 2, message = "O identificador de operação ativa para depósito deve conter um caracter (S ou N).")
	public String getIdAtivo() {
		return idAtivo;
	}
	
	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}
	
	@NotEmpty(message = "O valor máximo diário para a operação de depósito não pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}
	
	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}
	
	@NotEmpty(message = "O valor máximo da operação para a depósito não pode ser nulo.")
	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}
	
	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}

	@Override
	public String toString() {
		return "DepositoDto [id=" + id + ", idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + "]";
	}
}

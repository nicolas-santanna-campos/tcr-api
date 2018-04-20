package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class RetiradaDto {

	private Long 		id;
	private String 	idAtivo;
	private BigDecimal  vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	private String 		cdUsuarioAlt;
	private Date 		dtInclusao;
	private Date 		dtAlteracao;
	
	public RetiradaDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@NotEmpty(message = "O nome de usuário da alteração não pode ser nulo.")
	@Length(min = 3, max = 10, message = "O nome do usuário deve conter entre 3 e 10 caracteres.")
	public String getCdUsuarioAlt() {
		return cdUsuarioAlt;
	}

	public void setCdUsuarioAlt(String cdUsuarioAlt) {
		this.cdUsuarioAlt = cdUsuarioAlt;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	@Override
	public String toString() {
		return "RetiradaDto [id=" + id + ", idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao=" + dtInclusao + ", dtAlteracao="
				+ dtAlteracao + "]";
	}
}

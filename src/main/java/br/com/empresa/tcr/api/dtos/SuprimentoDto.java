package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class SuprimentoDto {

	private Long 		id;
	private Character 	idAtivo;
	private Character   idExibeInventario;
	private Character   idBalanceamentoCedulas;
	private BigDecimal	vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	private String 		cdUsuarioAlt;
	private Date 		dtInclusao;
	private Date 		dtAlteracao;
	
	public SuprimentoDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(Character idAtivo) {
		this.idAtivo = idAtivo;
	}

	public Character getIdExibeInventario() {
		return idExibeInventario;
	}

	public void setIdExibeInventario(Character idExibeInventario) {
		this.idExibeInventario = idExibeInventario;
	}

	public Character getIdBalanceamentoCedulas() {
		return idBalanceamentoCedulas;
	}

	public void setIdBalanceamentoCedulas(Character idBalanceamentoCedulas) {
		this.idBalanceamentoCedulas = idBalanceamentoCedulas;
	}

	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}

	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}

	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}

	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}

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
}

package br.com.empresa.tcr.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "deposito")
public class Deposito implements Serializable {

	private static final long serialVersionUID = 2979438716854776687L;
	
	private Long 		id;
	private Character 	idAtivo;
	private BigDecimal  vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	private String 		cdUsuarioAlt;
	private Date 		dtInclusao;
	private Date 		dtAlteracao;
	
	public Deposito() {
		
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

	@Override
	public String toString() {
		return "Deposito [id=" + id + ", idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao=" + dtInclusao + ", dtAlteracao="
				+ dtAlteracao + "]";
	}
	
}

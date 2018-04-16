package br.com.empresa.tcr.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "id_ativo", nullable = false, length = 1)
	public Character getIdAtivo() {
		return idAtivo;
	}
	
	public void setIdAtivo(Character idAtivo) {
		this.idAtivo = idAtivo;
	}
	
	@Column(name = "vl_max_diario", nullable = false)
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}
	
	@Transient
	public Optional<BigDecimal> getVlMaxDiarioOpt() {
		return Optional.ofNullable(vlMaxDiario);
	}
	
	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}
	
	@Column(name = "vl_max_operacao", nullable = false)
	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}
	
	@Transient
	public Optional<BigDecimal> getVlMaxOperacaoOpt() {
		return Optional.ofNullable(vlMaxOperacao);
	}
	
	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}
	
	@Column(name = "cd_usuario_alt", nullable = false)
	@Size(min = 3, max = 10, message = "O nome do usuário deve conter entre 3 e 10 caracteres.")
	public String getCdUsuarioAlt() {
		return cdUsuarioAlt;
	}
	
	public void setCdUsuarioAlt(String cdUsuarioAlt) {
		this.cdUsuarioAlt = cdUsuarioAlt;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inclusao", nullable = false)
	public Date getDtInclusao() {
		return dtInclusao;
	}
	
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao", nullable = false)
	public Date getDtAlteracao() {
		return dtAlteracao;
	}
	
	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
	
	@PreUpdate
	public void preUpdate() { 
		dtAlteracao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		Date dataAtual = new Date();
		dtInclusao 	   = dataAtual;
		dtAlteracao    = dataAtual;
	}
	
	@Override
	public String toString() {
		return "Deposito [id=" + id + ", idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao=" + dtInclusao + ", dtAlteracao="
				+ dtAlteracao + "]";
	}
	
}

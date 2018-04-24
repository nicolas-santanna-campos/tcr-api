package br.com.empresa.tcr.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "deposito")
public class Deposito implements Serializable {

	private static final long serialVersionUID = -1424509623338191134L;
	
	private Long 		id;
	private String	 	idAtivo;
	private BigDecimal  vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
		
	public Deposito() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "id_ativo", nullable = false, length = 1)
	public String getIdAtivo() {
		return idAtivo;
	}
	
	public void setIdAtivo(String idAtivo) {
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

	@Override
	public String toString() {
		return "Deposito [id=" + id + ", idAtivo=" + idAtivo + ", vlMaxDiario=" + vlMaxDiario + ", vlMaxOperacao="
				+ vlMaxOperacao + "]";
	}
	
}

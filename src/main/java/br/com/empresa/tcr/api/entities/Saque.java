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
@Table(name = "saque")
public class Saque implements Serializable {

	private static final long serialVersionUID = -3562858321641731660L;
	
	private Long 		id;
	private String 		idAtivo;
	private String   	idExibeInventario;
	private String   	idBalanceamentoCedulas;
	private BigDecimal	vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	
	public Saque() {
		
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
	
	@Column(name = "id_exibe_inventario", nullable = false, length = 1)
	public String getIdExibeInventario() {
		return idExibeInventario;
	}
	
	public void setIdExibeInventario(String idExibeInventario) {
		this.idExibeInventario = idExibeInventario;
	}
	
	@Column(name = "id_balanceamento_cedulas", nullable = false, length = 1)
	public String getIdBalanceamentoCedulas() {
		return idBalanceamentoCedulas;
	}
	
	public void setIdBalanceamentoCedulas(String idBalanceamentoCedulas) {
		this.idBalanceamentoCedulas = idBalanceamentoCedulas;
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
		return "Saque [id=" + id + ", idAtivo=" + idAtivo + ", idExibeInventario=" + idExibeInventario
				+ ", idBalanceamentoCedulas=" + idBalanceamentoCedulas + ", vlMaxDiario=" + vlMaxDiario
				+ ", vlMaxOperacao=" + vlMaxOperacao + "]";
	}
	
}

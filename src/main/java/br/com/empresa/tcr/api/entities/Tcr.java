package br.com.empresa.tcr.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tcr")
public class Tcr implements Serializable {

	private static final long serialVersionUID = -9000600188718728829L;
	
	private Long 		id;
	private String 		dsNome;
	private Integer 	cdPosto;
	private Integer 	cdCooperativa;
	private String 		idTesoureiroAtivo;
	private String 		cdUsuarioAlt;
	private Date 		dtInclusao;
	private Date 		dtAlteracao;
	private String 		idLimiteExcedidoAutorizaTesoureiro;
	private Suprimento  suprimento;
	private Retirada 	retirada;
	private Deposito 	deposito;
	private Saque 		saque;
	
	public Tcr() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull(message = "O nome é obrigatório.")
	@NotEmpty(message = "O nome é obrigatório.")
	@Size(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres.")
	@Column(name = "ds_nome")
	public String getDsNome() {
		return dsNome;
	}
	
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	
	@NotNull(message = "O posto é obrigatório.")
	@Column(name = "cd_posto", nullable = false)
	public Integer getCdPosto() {
		return cdPosto;
	}
	
	public void setCdPosto(Integer cdPosto) {
		this.cdPosto = cdPosto;
	}
	
	@NotNull(message = "A cooperativa é obrigatório.")
	@Column(name = "cd_coop", nullable = false)
	public Integer getCdCooperativa() {
		return cdCooperativa;
	}
	
	public void setCdCooperativa(Integer cdCooperativa) {
		this.cdCooperativa = cdCooperativa;
	}
	
	@Column(name = "id_tesoureiro_ativo", nullable = false, length = 1)
	public String getIdTesoureiroAtivo() {
		return idTesoureiroAtivo;
	}
	
	public void setIdTesoureiroAtivo(String idTesoureiroAtivo) {
		this.idTesoureiroAtivo = idTesoureiroAtivo;
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
	
	@Column(name = "id_limite_excedido_autoriza_tesoureiro", nullable = false, length = 1)
	public String getIdLimiteExcedidoAutorizaTesoureiro() {
		return idLimiteExcedidoAutorizaTesoureiro;
	}
	
	public void setIdLimiteExcedidoAutorizaTesoureiro(String idLimiteExcedidoAutorizaTesoureiro) {
		this.idLimiteExcedidoAutorizaTesoureiro = idLimiteExcedidoAutorizaTesoureiro;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_suprimento", nullable = false)
	public Suprimento getSuprimento() {
		return suprimento;
	}
	
	public void setSuprimento(Suprimento suprimento) {
		this.suprimento = suprimento;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_retirada", nullable = false)
	public Retirada getRetirada() {
		return retirada;
	}
	
	public void setRetirada(Retirada retirada) {
		this.retirada = retirada;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_deposito", nullable = false)
	public Deposito getDeposito() {
		return deposito;
	}
	
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_saque", nullable = false)
	public Saque getSaque() {
		return saque;
	}
	
	public void setSaque(Saque saque) {
		this.saque = saque;
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
		return "Tcr [id=" + id + ", dsNome=" + dsNome + ", cdPosto=" + cdPosto + ", cdCooperativa=" + cdCooperativa
				+ ", idTesoureiroAtivo=" + idTesoureiroAtivo + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao="
				+ dtInclusao + ", dtAlteracao=" + dtAlteracao + ", idLimiteExcedidoAutorizaTesoureiro="
				+ idLimiteExcedidoAutorizaTesoureiro + ", suprimento ID=" + suprimento.getId() + ", retirada ID=" + retirada.getId()
				+ ", deposito ID=" + deposito.getId() + ", saque ID=" + saque.getId() + "]";
	}
	
	
	
}

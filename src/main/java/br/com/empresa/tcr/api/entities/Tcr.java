package br.com.empresa.tcr.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tcr")
public class Tcr implements Serializable {

	private static final long serialVersionUID = 3970490788281573344L;
	
	private Long 		id;
	private String 		dsNome;
	private Integer 	cdPosto;
	private Integer 	cdCooperativa;
	private Character 	idTesoureiroAtivo;
	private String 		cdUsuarioAlt;
	private Date 		dtInclusao;
	private Date 		dtAlteracao;
	private Character 	idLimiteExcedidoAutorizaTesoureiro;
	private Suprimento  suprimento;
	private Retirada 	retirada;
	private Deposito 	deposito;
	private Saque 		saque;
	
	public Tcr() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDsNome() {
		return dsNome;
	}
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	public Integer getCdPosto() {
		return cdPosto;
	}
	public void setCdPosto(Integer cdPosto) {
		this.cdPosto = cdPosto;
	}
	public Integer getCdCooperativa() {
		return cdCooperativa;
	}
	public void setCdCooperativa(Integer cdCooperativa) {
		this.cdCooperativa = cdCooperativa;
	}
	public Character getIdTesoureiroAtivo() {
		return idTesoureiroAtivo;
	}
	public void setIdTesoureiroAtivo(Character idTesoureiroAtivo) {
		this.idTesoureiroAtivo = idTesoureiroAtivo;
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
	public Character getIdLimiteExcedidoAutorizaTesoureiro() {
		return idLimiteExcedidoAutorizaTesoureiro;
	}
	public void setIdLimiteExcedidoAutorizaTesoureiro(Character idLimiteExcedidoAutorizaTesoureiro) {
		this.idLimiteExcedidoAutorizaTesoureiro = idLimiteExcedidoAutorizaTesoureiro;
	}
	public Suprimento getSuprimento() {
		return suprimento;
	}
	public void setSuprimento(Suprimento suprimento) {
		this.suprimento = suprimento;
	}
	public Retirada getRetirada() {
		return retirada;
	}
	public void setRetirada(Retirada retirada) {
		this.retirada = retirada;
	}
	public Deposito getDeposito() {
		return deposito;
	}
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	public Saque getSaque() {
		return saque;
	}
	public void setSaque(Saque saque) {
		this.saque = saque;
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

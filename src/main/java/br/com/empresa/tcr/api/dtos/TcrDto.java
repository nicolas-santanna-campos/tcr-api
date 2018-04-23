package br.com.empresa.tcr.api.dtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.empresa.tcr.api.entities.Deposito;
import br.com.empresa.tcr.api.entities.Retirada;
import br.com.empresa.tcr.api.entities.Saque;
import br.com.empresa.tcr.api.entities.Suprimento;

public class TcrDto {

	private Long 		  id;
	private String 		  dsNome;
	private Integer 	  cdPosto;
	private Integer 	  cdCooperativa;
	private String 	  	  idTesoureiroAtivo;
	private String 		  cdUsuarioAlt;
	private Date 		  dtInclusao;
	private Date 		  dtAlteracao;
	private String 	  	  idLimiteExcedidoAutorizaTesoureiro;
	private SuprimentoDto suprimentoDto;
	private RetiradaDto   retiradaDto;
	private DepositoDto   depositoDto;
	private SaqueDto 	  saqueDto;
	
	public TcrDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "O nome não pode ser vazio.")
	@Length(min = 3, max = 100, message = "O nome deve conter entre 3 e 100 caracteres.")
	public String getDsNome() {
		return dsNome;
	}
	
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	
	@NotNull(message = "O posto não pode ser nulo.")
	public Integer getCdPosto() {
		return cdPosto;
	}
	
	public void setCdPosto(Integer cdPosto) {
		this.cdPosto = cdPosto;
	}
	
	@NotNull(message = "A cooperativa não pode ser nula.")
	public Integer getCdCooperativa() {
		return cdCooperativa;
	}
	
	public void setCdCooperativa(Integer cdCooperativa) {
		this.cdCooperativa = cdCooperativa;
	}
	
	@NotEmpty(message = "O identificador de tesoureiro ativo não pode ser vazio.")
	@NotNull(message = "O identificador de tesoureiro ativo não pode ser nulo.")
	@Length(min = 1, max = 1, message = "O identificador de tesoureiro ativo deve conter um caractere (S ou N).")
	public String getIdTesoureiroAtivo() {
		return idTesoureiroAtivo;
	}
	
	public void setIdTesoureiroAtivo(String idTesoureiroAtivo) {
		this.idTesoureiroAtivo = idTesoureiroAtivo;
	}
	
	@NotEmpty(message = "O nome de usuário da alteração não pode ser vazio.")
	@NotNull(message = "O nome de usuário da alteração não pode ser nulo.")
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
	
	@NotEmpty(message = "O identificador para caso exceda o limite e necessite de autorização de tesoureiro não pode ser vazio. ")
	@NotNull(message = "O identificador para caso exceda o limite e necessite de autorização de tesoureiro não pode ser nulo. ")
	@Length(min = 1, max = 1, message = "O identificador para caso exceda e necessite de autorização de tesoureio deve conter um caractere (S ou N).")
	public String getIdLimiteExcedidoAutorizaTesoureiro() {
		return idLimiteExcedidoAutorizaTesoureiro;
	}
	
	public void setIdLimiteExcedidoAutorizaTesoureiro(String idLimiteExcedidoAutorizaTesoureiro) {
		this.idLimiteExcedidoAutorizaTesoureiro = idLimiteExcedidoAutorizaTesoureiro;
	}

	public SuprimentoDto getSuprimentoDto() {
		return suprimentoDto;
	}

	public void setSuprimentoDto(SuprimentoDto suprimentoDto) {
		this.suprimentoDto = suprimentoDto;
	}

	public RetiradaDto getRetiradaDto() {
		return retiradaDto;
	}

	public void setRetiradaDto(RetiradaDto retiradaDto) {
		this.retiradaDto = retiradaDto;
	}

	public DepositoDto getDepositoDto() {
		return depositoDto;
	}

	public void setDepositoDto(DepositoDto depositoDto) {
		this.depositoDto = depositoDto;
	}

	public SaqueDto getSaqueDto() {
		return saqueDto;
	}

	public void setSaqueDto(SaqueDto saqueDto) {
		this.saqueDto = saqueDto;
	}

	@Override
	public String toString() {
		return "TcrDto [id=" + id + ", dsNome=" + dsNome + ", cdPosto=" + cdPosto + ", cdCooperativa=" + cdCooperativa
				+ ", idTesoureiroAtivo=" + idTesoureiroAtivo + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao="
				+ dtInclusao + ", dtAlteracao=" + dtAlteracao + ", idLimiteExcedidoAutorizaTesoureiro="
				+ idLimiteExcedidoAutorizaTesoureiro + ", suprimentoDto ID=" + suprimentoDto.getId() + ", retiradaDto ID="
				+ retiradaDto.getId() + ", depositoDto ID=" + depositoDto.getId() + ", saqueDto ID=" + saqueDto.getId() + "]";
	}	
}

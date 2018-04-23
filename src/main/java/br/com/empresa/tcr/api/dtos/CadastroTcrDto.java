package br.com.empresa.tcr.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CadastroTcrDto {
	
	private String 	dsNome;
	private Integer cdPosto;
	private Integer cdCooperativa;
	private String 	idTesoureiroAtivo;
	private String 	cdUsuarioAlt;
	private String 	idLimiteExcedidoAutorizaTesoureiro;
	private CadastroSuprimentoDto cadastroSuprimentoDto;
	private CadastroSaqueDto 	  cadastroSaqueDto;
	private CadastroDepositoDto   cadastroDepositoDto;
	private CadastroRetiradaDto   cadastroRetiradaDto;
	
	public CadastroTcrDto() {
		
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
	
	@NotEmpty(message = "O identificador para caso exceda o limite e necessite de autorização de tesoureiro não pode ser vazio. ")
	@NotNull(message = "O identificador para caso exceda o limite e necessite de autorização de tesoureiro não pode ser nulo. ")
	@Length(min = 1, max = 1, message = "O identificador para caso exceda e necessite de autorização de tesoureio deve conter um caractere (S ou N).")
	public String getIdLimiteExcedidoAutorizaTesoureiro() {
		return idLimiteExcedidoAutorizaTesoureiro;
	}
	
	public void setIdLimiteExcedidoAutorizaTesoureiro(String idLimiteExcedidoAutorizaTesoureiro) {
		this.idLimiteExcedidoAutorizaTesoureiro = idLimiteExcedidoAutorizaTesoureiro;
	}

	public CadastroSuprimentoDto getCadastroSuprimentoDto() {
		return cadastroSuprimentoDto;
	}

	public void setCadastroSuprimentoDto(CadastroSuprimentoDto cadastroSuprimentoDto) {
		this.cadastroSuprimentoDto = cadastroSuprimentoDto;
	}

	public CadastroSaqueDto getCadastroSaqueDto() {
		return cadastroSaqueDto;
	}

	public void setCadastroSaqueDto(CadastroSaqueDto cadastroSaqueDto) {
		this.cadastroSaqueDto = cadastroSaqueDto;
	}

	public CadastroDepositoDto getCadastroDepositoDto() {
		return cadastroDepositoDto;
	}

	public void setCadastroDepositoDto(CadastroDepositoDto cadastroDepositoDto) {
		this.cadastroDepositoDto = cadastroDepositoDto;
	}

	public CadastroRetiradaDto getCadastroRetiradaDto() {
		return cadastroRetiradaDto;
	}

	public void setCadastroRetiradaDto(CadastroRetiradaDto cadastroRetiradaDto) {
		this.cadastroRetiradaDto = cadastroRetiradaDto;
	}

	@Override
	public String toString() {
		return "CadastroTcrDto [dsNome=" + dsNome + ", cdPosto=" + cdPosto + ", cdCooperativa=" + cdCooperativa
				+ ", idTesoureiroAtivo=" + idTesoureiroAtivo + ", cdUsuarioAlt=" + cdUsuarioAlt + ", idLimiteExcedidoAutorizaTesoureiro="
				+ idLimiteExcedidoAutorizaTesoureiro + ", cadastroSuprimentoDto=" + cadastroSuprimentoDto
				+ ", cadastroSaqueDto=" + cadastroSaqueDto + ", cadastroDepositoDto=" + cadastroDepositoDto
				+ ", cadastroRetiradaDto=" + cadastroRetiradaDto + "]";
	}
}

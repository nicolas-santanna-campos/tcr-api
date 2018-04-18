package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class SaqueDto {

	private Long 		id;
	private Character 	idAtivo;
	private Character   idExibeInventario;
	private Character   idBalanceamentoCedulas;
	private BigDecimal	vlMaxDiario;
	private BigDecimal  vlMaxOperacao;
	private String 		cdUsuarioAlt;
	private Date 		dtInclusao;
	private Date 		dtAlteracao;
	
	public SaqueDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "O identificador de opera��o ativa para saque n�o pode ser nulo.")
	public Character getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(Character idAtivo) {
		this.idAtivo = idAtivo;
	}

	@NotEmpty(message = "O identificador de exibi��o do invent�rio para saque n�o pode ser nulo.")
	public Character getIdExibeInventario() {
		return idExibeInventario;
	}

	public void setIdExibeInventario(Character idExibeInventario) {
		this.idExibeInventario = idExibeInventario;
	}

	@NotEmpty(message = "O identificador de balanceamento de c�dulas para saque n�o pode ser nulo.")
	public Character getIdBalanceamentoCedulas() {
		return idBalanceamentoCedulas;
	}

	public void setIdBalanceamentoCedulas(Character idBalanceamentoCedulas) {
		this.idBalanceamentoCedulas = idBalanceamentoCedulas;
	}

	@NotEmpty(message = "O valor m�ximo di�rio para a opera��o de saque n�o pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}

	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}

	@NotEmpty(message = "O valor m�ximo da opera��o para a saque n�o pode ser nulo.")
	public BigDecimal getVlMaxOperacao() {
		return vlMaxOperacao;
	}

	public void setVlMaxOperacao(BigDecimal vlMaxOperacao) {
		this.vlMaxOperacao = vlMaxOperacao;
	}

	@NotEmpty(message = "O nome de usu�rio da altera��o n�o pode ser nulo.")
	@Length(min = 3, max = 10, message = "O nome do usu�rio deve conter entre 3 e 10 caracteres.")
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
		return "SaqueDto [id=" + id + ", idAtivo=" + idAtivo + ", idExibeInventario=" + idExibeInventario
				+ ", idBalanceamentoCedulas=" + idBalanceamentoCedulas + ", vlMaxDiario=" + vlMaxDiario
				+ ", vlMaxOperacao=" + vlMaxOperacao + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao=" + dtInclusao
				+ ", dtAlteracao=" + dtAlteracao + "]";
	}
}

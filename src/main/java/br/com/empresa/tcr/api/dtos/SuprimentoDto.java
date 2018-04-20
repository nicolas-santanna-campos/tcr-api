package br.com.empresa.tcr.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class SuprimentoDto {

	private Long 		id;
	private String 	idAtivo;
	private String   idExibeInventario;
	private String   idBalanceamentoCedulas;
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

	@NotEmpty(message = "O identificador de opera��o ativa para suprimento n�o pode ser nulo.")
	@Length(min = 1, max = 1, message = "O identificador de opera��o ativa para suprimento deve conter um caracter (S ou N).")
	public String getIdAtivo() {
		return idAtivo;
	}

	public void setIdAtivo(String idAtivo) {
		this.idAtivo = idAtivo;
	}

	@NotEmpty(message = "O identificador de exibi��o do invent�rio para suprimento n�o pode ser nulo.")
	@Length(min = 1, max = 1, message = "O identificador de exibi��o do invent�rio para suprimento deve conter um caracter (S ou N).")
	public String getIdExibeInventario() {
		return idExibeInventario;
	}

	public void setIdExibeInventario(String idExibeInventario) {
		this.idExibeInventario = idExibeInventario;
	}

	@NotEmpty(message = "O identificador de balanceamento de c�dulas para suprimento n�o pode ser nulo.")
	@Length(min = 1, max = 1, message = "O identificador de balanceamento de c�dulas para suprimento deve conter um caracter (S ou N).")
	public String getIdBalanceamentoCedulas() {
		return idBalanceamentoCedulas;
	}

	public void setIdBalanceamentoCedulas(String idBalanceamentoCedulas) {
		this.idBalanceamentoCedulas = idBalanceamentoCedulas;
	}

	@NotEmpty(message = "O valor m�ximo di�rio para a opera��o de suprimento n�o pode ser nulo.")
	public BigDecimal getVlMaxDiario() {
		return vlMaxDiario;
	}

	public void setVlMaxDiario(BigDecimal vlMaxDiario) {
		this.vlMaxDiario = vlMaxDiario;
	}

	@NotEmpty(message = "O valor m�ximo da opera��o para a suprimento n�o pode ser nulo.")
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
		return "SuprimentoDto [id=" + id + ", idAtivo=" + idAtivo + ", idExibeInventario=" + idExibeInventario
				+ ", idBalanceamentoCedulas=" + idBalanceamentoCedulas + ", vlMaxDiario=" + vlMaxDiario
				+ ", vlMaxOperacao=" + vlMaxOperacao + ", cdUsuarioAlt=" + cdUsuarioAlt + ", dtInclusao=" + dtInclusao
				+ ", dtAlteracao=" + dtAlteracao + "]";
	}
}

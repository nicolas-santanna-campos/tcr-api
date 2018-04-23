package br.com.empresa.tcr.api.utils;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import br.com.empresa.tcr.api.entities.Deposito;
import br.com.empresa.tcr.api.entities.Retirada;
import br.com.empresa.tcr.api.entities.Saque;
import br.com.empresa.tcr.api.entities.Suprimento;
import br.com.empresa.tcr.api.entities.Tcr;

public class TcrUtilTest {

	private static final Integer    COOPERATIVA 	   = 515;
	private static final Integer    POSTO 			   = 0;
	private static final String     NOME_TESOUREIRO    = "teste";
	private static final String     USUARIO		 	   = "teste";
	private static final String     NAO			 	   = "N";
	private static final String     SIM			 	   = "S";
	private static final BigDecimal VALOR_MAX_DIARIO   = new BigDecimal(100);
	private static final BigDecimal VALOR_MAX_OPERACAO = new BigDecimal(100);
	private static final Date 		DATA			   = new Date();
	
	/**
	 * Obtem uma entidade {@link Tcr} para testes.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Tcr converterTcr() throws Exception {
		Deposito   deposito   = obterDadosDeposito();
		Retirada   retirada   = obterDadosRetirada();
		Saque 	   saque 	  = obterDadosSaque();
		Suprimento suprimento = obterDadosSuprimento();
		
		Tcr tcr = new Tcr();
		
		tcr.setDsNome(NOME_TESOUREIRO);
		tcr.setCdPosto(POSTO);
		tcr.setCdCooperativa(COOPERATIVA);
		tcr.setIdTesoureiroAtivo(NAO);
		tcr.setCdUsuarioAlt(USUARIO);
		tcr.setDtInclusao(DATA);
		tcr.setDtAlteracao(DATA);
		tcr.setIdLimiteExcedidoAutorizaTesoureiro(NAO);
		tcr.setDeposito(deposito);
		tcr.setRetirada(retirada);
		tcr.setSaque(saque);
		tcr.setSuprimento(suprimento);
		return tcr;
	}
	
	private static Deposito obterDadosDeposito() throws NoSuchAlgorithmException {
		Deposito   deposito   = new Deposito();
		deposito.setIdAtivo(SIM);
		deposito.setVlMaxDiario(VALOR_MAX_DIARIO);
		deposito.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		return deposito;
	}
	
	private static Retirada obterDadosRetirada() throws NoSuchAlgorithmException {
		Retirada   retirada   = new Retirada();
		retirada.setIdAtivo(SIM);
		retirada.setVlMaxDiario(VALOR_MAX_DIARIO);
		retirada.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		return retirada;
	}
	
	private static Saque obterDadosSaque() throws NoSuchAlgorithmException {
		Saque saque = new Saque();
		saque.setIdAtivo(SIM);
		saque.setVlMaxDiario(VALOR_MAX_DIARIO);
		saque.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		saque.setIdExibeInventario(NAO);
		saque.setIdBalanceamentoCedulas(NAO);
		return saque;
	}
	
	private static Suprimento obterDadosSuprimento() throws NoSuchAlgorithmException {
		Suprimento suprimento = new Suprimento();
		suprimento.setIdAtivo(SIM);
		suprimento.setVlMaxDiario(VALOR_MAX_DIARIO);
		suprimento.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		suprimento.setIdExibeInventario(NAO);
		suprimento.setIdBalanceamentoCedulas(NAO);
		return suprimento;
	}
}


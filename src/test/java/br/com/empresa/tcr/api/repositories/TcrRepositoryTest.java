package br.com.empresa.tcr.api.repositories;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.empresa.tcr.api.entities.Deposito;
import br.com.empresa.tcr.api.entities.Retirada;
import br.com.empresa.tcr.api.entities.Saque;
import br.com.empresa.tcr.api.entities.Suprimento;
import br.com.empresa.tcr.api.entities.Tcr;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TcrRepositoryTest {

	@Autowired
	private TcrRepository tcrRepository;
	
	private static final Integer    COOPERATIVA 	   = 515;
	private static final Integer    POSTO 			   = 0;
	private static final String     NOME_TESOUREIRO    = "teste";
	private static final String     USUARIO		 	   = "teste";
	private static final Character  NAO			 	   = 'N';
	private static final Character  SIM			 	   = 'S';
	private static final BigDecimal VALOR_MAX_DIARIO   = new BigDecimal(100);
	private static final BigDecimal VALOR_MAX_OPERACAO = new BigDecimal(100);
	private static final Date 		DATA			   = new Date();
	
	@Before
	public void setUp() throws Exception {
		
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
		
		this.tcrRepository.save(tcr);
	}
	
	@After
	public void tearDown() throws Exception {
		this.tcrRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorNomeECooperativa() {
		List<Tcr> tcrList = this.tcrRepository.findByDsNomeAndCdCooperativa(NOME_TESOUREIRO, COOPERATIVA);
		
		assertEquals(NOME_TESOUREIRO, tcrList.get(0).getDsNome());
	}
	
	@Test
	public void testBuscarPorCooperativaEPosto() {
		List<Tcr> tcrList = this.tcrRepository.findByCdCooperativaAndCdPosto(COOPERATIVA, POSTO);
		
		assertEquals(NOME_TESOUREIRO, tcrList.get(0).getDsNome());
	}
	
	@Test
	public void testBuscarPorNomeCooperativaEPosto() {
		List<Tcr> tcrList = this.tcrRepository.findByDsNomeAndCdCooperativaAndCdPosto(NOME_TESOUREIRO, COOPERATIVA, POSTO);
		
		assertEquals(NOME_TESOUREIRO, tcrList.get(0).getDsNome());
	}
	
	private Deposito obterDadosDeposito() throws NoSuchAlgorithmException {
		Deposito   deposito   = new Deposito();
		deposito.setIdAtivo(SIM);
		deposito.setVlMaxDiario(VALOR_MAX_DIARIO);
		deposito.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		deposito.setCdUsuarioAlt(USUARIO);
		deposito.setDtInclusao(DATA);
		deposito.setDtAlteracao(DATA);
		
		return deposito;
	}
	
	private Retirada obterDadosRetirada() throws NoSuchAlgorithmException {
		Retirada   retirada   = new Retirada();
		retirada.setIdAtivo(SIM);
		retirada.setVlMaxDiario(VALOR_MAX_DIARIO);
		retirada.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		retirada.setCdUsuarioAlt(USUARIO);
		retirada.setDtInclusao(DATA);
		retirada.setDtAlteracao(DATA);
		
		return retirada;
	}
	
	private Saque obterDadosSaque() throws NoSuchAlgorithmException {
		Saque saque = new Saque();
		saque.setIdAtivo(SIM);
		saque.setVlMaxDiario(VALOR_MAX_DIARIO);
		saque.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		saque.setIdExibeInventario(NAO);
		saque.setIdBalanceamentoCedulas(NAO);
		saque.setCdUsuarioAlt(USUARIO);
		saque.setDtInclusao(DATA);
		saque.setDtAlteracao(DATA);
		
		return saque;
	}
	
	private Suprimento obterDadosSuprimento() throws NoSuchAlgorithmException {
		Suprimento suprimento = new Suprimento();
		suprimento.setIdAtivo(SIM);
		suprimento.setVlMaxDiario(VALOR_MAX_DIARIO);
		suprimento.setVlMaxOperacao(VALOR_MAX_OPERACAO);
		suprimento.setIdExibeInventario(NAO);
		suprimento.setIdBalanceamentoCedulas(NAO);
		suprimento.setCdUsuarioAlt(USUARIO);
		suprimento.setDtInclusao(DATA);
		suprimento.setDtAlteracao(DATA);
		
		return suprimento;
	}
}

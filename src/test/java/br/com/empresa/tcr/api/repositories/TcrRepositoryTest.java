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
import br.com.empresa.tcr.api.utils.TcrUtilTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TcrRepositoryTest {

	@Autowired
	private TcrRepository tcrRepository;
	
	private static final Integer    COOPERATIVA 	   = 515;
	private static final Integer    POSTO 			   = 0;
	private static final String     NOME_TESOUREIRO    = "teste";

	
	@Before
	public void setUp() throws Exception {
		this.tcrRepository.save(TcrUtilTest.converterTcr());
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
}

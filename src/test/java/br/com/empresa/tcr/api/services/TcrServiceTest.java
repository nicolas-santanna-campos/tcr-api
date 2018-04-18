package br.com.empresa.tcr.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.empresa.tcr.api.entities.Tcr;
import br.com.empresa.tcr.api.repositories.TcrRepository;
import br.com.empresa.tcr.api.utils.TcrUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TcrServiceTest {

	@MockBean
	private TcrRepository tcrRepository;
	
	@Autowired
	TcrService tcrService;
	
	private static final String  NOME 		 = "teste";
	private static final Integer COOPERATIVA = 515;
	private static final Integer POSTO 		 = 0;
	
	@Before
	public void setUp() throws Exception {
		List<Tcr> list = new ArrayList<Tcr>();
		list.add(TcrUtils.obterTcr());
		
		BDDMockito.given(this.tcrRepository.findByDsNomeAndCdCooperativa(Mockito.anyString(), Mockito.anyInt())).willReturn(list);
		BDDMockito.given(this.tcrRepository.findByCdCooperativaAndCdPosto(Mockito.anyInt(), Mockito.anyInt())).willReturn(list);
		BDDMockito.given(this.tcrRepository.findByDsNomeAndCdCooperativaAndCdPosto(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).willReturn(list);
		BDDMockito.given(this.tcrRepository.save(Mockito.any(Tcr.class))).willReturn(new Tcr());
	}
	
	@Test
	public void testBuscarTcrPorNomeECooperativa() {
		Optional<Tcr> tcrOpt = Optional.ofNullable(this.tcrService.buscarPorNomeECooperativa(NOME, COOPERATIVA).get(0));
		
		assertTrue(tcrOpt.isPresent());
	}
	
	@Test
	public void testBuscarPorCooeprativaEPosto() {
		Optional<Tcr> tcrOpt = Optional.ofNullable(this.tcrService.buscarPorCooperativaEPosto(COOPERATIVA, POSTO).get(0));
		
		assertTrue(tcrOpt.isPresent());
	}
	
	@Test
	public void testBuscarPorNomeCooperativaEPosto() {
		Optional<Tcr> tcrOpt = Optional.ofNullable(this.tcrService.buscarPorNomeCooperativaEPosto(NOME, COOPERATIVA, POSTO).get(0));
		
		assertTrue(tcrOpt.isPresent());
	}
	
	@Test
	public void testPersistirTcr() throws Exception {
		Tcr tcr = this.tcrService.persistir(TcrUtils.obterTcr());
		
		assertNotNull(tcr);
	}
	
	
}

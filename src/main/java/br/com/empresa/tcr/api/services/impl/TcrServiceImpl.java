package br.com.empresa.tcr.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.tcr.api.entities.Tcr;
import br.com.empresa.tcr.api.repositories.TcrRepository;
import br.com.empresa.tcr.api.services.TcrService;

@Service
public class TcrServiceImpl implements TcrService {
	
	private static final Logger log = LoggerFactory.getLogger(TcrServiceImpl.class);

	@Autowired
	private TcrRepository tcrRepository;
	
	
	@Override
	public List<Tcr> buscarPorNomeECooperativa(String nome, Integer cooperativa) {
		log.info("Buscando lista de Tcrs para nome: {}, cooperativa: {}", nome, cooperativa);
		return tcrRepository.findByDsNomeAndCdCooperativa(nome, cooperativa);
	}

	@Override
	public List<Tcr> buscarPorCooperativaEPosto(Integer cooperativa, Integer posto) {
		log.info("Buscando lista de Tcrs para cooperativa: {}, posto: {}", cooperativa, posto);
		return tcrRepository.findByCdCooperativaAndCdPosto(cooperativa, posto);
	}

	@Override
	public List<Tcr> buscarPorNomeCooperativaEPosto(String nome, Integer cooperativa, Integer posto) {
		log.info("Buscando lista de Tcrs para nome: {}, cooperativa: {}, posto: {}", nome, cooperativa, posto);
		return tcrRepository.findByDsNomeAndCdCooperativaAndCdPosto(nome, cooperativa, posto);
	}
	
	@Override
	public Optional<Tcr> buscarPorId(Long id) {
		log.info("Buscando TCR com ID: {}", id);
		return tcrRepository.findById(id);
	}

	@Override
	public Tcr persistir(Tcr tcr) {
		log.info("Persistindo tcr: {}", tcr);
		return this.tcrRepository.save(tcr);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo um tcr com id: {}", id);
		this.tcrRepository.deleteById(id);
	}	
}

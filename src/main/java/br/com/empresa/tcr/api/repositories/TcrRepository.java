package br.com.empresa.tcr.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.tcr.api.entities.Tcr;

@Transactional(readOnly = true)
public interface TcrRepository extends JpaRepository<Tcr, Long> {
	
	List<Tcr> findByDsNomeAndCdCooperativa(String dsNome, Integer cdCooperativa);
	
	List<Tcr> findByCdCooperativaAndCdPosto(Integer cdCooperativa, Integer cdPosto);
	
	List<Tcr> findByDsNomeAndCdCooperativaAndCdPosto(String dsNome, Integer cdCooperativa, Integer cdPosto);
}

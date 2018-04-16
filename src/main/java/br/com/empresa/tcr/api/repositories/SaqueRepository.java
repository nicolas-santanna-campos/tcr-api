package br.com.empresa.tcr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.tcr.api.entities.Saque;

public interface SaqueRepository extends JpaRepository<Saque, Long>{

}

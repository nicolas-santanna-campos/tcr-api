package br.com.empresa.tcr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.tcr.api.entities.Suprimento;

public interface SuprimentoRepository extends JpaRepository<Suprimento, Long>{

}

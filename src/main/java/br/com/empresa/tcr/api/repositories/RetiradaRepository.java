package br.com.empresa.tcr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.tcr.api.entities.Retirada;

public interface RetiradaRepository extends JpaRepository<Retirada, Long>{

}

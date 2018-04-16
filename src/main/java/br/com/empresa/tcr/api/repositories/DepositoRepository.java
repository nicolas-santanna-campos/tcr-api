package br.com.empresa.tcr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.tcr.api.entities.Deposito;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {

}

package br.com.empresa.tcr.api.services;

import java.util.List;
import java.util.Optional;

import br.com.empresa.tcr.api.entities.Tcr;

public interface TcrService {

	/**
	 * Retorna uma lista de Tcrs dado um nome e cooperativa.
	 * 
	 * @param nome
	 * @param cooperativa
	 * @return List<Optional<Tcr>>
	 */
	List<Tcr> buscarPorNomeECooperativa(String nome, Integer cooperativa);
	
	/**
	 * Retorna uma lista de Tcrs dado uma cooperativa e um posto.
	 * 
	 * @param cooperativa
	 * @param posto
	 * @return List<Optional<Tcr>>
	 */
	List<Tcr> buscarPorCooperativaEPosto(Integer cooperativa, Integer posto);
	
	/**
	 * Retorna uma lista de Tcrs dado um nome, uma cooperativa e um posto.
	 * 
	 * @param nome
	 * @param cooperativa
	 * @param posto
	 * @return List<Optional<Tcr>>
	 */
	List<Tcr> buscarPorNomeCooperativaEPosto(String nome, Integer cooperativa, Integer posto);
	
	/**
	 * Retorna um TCR por ID
	 * 
	 * @param id
	 * @return
	 */
	Optional<Tcr> buscarPorId(Long id);
	
	/**
	 * Cadastra um novo Tcr na base de dados
	 * 
	 * @param tcr
	 * @return
	 */
	Tcr persistir(Tcr tcr);
	
	/**
	 * Remove um Tcr da base de dados
	 * 
	 * @param id
	 */
	void remover(Long id);
}

package br.com.empresa.tcr.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.tcr.api.dtos.CadastroTcrDto;
import br.com.empresa.tcr.api.dtos.TcrDto;
import br.com.empresa.tcr.api.entities.Tcr;
import br.com.empresa.tcr.api.response.Response;
import br.com.empresa.tcr.api.services.TcrService;
import br.com.empresa.tcr.api.utils.TcrUtil;

@RestController
@RequestMapping("/api/tcr")
@CrossOrigin(origins = "*")
public class TcrController {

	private static final Logger log = LoggerFactory.getLogger(TcrController.class);
	
	@Autowired
	private TcrService tcrService;
	
	public TcrController() {
		
	}
	
	/**
	 * Cadastra um novo TCR.
	 * 
	 * @param tcrDto
	 * @param result
	 * @return ResponseEntity<Response<TcrDto>>
	 * @throws Exception, NoSuchAlgorithmException 
	 */
	@PostMapping
	public ResponseEntity<Response<TcrDto>> cadastrar(@Valid @RequestBody CadastroTcrDto cadastroTcrDto,
			BindingResult result) throws Exception, NoSuchAlgorithmException {
		
		validarDadosExistentes(cadastroTcrDto, result);
		
		Response<TcrDto> response = new Response<TcrDto>();
				
		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro de TCR: {}", result.getAllErrors() );
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		log.info("Cadastrando TCR: {}", cadastroTcrDto.toString());
		
		Tcr tcr = TcrUtil.converterTcr(cadastroTcrDto);
		
		this.tcrService.persistir(tcr);
		response.setData(TcrUtil.converterTcrDto(tcr));
		
		return ResponseEntity.ok(response);
	}

	/**
	 * Busca um TCR por id.
	 * 
	 * @param id
	 * @return ResponseEntity<Response<TcrDto>>
	 * @throws Exception
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<TcrDto>> buscarPorId(@PathVariable("id") Long id) throws Exception {
		log.info("Buscando TCR por ID: {}", id);
		
		Response<TcrDto> response = new Response<TcrDto>();
	    Optional<Tcr> tcr = this.tcrService.buscarPorId(id);
	    
	    if(!tcr.isPresent()) {
	    	log.info("Tcr não encontrado para o ID: {}", id);
	    	response.getErrors().add("Tcr não encontrado para o ID: " + id);
	    	return ResponseEntity.badRequest().body(response);
	    }
	    
	    response.setData(TcrUtil.converterTcrDto(tcr.get()));
	    return ResponseEntity.ok(response);
	}
	
	/**
	 * Busca uma lista de TCRs por nome e cooperativa.
	 * 
	 * @param nome
	 * @param cooperativa
	 * @return ResponseEntity<Response<List<TcrDto>>>
	 * @throws Exception
	 */
	@GetMapping(value = "/{dsNome}/{cdCooperativa}")
	public ResponseEntity<Response<List<TcrDto>>> buscarPorNomeECooperativa(@PathVariable("dsNome") String nome,
																			@PathVariable("cdCooperativa") Integer cooperativa) throws Exception {
		log.info("Buscando TCR por nome: {}, cooperativa: {}", nome, cooperativa);
		
		Response<List<TcrDto>> response = new Response<List<TcrDto>>();
		List<Tcr> tcrList 		  		= this.tcrService.buscarPorNomeECooperativa(nome, cooperativa);
		
		if(tcrList.isEmpty()) {
			log.info("Nenhum TCR encontrado para nome: {}, cooperativa: {}", nome, cooperativa);
			response.getErrors().add("Nenhum TCR encontrado para nome: [" + nome + "] cooperativa: [" + cooperativa + "]");
			return ResponseEntity.badRequest().body(response);
		}
		
		List<TcrDto> tcrDtoList = new ArrayList<TcrDto>();
		
		for(int i = 0; i < tcrList.size(); i++) {
			Tcr tcr = new Tcr();
			tcr = tcrList.get(i);
			tcrDtoList.add(TcrUtil.converterTcrDto(tcr));
		}
		
		response.setData(tcrDtoList);
		return ResponseEntity.ok(response);
	}
	

	/**
	 * Verifica se já existe cadastrado um TCR com os mesmos dados.
	 * 
	 * @param cadastroTcrDto
	 * @param result
	 */
	private void validarDadosExistentes(CadastroTcrDto cadastroTcrDto, BindingResult result) {
		List<Tcr> tcrList = this.tcrService.buscarPorNomeCooperativaEPosto(cadastroTcrDto.getDsNome(), 
													   cadastroTcrDto.getCdCooperativa(),
													   cadastroTcrDto.getCdPosto());
		if (!tcrList.isEmpty()) {
			result.addError(new ObjectError("tcr", "Tcr com os mesmos dados já cadastrado"));
		}
		
	}
	
}

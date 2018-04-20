package br.com.empresa.tcr.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.tcr.api.dtos.TcrDto;
import br.com.empresa.tcr.api.entities.Tcr;
import br.com.empresa.tcr.api.response.Response;
import br.com.empresa.tcr.api.services.TcrService;
import br.com.empresa.tcr.api.utils.TcrUtil;

@RestController
@RequestMapping("/api/cadastrar-tcr")
@CrossOrigin(origins = "*")
public class CadastroTcrController {

	private static final Logger log = LoggerFactory.getLogger(CadastroTcrController.class);
	
	@Autowired
	private TcrService tcrService;
	
	public CadastroTcrController() {
		
	}
	
	/**
	 * Cadastra um novo TCR
	 * 
	 * @param cadastroTcrDto
	 * @param result
	 * @return ResponseEntity<Response<TcrDto>>
	 * @throws Exception, NoSuchAlgorithmException 
	 */
	@PostMapping
	public ResponseEntity<Response<TcrDto>> cadastrar(@Valid @RequestBody TcrDto cadastroTcrDto,
			BindingResult result) throws Exception, NoSuchAlgorithmException {
		
		log.info("Cadastrando TCR: {}", cadastroTcrDto.toString());
		
		Response<TcrDto> response = new Response<TcrDto>();
		
		validarDadosExistentes(cadastroTcrDto, result);
		Tcr tcr = TcrUtil.obterTcr(cadastroTcrDto);
		
		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro de TCR: {}", result.getAllErrors() );
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.tcrService.persistir(tcr);
		response.setData(TcrUtil.obterTcrDto(tcr));
		
		return ResponseEntity.ok(response);
	}

	

	/**
	 * Verifica se já existe cadastrado um TCR com os mesmos dados.
	 * 
	 * @param cadastroTcrDto
	 * @param result
	 */
	private void validarDadosExistentes(TcrDto cadastroTcrDto, BindingResult result) {
		List<Tcr> tcrList = this.tcrService.buscarPorNomeCooperativaEPosto(cadastroTcrDto.getDsNome(), 
													   cadastroTcrDto.getCdCooperativa(),
													   cadastroTcrDto.getCdPosto());
		if (!tcrList.isEmpty()) {
			result.addError(new ObjectError("tcr", "Tcr com os mesmos dados já cadastrado"));
		}
		
	}
	
}

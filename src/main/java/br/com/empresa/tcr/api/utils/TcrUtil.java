package br.com.empresa.tcr.api.utils;

import java.util.Date;

import br.com.empresa.tcr.api.dtos.CadastroTcrDto;
import br.com.empresa.tcr.api.dtos.DepositoDto;
import br.com.empresa.tcr.api.dtos.RetiradaDto;
import br.com.empresa.tcr.api.dtos.SaqueDto;
import br.com.empresa.tcr.api.dtos.SuprimentoDto;
import br.com.empresa.tcr.api.dtos.TcrDto;
import br.com.empresa.tcr.api.entities.Deposito;
import br.com.empresa.tcr.api.entities.Retirada;
import br.com.empresa.tcr.api.entities.Saque;
import br.com.empresa.tcr.api.entities.Suprimento;
import br.com.empresa.tcr.api.entities.Tcr;

public class TcrUtil {

	/**
	 * Converte um {@link TcrDto} para uma entidade {@link Tcr}.
	 * 
	 * @param tcrDto
	 * @return Tcr
	 * @throws Exception
	 */
	public static Tcr converterTcr(TcrDto tcrDto) throws Exception {
		
		Date dataincAlt = new Date();
		
		Deposito   deposito   = converterDepositoDtoParaDeposito(tcrDto, dataincAlt);
		Retirada   retirada   = converterRetiradaDtoParaRetirada(tcrDto, dataincAlt);
		Saque 	   saque 	  = converterSaqueDtoParaSaque(tcrDto, dataincAlt);
		Suprimento suprimento = converterSuprimentoDtoParaSuprimento(tcrDto, dataincAlt);
		
		Tcr tcr = new Tcr();
		
		tcr.setDsNome(tcrDto.getDsNome());
		tcr.setCdPosto(tcrDto.getCdPosto());
		tcr.setCdCooperativa(tcrDto.getCdCooperativa());
		tcr.setIdTesoureiroAtivo(tcrDto.getIdTesoureiroAtivo());
		tcr.setCdUsuarioAlt(tcrDto.getCdUsuarioAlt());
		tcr.setDtInclusao(dataincAlt);
		tcr.setDtAlteracao(dataincAlt);
		tcr.setIdLimiteExcedidoAutorizaTesoureiro(tcrDto.getIdLimiteExcedidoAutorizaTesoureiro());
		tcr.setDeposito(deposito);
		tcr.setRetirada(retirada);
		tcr.setSaque(saque);
		tcr.setSuprimento(suprimento);
		return tcr;
	}
	
	private static Deposito converterDepositoDtoParaDeposito(TcrDto tcrDto, Date data) throws Exception {
		Deposito   deposito   = new Deposito();
		deposito.setIdAtivo(tcrDto.getDepositoDto().getIdAtivo());
		deposito.setVlMaxDiario(tcrDto.getDepositoDto().getVlMaxDiario());
		deposito.setVlMaxOperacao(tcrDto.getDepositoDto().getVlMaxOperacao());
		return deposito;
	}
	
	private static Retirada converterRetiradaDtoParaRetirada(TcrDto tcrDto, Date data) throws Exception {
		Retirada   retirada   = new Retirada();
		retirada.setIdAtivo(tcrDto.getRetiradaDto().getIdAtivo());
		retirada.setVlMaxDiario(tcrDto.getRetiradaDto().getVlMaxDiario());
		retirada.setVlMaxOperacao(tcrDto.getRetiradaDto().getVlMaxOperacao());
		return retirada;
	}
	
	private static Saque converterSaqueDtoParaSaque(TcrDto tcrDto, Date data) throws Exception  {
		Saque saque = new Saque();
		saque.setIdAtivo(tcrDto.getSaqueDto().getIdAtivo());
		saque.setVlMaxDiario(tcrDto.getSaqueDto().getVlMaxDiario());
		saque.setVlMaxOperacao(tcrDto.getSaqueDto().getVlMaxOperacao());
		saque.setIdExibeInventario(tcrDto.getSaqueDto().getIdExibeInventario());
		saque.setIdBalanceamentoCedulas(tcrDto.getSaqueDto().getIdBalanceamentoCedulas());
		return saque;
	}
	
	private static Suprimento converterSuprimentoDtoParaSuprimento(TcrDto tcrDto, Date data) throws Exception {
		Suprimento suprimento = new Suprimento();
		suprimento.setIdAtivo(tcrDto.getSuprimentoDto().getIdAtivo());
		suprimento.setVlMaxDiario(tcrDto.getSuprimentoDto().getVlMaxDiario());
		suprimento.setVlMaxOperacao(tcrDto.getSuprimentoDto().getVlMaxOperacao());
		suprimento.setIdExibeInventario(tcrDto.getSuprimentoDto().getIdExibeInventario());
		suprimento.setIdBalanceamentoCedulas(tcrDto.getSuprimentoDto().getIdBalanceamentoCedulas());
		return suprimento;
	}
	
	/**
	 * Converte um {@link TcrDto} para uma entidade {@link Tcr} .
	 * 
	 * @param cadastroTcrDto
	 * @return {@link Tcr}
	 * @throws Exception
	 */
	public static Tcr converterTcr(CadastroTcrDto cadastroTcrDto) throws Exception {
		Date dataincAlt = new Date();
		
		Deposito   deposito   = converterCadastroDepositoDtoParaDeposito(cadastroTcrDto, dataincAlt);
		Retirada   retirada   = converterCadastroRetiradaDtoParaRetirada(cadastroTcrDto, dataincAlt);
		Saque 	   saque 	  = converterCadastroSaqueDtoParaSaque(cadastroTcrDto, dataincAlt);
		Suprimento suprimento = converterCadastroSuprimentoDtoParaSuprimento(cadastroTcrDto, dataincAlt);
		
		Tcr tcr = new Tcr();
		
		tcr.setDsNome(cadastroTcrDto.getDsNome());
		tcr.setCdPosto(cadastroTcrDto.getCdPosto());
		tcr.setCdCooperativa(cadastroTcrDto.getCdCooperativa());
		tcr.setIdTesoureiroAtivo(cadastroTcrDto.getIdTesoureiroAtivo());
		tcr.setCdUsuarioAlt(cadastroTcrDto.getCdUsuarioAlt());
		tcr.setDtInclusao(dataincAlt);
		tcr.setDtAlteracao(dataincAlt);
		tcr.setIdLimiteExcedidoAutorizaTesoureiro(cadastroTcrDto.getIdLimiteExcedidoAutorizaTesoureiro());
		tcr.setDeposito(deposito);
		tcr.setRetirada(retirada);
		tcr.setSaque(saque);
		tcr.setSuprimento(suprimento);
		return tcr;
	}
	
	private static Deposito converterCadastroDepositoDtoParaDeposito(CadastroTcrDto cadastroTcrDto, Date data) throws Exception {
		Deposito   deposito   = new Deposito();
		deposito.setIdAtivo(cadastroTcrDto.getCadastroDepositoDto().getIdAtivo());
		deposito.setVlMaxDiario(cadastroTcrDto.getCadastroDepositoDto().getVlMaxDiario());
		deposito.setVlMaxOperacao(cadastroTcrDto.getCadastroDepositoDto().getVlMaxOperacao());
		return deposito;
	}
	
	private static Retirada converterCadastroRetiradaDtoParaRetirada(CadastroTcrDto cadastroTcrDto, Date data) throws Exception {
		Retirada   retirada   = new Retirada();
		retirada.setIdAtivo(cadastroTcrDto.getCadastroRetiradaDto().getIdAtivo());
		retirada.setVlMaxDiario(cadastroTcrDto.getCadastroRetiradaDto().getVlMaxDiario());
		retirada.setVlMaxOperacao(cadastroTcrDto.getCadastroRetiradaDto().getVlMaxOperacao());
		return retirada;
	}
	
	private static Saque converterCadastroSaqueDtoParaSaque(CadastroTcrDto cadastroTcrDto, Date data) throws Exception  {
		Saque saque = new Saque();
		saque.setIdAtivo(cadastroTcrDto.getCadastroSaqueDto().getIdAtivo());
		saque.setVlMaxDiario(cadastroTcrDto.getCadastroSaqueDto().getVlMaxDiario());
		saque.setVlMaxOperacao(cadastroTcrDto.getCadastroSaqueDto().getVlMaxOperacao());
		saque.setIdExibeInventario(cadastroTcrDto.getCadastroSaqueDto().getIdExibeInventario());
		saque.setIdBalanceamentoCedulas(cadastroTcrDto.getCadastroSaqueDto().getIdBalanceamentoCedulas());
		return saque;
	}
	
	private static Suprimento converterCadastroSuprimentoDtoParaSuprimento(CadastroTcrDto cadastroTcrDto, Date data) throws Exception {
		Suprimento suprimento = new Suprimento();
		suprimento.setIdAtivo(cadastroTcrDto.getCadastroSuprimentoDto().getIdAtivo());
		suprimento.setVlMaxDiario(cadastroTcrDto.getCadastroSuprimentoDto().getVlMaxDiario());
		suprimento.setVlMaxOperacao(cadastroTcrDto.getCadastroSuprimentoDto().getVlMaxOperacao());
		suprimento.setIdExibeInventario(cadastroTcrDto.getCadastroSuprimentoDto().getIdExibeInventario());
		suprimento.setIdBalanceamentoCedulas(cadastroTcrDto.getCadastroSuprimentoDto().getIdBalanceamentoCedulas());
		return suprimento;
	}
	
	/**
	 * Converte uma entidade {@link Tcr} para um {@link TcrDto}.
	 * 
	 * @param tcr
	 * @return TcrDto
	 * @throws Exception
	 */
	public static TcrDto converterTcrDto(Tcr tcr) throws Exception {
		
		DepositoDto   depositoDto   = converterDepositoParaDepositoDto(tcr);
		RetiradaDto   retiradaDto   = converterRetiradaParaRetiradaDto(tcr);
		SaqueDto 	  saqueDto 	  	= converterSaqueParaSaqueDto(tcr);
		SuprimentoDto suprimentoDto = converterSuprimentoParaSuprimentoDto(tcr);
		
		TcrDto tcrDto = new TcrDto();
		
		tcrDto.setId(tcr.getId());
		tcrDto.setDsNome(tcr.getDsNome());
		tcrDto.setCdPosto(tcr.getCdPosto());
		tcrDto.setCdCooperativa(tcr.getCdCooperativa());
		tcrDto.setIdTesoureiroAtivo(tcr.getIdTesoureiroAtivo());
		tcrDto.setCdUsuarioAlt(tcr.getCdUsuarioAlt());
		tcrDto.setDtInclusao(tcr.getDtInclusao());
		tcrDto.setDtAlteracao(tcr.getDtAlteracao());
		tcrDto.setIdLimiteExcedidoAutorizaTesoureiro(tcr.getIdLimiteExcedidoAutorizaTesoureiro());
		tcrDto.setSuprimentoDto(suprimentoDto);
		tcrDto.setRetiradaDto(retiradaDto);
		tcrDto.setDepositoDto(depositoDto);
		tcrDto.setSaqueDto(saqueDto);
		return tcrDto;
	}

	private static DepositoDto converterDepositoParaDepositoDto(Tcr tcr) throws Exception {
		DepositoDto depositoDto = new DepositoDto();
		depositoDto.setId(tcr.getDeposito().getId());
		depositoDto.setIdAtivo(tcr.getDeposito().getIdAtivo());
		depositoDto.setVlMaxDiario(tcr.getDeposito().getVlMaxDiario());
		depositoDto.setVlMaxOperacao(tcr.getDeposito().getVlMaxOperacao());
		return depositoDto;
	}
	
	private static RetiradaDto converterRetiradaParaRetiradaDto(Tcr tcr) throws Exception {
		RetiradaDto retiradaDto = new RetiradaDto();
		retiradaDto.setId(tcr.getRetirada().getId());
		retiradaDto.setIdAtivo(tcr.getRetirada().getIdAtivo());
		retiradaDto.setVlMaxDiario(tcr.getRetirada().getVlMaxDiario());
		retiradaDto.setVlMaxOperacao(tcr.getRetirada().getVlMaxOperacao());
		return retiradaDto;
	}

	private static SaqueDto converterSaqueParaSaqueDto(Tcr tcr) throws Exception {
		SaqueDto saqueDto = new SaqueDto();
		saqueDto.setId(tcr.getSaque().getId());
		saqueDto.setIdAtivo(tcr.getSaque().getIdAtivo());
		saqueDto.setIdExibeInventario(tcr.getSaque().getIdExibeInventario());
		saqueDto.setIdBalanceamentoCedulas(tcr.getSaque().getIdBalanceamentoCedulas());
		saqueDto.setVlMaxDiario(tcr.getSaque().getVlMaxDiario());
		saqueDto.setVlMaxOperacao(tcr.getSaque().getVlMaxOperacao());
		return saqueDto;
	}
	
	private static SuprimentoDto converterSuprimentoParaSuprimentoDto(Tcr tcr) throws Exception {
		SuprimentoDto suprimentoDto = new SuprimentoDto();
		suprimentoDto.setId(tcr.getSuprimento().getId());
		suprimentoDto.setIdAtivo(tcr.getSuprimento().getIdAtivo());
		suprimentoDto.setIdExibeInventario(tcr.getSuprimento().getIdExibeInventario());
		suprimentoDto.setIdBalanceamentoCedulas(tcr.getSuprimento().getIdBalanceamentoCedulas());
		suprimentoDto.setVlMaxDiario(tcr.getSuprimento().getVlMaxDiario());
		suprimentoDto.setVlMaxOperacao(tcr.getSuprimento().getVlMaxOperacao());
		return suprimentoDto;
	}
	
}

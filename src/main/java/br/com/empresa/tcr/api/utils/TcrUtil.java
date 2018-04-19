package br.com.empresa.tcr.api.utils;

import java.util.Date;

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

	public static Tcr obterTcr(TcrDto tcrDto) throws Exception {
		
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
		deposito.setCdUsuarioAlt(tcrDto.getDepositoDto().getCdUsuarioAlt());
		deposito.setDtInclusao(data);
		deposito.setDtAlteracao(data);
		
		return deposito;
	}
	
	private static Retirada converterRetiradaDtoParaRetirada(TcrDto tcrDto, Date data) throws Exception {
		Retirada   retirada   = new Retirada();
		retirada.setIdAtivo(tcrDto.getRetiradaDto().getIdAtivo());
		retirada.setVlMaxDiario(tcrDto.getRetiradaDto().getVlMaxDiario());
		retirada.setVlMaxOperacao(tcrDto.getRetiradaDto().getVlMaxOperacao());
		retirada.setCdUsuarioAlt(tcrDto.getRetiradaDto().getCdUsuarioAlt());
		retirada.setDtInclusao(data);
		retirada.setDtAlteracao(data);
		
		return retirada;
	}
	
	private static Saque converterSaqueDtoParaSaque(TcrDto tcrDto, Date data) throws Exception  {
		Saque saque = new Saque();
		saque.setIdAtivo(tcrDto.getSaqueDto().getIdAtivo());
		saque.setVlMaxDiario(tcrDto.getSaqueDto().getVlMaxDiario());
		saque.setVlMaxOperacao(tcrDto.getSaqueDto().getVlMaxOperacao());
		saque.setIdExibeInventario(tcrDto.getSaqueDto().getIdExibeInventario());
		saque.setIdBalanceamentoCedulas(tcrDto.getSaqueDto().getIdBalanceamentoCedulas());
		saque.setCdUsuarioAlt(tcrDto.getSaqueDto().getCdUsuarioAlt());
		saque.setDtInclusao(data);
		saque.setDtAlteracao(data);
		
		return saque;
	}
	
	private static Suprimento converterSuprimentoDtoParaSuprimento(TcrDto tcrDto, Date data) throws Exception {
		Suprimento suprimento = new Suprimento();
		suprimento.setIdAtivo(tcrDto.getSuprimentoDto().getIdAtivo());
		suprimento.setVlMaxDiario(tcrDto.getSuprimentoDto().getVlMaxDiario());
		suprimento.setVlMaxOperacao(tcrDto.getSuprimentoDto().getVlMaxOperacao());
		suprimento.setIdExibeInventario(tcrDto.getSuprimentoDto().getIdExibeInventario());
		suprimento.setIdBalanceamentoCedulas(tcrDto.getSuprimentoDto().getIdBalanceamentoCedulas());
		suprimento.setCdUsuarioAlt(tcrDto.getSuprimentoDto().getCdUsuarioAlt());
		suprimento.setDtInclusao(data);
		suprimento.setDtAlteracao(data);
		
		return suprimento;
	}
	
	public static TcrDto obterTcrDto(Tcr tcr) throws Exception {
		
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
		depositoDto.setCdUsuarioAlt(tcr.getDeposito().getCdUsuarioAlt());
		depositoDto.setDtInclusao(tcr.getDeposito().getDtInclusao());
		depositoDto.setDtAlteracao(tcr.getDeposito().getDtAlteracao());
		
		return depositoDto;
	}
	
	private static RetiradaDto converterRetiradaParaRetiradaDto(Tcr tcr) throws Exception {
		RetiradaDto retiradaDto = new RetiradaDto();
		retiradaDto.setId(tcr.getRetirada().getId());
		retiradaDto.setIdAtivo(tcr.getRetirada().getIdAtivo());
		retiradaDto.setVlMaxDiario(tcr.getRetirada().getVlMaxDiario());
		retiradaDto.setVlMaxOperacao(tcr.getRetirada().getVlMaxOperacao());
		retiradaDto.setCdUsuarioAlt(tcr.getRetirada().getCdUsuarioAlt());
		retiradaDto.setDtInclusao(tcr.getRetirada().getDtInclusao());
		retiradaDto.setDtAlteracao(tcr.getRetirada().getDtAlteracao());
		
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
		saqueDto.setCdUsuarioAlt(tcr.getSaque().getCdUsuarioAlt());
		saqueDto.setDtInclusao(tcr.getSaque().getDtInclusao());
		saqueDto.setDtAlteracao(tcr.getSaque().getDtAlteracao());
		
		return saqueDto;
	}
	
	private static SuprimentoDto converterSuprimentoParaSuprimentoDto(Tcr tcr) throws Exception {
		SuprimentoDto suprimentoDto = new SuprimentoDto();
		suprimentoDto.setId(tcr.getSuprimento().getId());
		suprimentoDto.setIdAtivo(tcr.getSuprimento().getIdAtivo());
		//suprimentoDto.set
		
		return suprimentoDto;
	}
}

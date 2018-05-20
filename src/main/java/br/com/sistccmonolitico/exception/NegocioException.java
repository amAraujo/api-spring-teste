package br.com.sistccmonolitico.exception;

import br.com.sistccmonolitico.enuns.MensagemEnum;
import br.com.sistccmonolitico.model.vo.MensagemNegocioVO;

public class NegocioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1411020631104491128L;

	private MensagemNegocioVO mensagemNegocioVO;
	
	public NegocioException(MensagemEnum mensagemEnum, String... campo){
		this.mensagemNegocioVO = new MensagemNegocioVO(mensagemEnum, campo);
	}
	
	public MensagemNegocioVO getMensagemNegocioVO(){
		return mensagemNegocioVO;
	}
	
	@Override
	public String getMessage() {
		return mensagemNegocioVO.getMensagem();
	}
}

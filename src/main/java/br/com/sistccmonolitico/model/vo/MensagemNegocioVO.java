package br.com.sistccmonolitico.model.vo;

import java.io.Serializable;

import br.com.sistccmonolitico.enums.MensagemEnum;
import br.com.sistccmonolitico.utils.ResourceMensagem;

public class MensagemNegocioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8356604302453017937L;
	
	public String codigo;
	public String mensagem;
	
	public MensagemNegocioVO(MensagemEnum mensagemEnum, String... campo) {
		this.codigo = mensagemEnum.getStatus();
		this.mensagem = getMensagem(mensagemEnum, campo);
	}
	
	private String getMensagem(MensagemEnum mensagemEnum, String... campo){
		if (campo.length > 0) {
			mensagem = ResourceMensagem.getMessage(mensagemEnum, campo);
		}else{
			mensagem = ResourceMensagem.getMessage(mensagemEnum);
		}
		return mensagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

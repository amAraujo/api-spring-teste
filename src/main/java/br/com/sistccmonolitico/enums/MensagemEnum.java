package br.com.sistccmonolitico.enums;

public enum MensagemEnum {
	USUARIO_NULO_VAZIO("0000","usuario.nulo.vazio"),
    NENHUM_PRODUTO_ADICIONADO("0001", "nenhum.produto.adicionado");
    
	
	public String status;
	public String mensagem;
	
	private MensagemEnum(String status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public String getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}

package br.com.sistccmonolitico.enuns;

public enum MensagemEnum {
	USUARIO_NAO_CADASTRADO("0000","usuario.nao.cadastrado"),
    NENHUM_PRODUTO_ADICIONADO("0001", "nenhum.produto.adicionado"),
    VENDA_NULL("0002", "venda.null");
    
	
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

package br.com.sistccmonolitico.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Venda {

	@Id
	public String id;
	public String descricao;
	public List<Produto> produtos;
	public Double valor;
	public String idUsuario;
	
}

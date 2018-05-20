package br.com.sistccmonolitico.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Produto {

	@Id
	private String id;
	private String nome;
	private String descricao;
	private Double peso;
	private Double valor;
	private Long quantidade;
	
}

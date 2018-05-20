package br.com.sistccmonolitico.services;

import java.util.List;

import br.com.sistccmonolitico.model.Produto;

public interface ProdutoService {

	Produto salvar(Produto produto);
	
	List<Produto> listar();
	
	Produto consultarPorId(String id);
	
}

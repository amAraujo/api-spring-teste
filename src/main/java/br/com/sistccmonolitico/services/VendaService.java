package br.com.sistccmonolitico.services;

import java.util.List;

import br.com.sistccmonolitico.model.Venda;

public interface VendaService {

	Venda salvar(Venda venda);
	
	List<Venda> listar();
	
}

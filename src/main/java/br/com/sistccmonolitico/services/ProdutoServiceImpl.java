package br.com.sistccmonolitico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistccmonolitico.model.Produto;
import br.com.sistccmonolitico.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public Produto salvar(Produto produto) {
		return repository.save(produto);
		
	}

	@Override
	public List<Produto> listar() {
		return repository.findAll();
		
	}

	@Override
	public Produto consultarPorId(String id) {
		Optional<Produto> optional = repository.findById(id); 
		return optional.get();
		
	}
}

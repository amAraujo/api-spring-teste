package br.com.sistccmonolitico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistccmonolitico.model.Usuario;
import br.com.sistccmonolitico.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
		
	}

	@Override
	public List<Usuario> listar() {
		return repository.findAll();
		
	}

	@Override
	public Usuario consultarPorId(String id) {
		return repository.findById(id).get();
		
	}
}

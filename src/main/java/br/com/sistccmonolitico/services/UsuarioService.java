package br.com.sistccmonolitico.services;

import java.util.List;
import java.util.Optional;

import br.com.sistccmonolitico.model.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);
	
	List<Usuario> listar();
	
	Optional<Usuario> consultarPorId(String id);
	
}

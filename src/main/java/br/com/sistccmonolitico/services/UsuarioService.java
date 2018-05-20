package br.com.sistccmonolitico.services;

import java.util.List;

import br.com.sistccmonolitico.model.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);
	
	List<Usuario> listar();
	
	Usuario consultarPorId(String id);
	
}

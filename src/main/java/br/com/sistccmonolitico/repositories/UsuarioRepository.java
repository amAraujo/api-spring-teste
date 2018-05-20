package br.com.sistccmonolitico.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sistccmonolitico.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}

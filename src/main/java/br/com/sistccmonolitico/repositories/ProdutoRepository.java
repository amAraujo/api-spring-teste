package br.com.sistccmonolitico.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sistccmonolitico.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
}

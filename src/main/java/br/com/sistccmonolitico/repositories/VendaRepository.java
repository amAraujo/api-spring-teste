package br.com.sistccmonolitico.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.sistccmonolitico.model.Venda;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {
}

package br.com.sistccmonolitico.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistccmonolitico.exception.NegocioException;
import br.com.sistccmonolitico.model.Produto;
import br.com.sistccmonolitico.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Produto produto) {
		try {
			return new ResponseEntity<>(service.salvar(produto), HttpStatus.CREATED);
			
		} catch (NegocioException e) {
			return new ResponseEntity<>(e.getMensagemNegocioVO(), HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarPorId(@PathVariable("id") String id) {
		return new ResponseEntity<>(service.consultarPorId(id), HttpStatus.OK);
		
	}
}

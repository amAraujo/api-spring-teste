package br.com.sistccmonolitico.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistccmonolitico.model.Venda;
import br.com.sistccmonolitico.services.VendaService;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

	@Autowired
	private VendaService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Venda venda) {
		return new ResponseEntity<>(service.salvar(venda), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
		
	}
}

package br.com.sistccmonolitico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistccmonolitico.enums.MensagemEnum;
import br.com.sistccmonolitico.exception.NegocioException;
import br.com.sistccmonolitico.model.Venda;
import br.com.sistccmonolitico.repositories.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Override
	public Venda salvar(Venda venda) {
		validarVenda(venda);
		return repository.save(venda);

	}

	private void validarVenda(Venda venda) {
		if(venda.getProdutos().isEmpty()) {
			throw new NegocioException(MensagemEnum.NENHUM_PRODUTO_ADICIONADO);
		}
		if("".equalsIgnoreCase(venda.getIdUsuario()) || venda.getIdUsuario() == null) {
			throw new NegocioException(MensagemEnum.USUARIO_NULO_VAZIO);
		}
	}

	@Override
	public List<Venda> listar() {
		return repository.findAll();
		
	}
}

package br.com.sistccmonolitico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistccmonolitico.enuns.MensagemEnum;
import br.com.sistccmonolitico.exception.NegocioException;
import br.com.sistccmonolitico.model.Usuario;
import br.com.sistccmonolitico.model.Venda;
import br.com.sistccmonolitico.repositories.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private UsuarioService servicoUsuario;
	
	@Override
	public Venda salvar(Venda venda) {
		Usuario usuario = servicoUsuario.consultarPorId(venda.getIdUsuario());
		if (usuario == null) {
			throw new NegocioException(MensagemEnum.USUARIO_NAO_CADASTRADO);
		
		}
		if(venda.getProdutos().isEmpty()) {
			throw new NegocioException(MensagemEnum.NENHUM_PRODUTO_ADICIONADO);
		}
		
		return repository.save(venda);

	}

	@Override
	public List<Venda> listar() {
		return repository.findAll();
		
	}
}
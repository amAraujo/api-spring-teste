package br.com.sistccmonolitico.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.sistccmonolitico.model.Produto;
import br.com.sistccmonolitico.model.Usuario;
import br.com.sistccmonolitico.model.Venda;
import br.com.sistccmonolitico.repositories.UsuarioRepository;
import br.com.sistccmonolitico.repositories.VendaRepository;

@MockBean
@RunWith(MockitoJUnitRunner.class)
public class VendaTest {

	private static final Double VALOR = new Double(100);

	private static final String ID_USUARIO = "1";

	private static final String ID = "1";

	private static final String DESCRICAO = "Descricao";

	private static final String NOME_PRODUTO = "nomeProduto";

	private static final String ID_PRODUTO = "1";

	private static final String NOME_USUARIO = null;

	@Mock
	private VendaRepository repositoryMock;

	@Mock
	private UsuarioRepository repositoryUsuarioMock;
	
	@InjectMocks
	private VendaServiceImpl vendaServiceImpl;
	
	private Venda vendaMock;
	
	private List<Venda> listVendaMock;
	
	private Usuario usuarioMock;
	
	private Optional<Usuario> optionalUsuarioMock;
	
	@SuppressWarnings("static-access")
	@Before
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
		
		Produto produto = new Produto();
		produto.setId(ID_PRODUTO);
		produto.setNome(NOME_PRODUTO);
		
		List<Produto> listProdutoMock = new ArrayList<>();
		listProdutoMock.add(produto);
		
		vendaMock = new Venda();
		vendaMock.setDescricao(DESCRICAO);
		vendaMock.setId(ID);
		vendaMock.setIdUsuario(ID_USUARIO);
		vendaMock.setProdutos(listProdutoMock);
		vendaMock.setValor(VALOR);
		
		usuarioMock = new Usuario();
		usuarioMock.setId(ID_USUARIO);
		usuarioMock.setNome(NOME_USUARIO);
		
		optionalUsuarioMock = optionalUsuarioMock.of(usuarioMock);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void cadastrarVendaNull() {
		Mockito.when(repositoryUsuarioMock.findById(Mockito.anyString())).thenReturn(optionalUsuarioMock);
		Mockito.when(repositoryMock.save(Mockito.any(Venda.class))).thenReturn(vendaMock);
		vendaServiceImpl.salvar(null);
	}

	@Test
	public void realizarVenda() {
		Mockito.when(repositoryUsuarioMock.findById(Mockito.anyString())).thenReturn(optionalUsuarioMock);
		Mockito.when(repositoryMock.save(Mockito.any(Venda.class))).thenReturn(vendaMock);
		Assert.assertEquals(vendaServiceImpl.salvar(vendaMock), vendaMock);
		
	}

	@Test
	public void listarVendas() {
		Mockito.when(repositoryMock.findAll()).thenReturn(listVendaMock);
		Assert.assertEquals(vendaServiceImpl.listar(), listVendaMock);
		
	}
}

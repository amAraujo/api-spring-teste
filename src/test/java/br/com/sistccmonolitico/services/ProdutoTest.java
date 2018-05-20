package br.com.sistccmonolitico.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import br.com.sistccmonolitico.repositories.ProdutoRepository;
import junit.framework.Assert;

@MockBean
@RunWith(MockitoJUnitRunner.class)
public class ProdutoTest {

	private static final Double VALOR = new Double(100);

	private static final Long QTD = 10L;

	private static final Double PESO = new Double(10);

	private static final String NOME = "NomeProduto";

	private static final String DESCRICAO = "DescricaoProduto";

	private static final String ID = "1";

	@Mock
	private ProdutoRepository repositoryMock;
	
	@InjectMocks
	private ProdutoServiceImpl serviceMock;
	
	private Produto produtoMock;

	private List<Produto> listProdutoMock;
	
	private Optional<Produto> optionalProdutoMock;
	
	@Before
	public void inicializeMockito() {
		MockitoAnnotations.initMocks(this);
		
		produtoMock = new Produto();
		produtoMock.setId(ID);
		produtoMock.setDescricao(DESCRICAO);
		produtoMock.setNome(NOME);
		produtoMock.setPeso(PESO);
		produtoMock.setQuantidade(QTD);
		produtoMock.setValor(VALOR);
		
		listProdutoMock = new ArrayList<>();
		listProdutoMock.add(produtoMock);
		
		optionalProdutoMock = optionalProdutoMock.of(produtoMock);
		
	}
	
	@Test
	public void cadastrarProduto() {
		when(repositoryMock.save(Mockito.any(Produto.class))).thenReturn(produtoMock);
		Assert.assertEquals(serviceMock.salvar(produtoMock), produtoMock);
		
	}
	
	@Test
	public void listarUsuarios() {
		when(repositoryMock.findAll()).thenReturn(listProdutoMock);
		Assert.assertEquals(serviceMock.listar().size(), listProdutoMock.size());
		
	}
	
	@Test
	public void consultarPorId() {
		when(repositoryMock.findById(Mockito.anyString())).thenReturn(optionalProdutoMock);
		Assert.assertEquals(serviceMock.consultarPorId(produtoMock.getId()), optionalProdutoMock.get());
	}
	
}

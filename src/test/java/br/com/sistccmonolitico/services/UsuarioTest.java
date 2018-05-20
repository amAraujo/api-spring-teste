package br.com.sistccmonolitico.services;

import static org.mockito.Mockito.when;

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

import br.com.sistccmonolitico.model.Usuario;
import br.com.sistccmonolitico.repositories.UsuarioRepository;

@MockBean
@RunWith(MockitoJUnitRunner.class)
public class UsuarioTest {
	
	private final static String NOME = "nomeUsuario";

	private static final String ID = "1";

	@Mock
	private UsuarioRepository repositoryMock;
	
	@InjectMocks
	private UsuarioServiceImpl serviceMock;
	
	private Usuario usuarioMock;

	private Optional<Usuario> optionalUsuarioMock;
	
	private List<Usuario> listUsuarioMock;
	
	@Before
	public void inicializeMockito() {
		MockitoAnnotations.initMocks(this);
		
		usuarioMock = new Usuario();
		usuarioMock.setId(ID);
		usuarioMock.setNome(NOME);
		
		listUsuarioMock = new ArrayList<>();
		listUsuarioMock.add(usuarioMock);
		
		optionalUsuarioMock = optionalUsuarioMock.of(usuarioMock);
		
	}
	
	@Test
	public void cadastrarUsuario() {
		when(repositoryMock.save(Mockito.any(Usuario.class))).thenReturn(usuarioMock);
		Assert.assertEquals(serviceMock.salvar(usuarioMock), usuarioMock);
		
	}
	
	@Test
	public void listarUsuarios() {
		when(repositoryMock.findAll()).thenReturn(listUsuarioMock);
		Assert.assertEquals(serviceMock.listar().size(), listUsuarioMock.size());
		
	}
	
	@Test
	public void consultarPorId() {
		when(repositoryMock.findById(Mockito.anyString())).thenReturn(optionalUsuarioMock);
		Assert.assertEquals(serviceMock.consultarPorId(usuarioMock.getId()), optionalUsuarioMock.get());
	}
}

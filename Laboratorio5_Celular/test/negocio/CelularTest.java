package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import negocio.Celular;
import negocio.Contato;

public class CelularTest {
	private Celular celular;
	private Contato c1, c2, c3;
	private String s1, s2;
	
	@Before
	public void inicializa() {
		celular = new Celular();
	}
	
	private void cadastraContatos() {
		c1 = new Contato("992348938","Guilherme");
		c2 = new Contato("989328293","Felipe");
		c3 = new Contato("929283943","Vitor");
		celular.cadastrarContato(c1);
		celular.cadastrarContato(c2);
		celular.cadastrarContato(c3);
	}
	
	private void cadastraChamadas() {
		s1 = "918283912";
		s2 = "929283943";
		celular.cadastrarChamada(s1);
		celular.cadastrarChamada(s2);
	}
	
	@Test
	public void testCadastrarContato() {
		cadastraContatos();
		assertEquals(3,celular.getContatos().size());
		assertTrue(celular.getContatos().contains(c2));
	}
	
	@Test
	public void testRemoverContato() {
		cadastraContatos();
		celular.removerContato(c1);
		assertEquals(2,celular.getContatos().size());
		assertFalse(celular.getContatos().contains(c1));
	}

	@Test
	public void testCadastrarChamada() {
		cadastraChamadas();
		assertEquals(2,celular.getChamadas().size());
		assertTrue(celular.getChamadas().contains(s2));
	}
	
	@Test
	public void testExcluirChamadas() {
		cadastraChamadas();
		celular.excluirChamadas();
		assertEquals(0,celular.getChamadas().size());
		assertFalse(celular.getChamadas().contains(s1));
	}
	
	@Test
	public void testMostraChamadas() {
		cadastraContatos();
		cadastraChamadas();
		assertEquals("\n918283912\nVitor 929283943",celular.mostraChamadas());
	}
	
}

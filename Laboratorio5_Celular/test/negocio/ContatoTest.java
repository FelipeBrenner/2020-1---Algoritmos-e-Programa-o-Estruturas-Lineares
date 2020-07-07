package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

import negocio.Contato;

public class ContatoTest {

	@Test
	public void testCadastroContato() {
		Contato c = new Contato("992348938","Guilherme");
		assertEquals("992348938",c.getNumero());
		assertEquals("Guilherme",c.getNome());
	}

}

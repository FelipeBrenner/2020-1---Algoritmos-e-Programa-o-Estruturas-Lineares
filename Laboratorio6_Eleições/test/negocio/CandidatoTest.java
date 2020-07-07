package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandidatoTest {

	@Test
	public void test() {
		Candidato c = new Candidato("Lucas","PT",30,849);
		assertEquals("Lucas",c.getNome());
		assertEquals("PT",c.getPartido());
		assertEquals(30,c.getIdade());
		assertEquals(849,c.getVotos());
	}

}

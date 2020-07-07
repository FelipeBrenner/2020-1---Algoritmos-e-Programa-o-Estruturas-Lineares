package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class DisciplinaTest {
	private Disciplina d1, d2;
	
	@Before
	public void inicializa() {
		d1 = new Disciplina(3412,"Matemática");
		d2 = new Disciplina(1111,"Português");
	}
	
	@Test
	public void testCadastro() {
		assertEquals(3412,d1.getCodigo());
		assertEquals("Matemática",d1.getNome());
	}
	
	@Test
	public void testCompare() {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(d1);
		disciplinas.add(d2);
		Collections.sort(disciplinas);
		assertEquals(disciplinas.get(0),d2);
		assertEquals(disciplinas.get(1),d1);
	}

}

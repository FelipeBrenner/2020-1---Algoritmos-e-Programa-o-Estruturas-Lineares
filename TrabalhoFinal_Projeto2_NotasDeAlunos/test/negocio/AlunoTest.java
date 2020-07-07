package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	private Aluno a1, a2;
	
	@Before
	public void inicializa() {
		a1 = new Aluno(8928,"Felipe");
		a2 = new Aluno(3333,"Gustavo");
	}
	
	@Test
	public void testCadastro() {
		assertEquals(8928,a1.getCodigo());
		assertEquals("Felipe",a1.getNome());
	}
	
	@Test
	public void testCompare() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(a1);
		alunos.add(a2);
		Collections.sort(alunos);
		assertEquals(alunos.get(0),a2);
		assertEquals(alunos.get(1),a1);
	}
	
}

package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CursoTest {
	private Curso c;
	private Aluno a;
	private Disciplina d1, d2;
	private NotasAlunoDisciplina n1, n2;
	
	@Before
	public void inicializa() {
		c = new Curso();
		a = new Aluno(8928,"Felipe");
		d1 = new Disciplina(3412,"Matemática");
		d2 = new Disciplina(2832,"Português");
		n1 = new NotasAlunoDisciplina(8928,3412);
		n2 = new NotasAlunoDisciplina(8928,2832);
	}
	
	public void inserirAlunoDisciplina() {
		c.inserirAluno(a);
		c.inserirDisciplina(d1);
		c.inserirDisciplina(d2);
		c.vincularDisciplinaAluno(a.getCodigo(), d1.getCodigo());
		c.vincularDisciplinaAluno(a.getCodigo(), d2.getCodigo());
	}
	
	@Test
	public void testInserirAluno() {
		inserirAlunoDisciplina();
		assertEquals(a,c.getAluno(8928));
	}
	
	@Test 
	public void testInserirDisciplina() {
		inserirAlunoDisciplina();
		assertEquals(d1,c.getDisciplina(3412));
		assertEquals(d2,c.getDisciplina(2832));
	}
	
	@Test
	public void testVincularDisciplinaAluno() {
		inserirAlunoDisciplina();
		System.out.println(n2);
		assertEquals(n1.getCodigoAluno(),c.getNotas().get(0).getCodigoAluno());
		assertEquals(n2.getCodigoDisciplina(),c.getNotas().get(0).getCodigoDisciplina());
	}
	
	@Test 
	public void testCalcularMedia() {
		inserirAlunoDisciplina();
		c.getVinculo(8928,3412).setNota1(9);
		c.getVinculo(8928,3412).setNota2(6);
		c.calcularMedia();
		assertEquals("7.5",String.valueOf(c.getVinculo(8928,3412).getMediaAritmetica()));
		assertEquals("7.0",String.valueOf(c.getVinculo(8928,3412).getMediaPonderada()));
	}

}

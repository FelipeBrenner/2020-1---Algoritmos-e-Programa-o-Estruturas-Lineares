package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class NotasAlunoDisciplinaTest {
	Aluno a1, a2;
	Disciplina d1, d2;
	NotasAlunoDisciplina n1, n2, n3, n4;
	
	@Before
	public void inicializa() {
		a1 = new Aluno(1,"Felipe Brenner");
		a2 = new Aluno(2,"Vitor Soares");
		
		d1 = new Disciplina(1,"Português");
		d2 = new Disciplina(2,"Matemática");
		
		n1 = new NotasAlunoDisciplina(1,1,9.0,6.0);
		n2 = new NotasAlunoDisciplina(1,2,6.0,8.0);
		n3 = new NotasAlunoDisciplina(2,1,10.0,7.5);
		n4 = new NotasAlunoDisciplina(2,2,9.5,5.5);
	}
	
	@Test
	public void testCompare() {
		ArrayList<NotasAlunoDisciplina> notas = new ArrayList<NotasAlunoDisciplina>();
		notas.add(n3);
		notas.add(n1);
		notas.add(n2);
		notas.add(n4);
		Collections.sort(notas);
		assertEquals(notas.get(0),n1);
		assertEquals(notas.get(1),n2);
		assertEquals(notas.get(2),n3);
		assertEquals(notas.get(3),n4);
	}
	
	@Test
	public void testNotas() {
		assertEquals("9.0",String.valueOf(n1.getNota1()));
		assertEquals("8.0",String.valueOf(n2.getNota2()));
		assertEquals("7.5",String.valueOf(n3.getNota2()));
		assertEquals("9.5",String.valueOf(n4.getNota1()));
	}
	
	@Test
	public void testMediaAritmetica() {
		n1.calculaMediaAritmetica();
		n2.calculaMediaAritmetica();
		n3.calculaMediaAritmetica();
		n4.calculaMediaAritmetica();
		assertEquals("7.5",String.valueOf(n1.getMediaAritmetica()));
		assertEquals("7.0",String.valueOf(n2.getMediaAritmetica()));
		assertEquals("8.75",String.valueOf(n3.getMediaAritmetica()));
		assertEquals("7.5",String.valueOf(n4.getMediaAritmetica()));
	}
	
	@Test
	public void testMediaPonderada() {
		n1.calculaMediaPonderada();
		n2.calculaMediaPonderada();
		n3.calculaMediaPonderada();
		n4.calculaMediaPonderada();
		assertEquals("7.0",String.valueOf(n1.getMediaPonderada()));
		assertEquals("7.33",String.format("%.4s",String.valueOf(n2.getMediaPonderada())));
		assertEquals("8.33",String.format("%.4s",String.valueOf(n3.getMediaPonderada())));
		assertEquals("6.83",String.format("%.4s",String.valueOf(n4.getMediaPonderada())));
	}

}

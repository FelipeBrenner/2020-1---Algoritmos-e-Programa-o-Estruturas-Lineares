package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EleicoesTest {
	private Eleicoes eleicoes;
	
	@Before
	public void inicializa() {
		eleicoes = new Eleicoes();
//		Candidatos já adicionados por hard code no construtor da classe Eleicoes
//		lista.add(new Candidato("Lucas","PT",30,1532));
//		lista.add(new Candidato("Pedro","PSOL",40,342));
//		lista.add(new Candidato("Ana","NOVO",29,1234));
//		lista.add(new Candidato("Gustavo","PMDB",35,250));
	}
	
	@Test
	public void testMaisJovem() {
		assertEquals("Ana",eleicoes.retornaMaisJovem().getNome());
	}
	
	@Test
	public void testMaisVelho() {
		assertEquals("Pedro",eleicoes.retornaMaisVelho().getNome());
	}
	
	@Test
	public void testMaisVotado() {
		assertEquals("Lucas",eleicoes.retornaMaisVotado().getNome());
	}
	
	@Test
	public void testMenosVotado() {
		assertEquals("Gustavo",eleicoes.retornaMenosVotado().getNome());
	}

	@Test
	public void testTotalVotos() {
		assertEquals(3358,eleicoes.retornaTotalVotos());
	}
	
	@Test
	public void testMediaVotacao() {
		assertEquals("839.5",String.valueOf(eleicoes.retornaMediaVotacao()));
	}
	
}

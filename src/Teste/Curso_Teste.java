package Teste;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import TO.TO_Curso;

public class _Matricula_Teste {
	TO_Curso to;

	@Before
	public void setUp() throws Exception {
		to = new TO_Curso();
		to.setCodigo(1);
		to.setNomeCurso("Informatica");
		to.setDataInicio("17/01/2016");
		to.setDataFim("18/02/2016");
		to.setHorario("11:00 as 15:00");
		to.setNumeroVagas(10);
		to.getValor(20);
		to.setLabSala(2);
		to.setDescricao("Aula Pratica");
		to.setMatSoftwares("Livros");
		to.setArea("Informática");

	}

	@Test
	public void testGets() {
		assertEquals("getCodigo", to.getCodigo(), 1);
		assertEquals("getNomeCurso", to.getNomeCurso(), "Informatica");
		assertEquals("getDataInicio", to.getDataInicio(), "17/01/2016");
		assertEquals("getDataFim", to.getDataFim(), "18/02/2016");
		assertEquals("getHorario", to.getHorario(), "11:00 as 15:00");
		assertEquals("getNumeroVagas", to.getNumeroVagas(), 10);
		assertEquals(20, to.getValor(), 20);
		assertEquals("getLabSala", to.getLabSala(), 2);
		assertEquals("getDescricao", to.getDescricao(), "Aula Pratica");
		assertEquals("getLivros, to.getMatSofwares, "Livros");
	   assertEquals("getArea", to.getArea(), "Informatica");

	}



}

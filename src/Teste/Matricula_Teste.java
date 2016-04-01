package Teste;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import TO.TO_Matricula;;

public class Matricula_Teste {
	TO_Matricula to;

	@Before
	public void setUp() throws Exception {
		to = new TO_Matricula();
		to.setMatricula(1);
		to.setDataMatricula("19/02/2018");
		to.setCodigoCurso(2);
		to.setValor(100);
		to.setRaAluno(2);
		to.setStatusMatricula("P");
		to.setStatusFinanceiro("R");

	}

	@Test
	public void testGets() {
		assertEquals("getMatricula", to.getMatricula(), 1);
		assertEquals("getDataMatricula", to.getDataMatricula(), "19/02/2018");
		assertEquals("getCodigoCurso", to.getCodigoCurso(), 2);
		assertEquals(100, to.getValor(), 100);
		assertEquals("getRaAluno", to.getRaAluno(), 2);
		assertEquals("getStatusMatricula", to.getStatusMatricula(), "P");
		assertEquals("getStatusFinanceiro", to.getStatusFinanceiro(), "R");

	}

	@Test
	public void testEquals() {

		TO_Matricula copia = new TO_Matricula();
		copia.setMatricula(to.getMatricula());
		copia.setDataMatricula(to.getDataMatricula());
		copia.setCodigoCurso(to.getCodigoCurso());
		copia.setValor(to.getValor());
		copia.setRaAluno(to.getRaAluno());
		copia.setStatusMatricula(to.getStatusMatricula());
		copia.setStatusFinanceiro(to.getStatusFinanceiro());
		
	}

}

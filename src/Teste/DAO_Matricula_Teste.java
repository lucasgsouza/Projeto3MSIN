package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.tools.Tool;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import TO.TO_Matricula;
import DAO.DAO_Matricula;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DAO_Matricula_Teste {
	DAO_Matricula dao;
	TO_Matricula to;

	@Before
	public void setUp() throws Exception {
		dao = new DAO_Matricula();
		to = new TO_Matricula();
		to.setMatricula(13);
		to.setDataMatricula("17/10/2013");
		to.setCodigoCurso(2);
		to.setValor(100);
		to.setRaAluno(2);
		to.setStatusMatricula("P");
		to.setStatusFinanceiro("R");
	}

	@Test
	public void testInserir() {
		dao.Insert(to);
		
		assertEquals("getMatricula", to.getMatricula(), 13);
		assertEquals("getDataMatricula", to.getDataMatricula(), "17/10/2013");
		assertEquals("getCodigoCurso", to.getCodigoCurso(), 2);
		assertEquals(100, to.getValor(), 100);
		assertEquals("getRaAluno", to.getRaAluno(), 2);
		assertEquals("getStatusMatricula", to.getStatusMatricula(), "P");
		assertEquals("getStatusFinanceiro", to.getStatusFinanceiro(), "R");
		
		
		

	}

	@Test
	public void testAlterar() {

			to.setDataMatricula("19/02/2018");
			TO_Matricula copia = dao.Consultar(to.getMatricula());
			copia.setDataMatricula("19/02/2018");
			to.Alterar_Matricula();
	
		}
			
	

	@Test
	public void testExcluir() {
		to.Excluir_Matricula(10);

		TO_Matricula excluir;
		excluir = new TO_Matricula();
		excluir.setMatricula(10);
		excluir.Consultar_Matricula(10);

	}

	@Test
	public void testConsultar() {
		TO_Matricula testeconsulta = dao.Consultar(1);
		testeconsulta.setMatricula(1);
	}
	
	@Test
	public void testConsultarAll() {
		ArrayList<TO_Matricula> testeconsulta = dao.consuAll();
	
	}
	
	@Test
	public void testConsultarAllAtivas() {
		ArrayList<TO_Matricula> testeconsulta = dao.consuAllAtivas();
	
	}
	
	@Test
	public void testConsultarAllCanceladas() {
		ArrayList<TO_Matricula> testeconsulta = dao.consuAllCanceladas();
	
	}
	@Test
	public void testConsultarDataAtiva() {
		ArrayList<TO_Matricula> testeconsulta = dao.consultarDataC("17/10/2013");
	
	}
	@Test
	public void testConsultarDataCancelada() {
		ArrayList<TO_Matricula> testeconsulta = dao.consultarDataA("17/10/2013");
	
	}
	
	@Test
	public void testConsultarRA() {
		ArrayList<TO_Matricula> teste= dao.consuAllRa(1);		
	
	}

}

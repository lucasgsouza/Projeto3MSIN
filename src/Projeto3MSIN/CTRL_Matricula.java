package Projeto3MSIN;

public class CTRL_Matricula {

	TO_Matricula MMatricula;

	public CTRL_Matricula() {

	}

	// Insert
	public void MatriculaInsert(int Matricula, String DataMatricula, int CodigoCurso, float Valor, int RaAluno,
			String StatusMatricula, String StatusFinanceiro) {

		MMatricula = new TO_Matricula(Matricula, DataMatricula, CodigoCurso, Valor, RaAluno, StatusMatricula,StatusFinanceiro);
		MMatricula.Cadastrar_Matricula();
	}

	public void MatriculaUpdate(int Matricula, String DataMatricula, int CodigoCurso, float Valor, int RaAluno,
			String StatusMatricula, String StatusFinanceiro) {
		MMatricula = new TO_Matricula(Matricula, DataMatricula, CodigoCurso, Valor, RaAluno, StatusMatricula,
				StatusFinanceiro);

		MMatricula.Alterar_Matricula();
	}

	public void MatriculaExcluir(int Matricula) {

		MMatricula = new TO_Matricula();
		MMatricula.Excluir_Matricula(Matricula);
	}

	public void MatriculaConsultar(int Matricula) {

		MMatricula = new TO_Matricula();
		MMatricula.Consultar_Matricula(Matricula);
	}
	
	public void MatriculaConsultarRa(int RaAluno) {

		MMatricula = new TO_Matricula();
		MMatricula.Consultar_MatriculaRa(RaAluno);
	}

	public void MatriculaConsultarData(String DataMatricula) {

		MMatricula = new TO_Matricula();
		MMatricula.Consultar_MatriculaData(DataMatricula);
	}

}

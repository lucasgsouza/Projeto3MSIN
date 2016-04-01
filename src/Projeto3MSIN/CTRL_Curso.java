package Projeto3MSIN;

public class CTRL_Curso {

	TO_Curso Curso;

	public CTRL_Curso() {

	}

	// Insert
	public void CursoInsert(int Codigo, String NomeCurso, String DataInicio, String DataFim, String Horario,
			int NumeroVagas, float Valor, int LabSala, String Descricao, String MatSoftwares, String Area) {

		Curso = new TO_Curso(Codigo, NomeCurso, DataInicio, DataFim, Horario, NumeroVagas, Valor, LabSala, Descricao,
				MatSoftwares, Area);
		Curso.Cadastrar_Curso();
	}

	public void CursoUpdate(int Codigo, String NomeCurso, String DataInicio, String DataFim, String Horario,
			int NumeroVagas, float Valor, int LabSala, String Descricao, String MatSoftwares, String Area) {
		Curso = new TO_Curso(Codigo, NomeCurso, DataInicio, DataFim, Horario, NumeroVagas, Valor, LabSala, Descricao,
				MatSoftwares, Area);
		Curso.Alterar_Curso();
	}

	public void CursoExcluir(int Codigo) {

		Curso = new TO_Curso();
		Curso.Excluir_Curso(Codigo);
	}

	public void CursoConsultar(int Codigo) {

		Curso = new TO_Curso();
		Curso.Consultar_Curso(Codigo);
	}

	
}

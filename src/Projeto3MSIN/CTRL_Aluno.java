package Projeto3MSIN;

public class CTRL_Aluno {

	TO_Aluno Aluno;

	public CTRL_Aluno() {

	}

	// Insert
	public void AlunoInsert(int Ra, String Nome, String Endereco,  String  Telefone, String Email,  String  RG,  String  CPF) {

		Aluno = new TO_Aluno(Ra, Nome, Endereco, Telefone, Email, RG, CPF);
		Aluno.Cadastrar_Aluno();
	}

	public void AlunoUpdate(int Ra, String Nome, String Endereco,  String  Telefone, String Email,  String  RG,  String  CPF) {
		Aluno = new TO_Aluno(Ra, Nome, Endereco, Telefone, Email, RG, CPF);
		Aluno.Alterar_Aluno();
	}

	public void AlunoExcluir(int Ra) {

		Aluno = new TO_Aluno();
		Aluno.Excluir_Aluno(Ra);
	}
	
	public void AlunoConsultar(int Ra) {

		Aluno = new TO_Aluno();
		Aluno.Consultar_Aluno(Ra);
	}

}

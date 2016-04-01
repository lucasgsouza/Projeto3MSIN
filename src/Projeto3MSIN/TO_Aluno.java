package Projeto3MSIN;

public class TO_Aluno {

	private int Ra;
	private String Nome, Endereco, Email, Telefone, RG, CPF;
	// Classe DAO_Aluno
	DAO_Aluno AlunoDAO = new DAO_Aluno();

	public TO_Aluno() {

	}

	public TO_Aluno(int Ra, String Nome, String Endereco, String Telefone, String Email, String RG, String CPF) {

		this.Ra = Ra;
		this.Nome = Nome;
		this.Endereco = Endereco;
		this.Telefone = Telefone;
		this.Email = Email;
		this.RG = RG;
		this.CPF = CPF;

	}

	public void setRa(int Ra) {

		this.Ra = Ra;

	}

	public void setNome(String Nome) {
		this.Nome = Nome;

	}

	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;

	}

	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;

	}

	public void setEmail(String Email) {
		this.Email = Email;

	}

	public void setRG(String RG) {
		this.RG = RG;

	}

	public void setCPF(String CPF) {
		this.CPF = CPF;

	}

	public int getRa() {
		return Ra;
	}

	public String getNome() {
		return Nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public String getEmail() {
		return Email;
	}

	public String getRG() {
		return RG;
	}

	public String getCPF() {
		return CPF;
	}

	public void Cadastrar_Aluno() {

		AlunoDAO.Insert(this);

	}

	public void Alterar_Aluno() {

		AlunoDAO.Update(this);

	}

	public void Excluir_Aluno(int Ra) {

		AlunoDAO.Excluir(Ra);

	}

	public void Consultar_Aluno(int Ra) {

		AlunoDAO.Consultar(Ra);

	}

}

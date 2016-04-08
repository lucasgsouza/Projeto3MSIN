package MODEL;

import DAO.DAO_Aluno;

public class Aluno {
	
	private int		codAluno;
	private String	nomeAluno;
	private String	enderecoAluno;
	private String	telefoneAluno;
	private String	emailAluno;
	private String  rgAluno;
	private String  cpfAluno;
	private String  senhaAluno;
	
	public Aluno(int codAluno) {
		super();
		this.codAluno = codAluno;
	}
	
	public Aluno(int codAluno, String nomeAluno, String enderecoAluno, String telefoneAluno, String emailAluno,
			String rgAluno, String cpfAluno, String senhaAluno) {
		super();
		this.codAluno = codAluno;
		this.nomeAluno = nomeAluno;
		this.enderecoAluno = enderecoAluno;
		this.telefoneAluno = telefoneAluno;
		this.emailAluno = emailAluno;
		this.rgAluno = rgAluno;
		this.cpfAluno = cpfAluno;
		this.senhaAluno = senhaAluno;
	}

	public int getCodAluno() {
		return codAluno;
	}
	public void setCodAluno(int codAluno) {
		this.codAluno = codAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getEnderecoAluno() {
		return enderecoAluno;
	}
	public void setEnderecoAluno(String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}
	public String getTelefoneAluno() {
		return telefoneAluno;
	}
	public void setTelefoneAluno(String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}
	public String getEmailAluno() {
		return emailAluno;
	}
	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	public String getRgAluno() {
		return rgAluno;
	}
	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}
	public String getCpfAluno() {
		return cpfAluno;
	}
	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	public String getSenhaAluno() {
		return senhaAluno;
	}
	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
	}
	
	public boolean criar(){
		DAO_Aluno dao = new DAO_Aluno();
		return dao.Insert(0, nomeAluno, enderecoAluno, telefoneAluno, emailAluno, rgAluno, cpfAluno, senhaAluno);
		
	}

}

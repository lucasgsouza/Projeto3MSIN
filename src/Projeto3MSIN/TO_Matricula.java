package Projeto3MSIN;

import java.sql.Date;

import javax.xml.crypto.Data;

public class TO_Matricula {

	private int Matricula, CodigoCurso, RaAluno;
	private String DataMatricula,StatusMatricula, StatusFinanceiro;
	private Float Valor;


	DAO_Matricula MatriculaDAO = new DAO_Matricula();

	public TO_Matricula() {

	}

	public TO_Matricula(int Matricula, String DataMatricula, int CodigoCurso, float Valor, int RaAluno,
			String StatusMatricula, String StatusFinanceiro) {

		this.Matricula = Matricula;
		this.DataMatricula = DataMatricula;
		this.CodigoCurso = CodigoCurso;
		this.Valor = Valor;
		this.RaAluno = RaAluno;
		this.StatusMatricula = StatusMatricula;
		this.StatusFinanceiro = StatusFinanceiro;
	}

	public void setMatricula(int Matricula) {
		this.Matricula = Matricula;
	}

	public void setDataMatricula(String DataMatricula) {
		this.DataMatricula = DataMatricula;
	}

	public void setCodigoCurso(int CodigoCurso) {
		this.CodigoCurso = CodigoCurso;
	}

	public void setValor(float Valor) {
		this.Valor = Valor;
	}

	public void setRaAluno(int RaAluno) {
		this.RaAluno = RaAluno;
	}

	public void setStatusMatricula(String StatusMatricula) {
		this.StatusMatricula = StatusMatricula;
	}

	public void setStatusFinanceiro(String StatusFinanceiro) {
		this.StatusFinanceiro = StatusFinanceiro;
	}

	public int getMatricula() {
		return Matricula;
	}

	public String getDataMatricula() {
		return DataMatricula;
	}

	public int getCodigoCurso() {
		return CodigoCurso;
	}

	public float getValor() {
		return Valor;
	}

	public int getRaAluno() {
		return RaAluno;
	}

	public String getStatusMatricula() {
		return StatusMatricula;
	}

	public String getStatusFinanceiro() {
		return StatusFinanceiro;
	}

	public void Cadastrar_Matricula() {

		MatriculaDAO.Insert(this);

	}

	public void Alterar_Matricula() {

		MatriculaDAO.Update(this);

	}

	public void Excluir_Matricula(int Matricula) {

		MatriculaDAO.Excluir(Matricula);

	}

	public void Consultar_Matricula(int Matricula) {

		MatriculaDAO.Consultar(Matricula);

	}
	
	public void Consultar_MatriculaRa(int RaAluno) {

		MatriculaDAO.consuAllRa(RaAluno);

	}
	
	public void Consultar_MatriculaData(String DataMatricula) {

		MatriculaDAO.consultarDataA(DataMatricula);

	}

	
}

package TO;

import java.sql.Date;
import javax.xml.crypto.Data;
import DAO.DAO_Matricula;
import TO.TO_Matricula;

public class TO_Matricula {

	private int Matricula, CodigoCurso, RaAluno;
	private String DataMatricula, StatusMatricula, StatusFinanceiro;
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		TO_Matricula other = (TO_Matricula) obj;

		if (Matricula != other.Matricula)
			return false;

		if (DataMatricula == null) {
			if (other.DataMatricula != null)
				return false;
		} else if (!DataMatricula.equals(other.DataMatricula))
			return false;

		if (CodigoCurso != other.CodigoCurso)
			return false;
		if (Valor != other.Valor)
			return false;
		if (RaAluno != other.RaAluno)
			return false;

		if (StatusMatricula == null) {
			if (other.StatusMatricula != null)
				return false;
		} else if (!StatusMatricula.equals(other.StatusMatricula))
			return false;

		if (StatusFinanceiro == null) {
			if (other.StatusFinanceiro != null)
				return false;
		} else if (!StatusFinanceiro.equals(other.StatusFinanceiro))
			return false;

		return true;
	}

}

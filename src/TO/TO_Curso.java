package TO;

import DAO.DAO_Curso;
import TO.TO_Curso;

public class TO_Curso {

	private int Codigo, LabSala, NumeroVagas;
	private float Valor;
	private String NomeCurso, DataInicio, DataFim, Horario, Descricao, MatSoftwares, Area;
	// Classe DAO_Aluno
	DAO_Curso CursoDAO = new DAO_Curso();

	public TO_Curso() {

	}

	public TO_Curso(int Codigo, String NomeCurso, String DataInicio, String DataFim, String Horario, int NumeroVagas,
			float Valor, int LabSala, String Descricao, String MatSoftwares, String Area) {

		this.Codigo = Codigo;
		this.NomeCurso = NomeCurso;
		this.DataInicio = DataInicio;
		this.DataFim = DataFim;
		this.Horario = Horario;
		this.NumeroVagas = NumeroVagas;
		this.Valor = Valor;
		this.LabSala = LabSala;
		this.Descricao = Descricao;
		this.MatSoftwares = MatSoftwares;
		this.Area = Area;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public void setNomeCurso(String NomeCurso) {
		this.NomeCurso = NomeCurso;
	}

	public void setDataInicio(String DataInicio) {
		this.DataInicio = DataInicio;
	}

	public void setDataFim(String DataFim) {
		this.DataFim = DataFim;
	}

	public void setHorario(String Horario) {
		this.Horario = Horario;
	}

	public void setNumeroVagas(int NumeroVagas) {
		this.NumeroVagas = NumeroVagas;
	}

	public void setValor(float Valor) {
		this.Valor = Valor;
	}

	public void setLabSala(int LabSala) {
		this.LabSala = LabSala;
	}

	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}

	public void setMatSoftwares(String MatSoftwares) {
		this.MatSoftwares = MatSoftwares;
	}

	public void setArea(String Area) {
		this.Area = Area;
	}

	public int getCodigo() {
		return Codigo;
	}

	public String getNomeCurso() {
		return NomeCurso;
	}

	public String getDataInicio() {
		return DataInicio;
	}

	public String getDataFim() {
		return DataFim;
	}

	public String getHorario() {
		return Horario;
	}

	public int getNumeroVagas() {
		return NumeroVagas;

	}

	public float getValor() {
		return Valor;
	}

	public int getLabSala() {
		return LabSala;

	}

	public String getDescricao() {
		return Descricao;
	}

	public String getMatSoftwares() {
		return MatSoftwares;
	}

	public String getArea() {
		return Area;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		TO_Curso other = (TO_Curso) obj;

		if (Codigo != other.Codigo)
			return false;

		if ( NomeCurso== null) {
			if (other.NomeCurso!= null)
				return false;
		} else if (!NomeCurso.equals(other.NomeCurso))
			return false;
		
		if ( DataInicio== null) {
			if (other.DataInicio!= null)
				return false;
		} else if (!DataInicio.equals(other.DataInicio))
			return false;
		
		if ( DataFim== null) {
			if (other.DataFim!= null)
				return false;
		} else if (!DataFim.equals(other.DataFim))
			return false;
		
		if ( DataFim== null) {
			if (other.DataFim!= null)
				return false;
		} else if (!DataFim.equals(other.DataFim))
			return false;

		if ( Horario== null) {
			if (other.Horario != null)
				return false;
		} else if (!Horario.equals(other.Horario))
			return false;

		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		
		if (MatSoftwares == null) {
			if (other.MatSoftwares != null)
				return false;
		} else if (!MatSoftwares.equals(other.MatSoftwares))
			return false;
		
		if (Area == null) {
			if (other.Area != null)
				return false;
		} else if (!Area.equals(other.Area))
			return false;
		
		if (NumeroVagas!= other.NumeroVagas)
			return false;
		if (Valor!= other.Valor)
			return false;
		if (LabSala!= other.LabSala)
			return false;

		return true;
	}


}

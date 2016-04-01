package Projeto3MSIN;

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

	public void Cadastrar_Curso() {

		CursoDAO.Insert(this);

	}

	public void Alterar_Curso() {

		CursoDAO.Update(this);

	}

	public void Excluir_Curso(int Codigo) {

		CursoDAO.Excluir(Codigo);

	}

	public void Consultar_Curso(int Codigo) {

		CursoDAO.Consultar(Codigo);

	}

}

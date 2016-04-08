package MODEL;

public class Curso {

	private int 	codCurso;
	private String	nomeCurso;
	private String	dataInicioCurso;
	private String	dataFimCurso;
	private String	horarioCurso;
	private int		numVagasCurso;
	private double	valorCurso;
	private String	tipoCurso;
	private String	salaCurso;
	private String	materiaisCurso;
	
	public Curso() {
		
	}
	
	
	public Curso(int codCurso) {
		super();
		this.codCurso = codCurso;
	}




	public Curso(int codCurso, String nomeCurso, String dataInicioCurso, String dataFimCurso, String horarioCurso,
			int numVagasCurso, double valorCurso, String tipoCurso, String salaCurso, String materiaisCurso) {
		super();
		this.codCurso = codCurso;
		this.nomeCurso = nomeCurso;
		this.dataInicioCurso = dataInicioCurso;
		this.dataFimCurso = dataFimCurso;
		this.horarioCurso = horarioCurso;
		this.numVagasCurso = numVagasCurso;
		this.valorCurso = valorCurso;
		this.tipoCurso = tipoCurso;
		this.salaCurso = salaCurso;
		this.materiaisCurso = materiaisCurso;
	}




	public int getCodCurso() {
		return codCurso;
	}




	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}




	public String getNomeCurso() {
		return nomeCurso;
	}




	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}




	public String getDataInicioCurso() {
		return dataInicioCurso;
	}




	public void setDataInicioCurso(String dataInicioCurso) {
		this.dataInicioCurso = dataInicioCurso;
	}




	public String getDataFimCurso() {
		return dataFimCurso;
	}




	public void setDataFimCurso(String dataFimCurso) {
		this.dataFimCurso = dataFimCurso;
	}




	public String getHorarioCurso() {
		return horarioCurso;
	}




	public void setHorarioCurso(String horarioCurso) {
		this.horarioCurso = horarioCurso;
	}




	public int getNumVagasCurso() {
		return numVagasCurso;
	}




	public void setNumVagasCurso(int numVagasCurso) {
		this.numVagasCurso = numVagasCurso;
	}




	public double getValorCurso() {
		return valorCurso;
	}




	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}




	public String getTipoCurso() {
		return tipoCurso;
	}




	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}




	public String getSalaCurso() {
		return salaCurso;
	}




	public void setSalaCurso(String salaCurso) {
		this.salaCurso = salaCurso;
	}




	public String getMateriaisCurso() {
		return materiaisCurso;
	}




	public void setMateriaisCurso(String materiaisCurso) {
		this.materiaisCurso = materiaisCurso;
	}
	

}

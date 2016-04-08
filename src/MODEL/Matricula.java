package MODEL;

import DAO.DAO_Matricula;

public class Matricula {
	
	private int		codMatricula;
	private String	dataMatricula;
	private double	valorMatricula;
	private String	statusMatricula;
	private String	pagamentoMatricula;
	private int		alunoMatricula;
	private int		cursoMatricula;
	
	public Matricula() {
		
	}
	
	public Matricula(int codMatricula) {
		super();
		this.codMatricula = codMatricula;
	}
	
	public Matricula(int codMatricula, String dataMatricula, double valorMatricula, String statusMatricula,
			String pagamentoMatricula, int alunoMatricula, int cursoMatricula) {
		super();
		this.codMatricula = codMatricula;
		this.dataMatricula = dataMatricula;
		this.valorMatricula = valorMatricula;
		this.statusMatricula = statusMatricula;
		this.pagamentoMatricula = pagamentoMatricula;
		this.alunoMatricula = alunoMatricula;
		this.cursoMatricula = cursoMatricula;
	}
	public int getCodMatricula() {
		return codMatricula;
	}
	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public double getValorMatricula() {
		return valorMatricula;
	}
	public void setValorMatricula(double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
	public String getStatusMatricula() {
		return statusMatricula;
	}
	public void setStatusMatricula(String statusMatricula) {
		this.statusMatricula = statusMatricula;
	}
	public String getPagamentoMatricula() {
		return pagamentoMatricula;
	}
	public void setPagamentoMatricula(String pagamentoMatricula) {
		this.pagamentoMatricula = pagamentoMatricula;
	}
	public int getAlunoMatricula() {
		return alunoMatricula;
	}
	public void setAlunoMatricula(int alunoMatricula) {
		this.alunoMatricula = alunoMatricula;
	}
	public int getCursoMatricula() {
		return cursoMatricula;
	}
	public void setCursoMatricula(int cursoMatricula) {
		this.cursoMatricula = cursoMatricula;
	}
	
	public boolean criar(){
		DAO_Matricula dao = new DAO_Matricula();
		try {
			dao.insert(dataMatricula, valorMatricula, statusMatricula, pagamentoMatricula,
					alunoMatricula,cursoMatricula);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean alterar(){
		DAO_Matricula dao = new DAO_Matricula();
		try {
			dao.update(codMatricula, dataMatricula, valorMatricula, statusMatricula, pagamentoMatricula, alunoMatricula, cursoMatricula);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean excluir(){
		DAO_Matricula dao = new DAO_Matricula();
		try {
			dao.excluir(codMatricula);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	

}

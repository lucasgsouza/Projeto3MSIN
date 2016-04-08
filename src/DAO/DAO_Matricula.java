package DAO;

import java.sql.*;
import java.util.ArrayList;
import MODEL.Matricula;

public class DAO_Matricula {

	// Insert
	public boolean insert(String dataMatricula, double valorMatricula, String statusMatricula,
			String pagamentoMatricula, int alunoMatricula, int cursoMatricula) {

		PreparedStatement pst;
		String sql = "insert into TabelaMatricula (DataMatricula,CodigoCurso,Valor,RaAluno,StatusMatricula,StatusFinanceiro) values (?,?,?,?,?,?)";

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setString(1, dataMatricula);
			pst.setInt(2, cursoMatricula);
			pst.setDouble(3, valorMatricula);
			pst.setInt(4, alunoMatricula);
			pst.setString(5, statusMatricula);
			pst.setString(6, pagamentoMatricula);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;

	}

	// Alterar
	public boolean update(int codMatricula, String dataMatricula, double valorMatricula, String statusMatricula,
			String pagamentoMatricula, int alunoMatricula, int cursoMatricula) {

		PreparedStatement pst;
		String sql = "update TabelaMatricula set DataMatricula=?,CodigoCurso=?,Valor=?,RaAluno=?,StatusMatricula=?,StatusFinanceiro=? where Matricula=?";

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);

			pst.setInt(7, codMatricula);
			pst.setString(1, dataMatricula);
			pst.setInt(2, cursoMatricula);
			pst.setDouble(3, valorMatricula);
			pst.setInt(4, alunoMatricula);
			pst.setString(5, statusMatricula);
			pst.setString(6, pagamentoMatricula);
			pst.executeUpdate();

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Excluir
	public boolean excluir(int matricula) {

		PreparedStatement pst;

		String sql = "delete from TabelaMatricula where Matricula=?";

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setInt(1, matricula);

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;

	}

	// Consultar por Codigo
	public Matricula Consultar(int cod) {

		PreparedStatement pst;
		String sql = "select * from  TabelaMatricula where Matricula =?";

		Matricula TMatricula = null;

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cod);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {

				TMatricula = new Matricula(cod);
				TMatricula.setDataMatricula(resultSet.getString("DataMatricula"));
				TMatricula.setCursoMatricula(resultSet.getInt("CodigoCurso"));
				TMatricula.setValorMatricula(resultSet.getFloat("Valor"));
				TMatricula.setAlunoMatricula(resultSet.getInt("RaAluno"));
				TMatricula.setStatusMatricula(resultSet.getString("StatusMatricula"));
				TMatricula.setPagamentoMatricula(resultSet.getString("StatusFinanceiro"));

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return TMatricula;
	}

	public ArrayList<Matricula> consuAll() {

		PreparedStatement pst;
		String sql = "select * from  TabelaMatricula";

		ArrayList<Matricula> matricula = new ArrayList<Matricula>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Matricula TMatricula = new Matricula();

				TMatricula.setCodMatricula(resultSet.getInt("Matricula"));
				TMatricula.setDataMatricula(resultSet.getString("DataMatricula"));
				TMatricula.setCursoMatricula(resultSet.getInt("CodigoCurso"));
				TMatricula.setValorMatricula(resultSet.getFloat("Valor"));
				TMatricula.setAlunoMatricula(resultSet.getInt("RaAluno"));
				TMatricula.setStatusMatricula(resultSet.getString("StatusMatricula"));
				TMatricula.setPagamentoMatricula(resultSet.getString("StatusFinanceiro"));

				matricula.add(TMatricula);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matricula;
	}

	public ArrayList<Matricula> consultaStatus(String status) {

		PreparedStatement pst;
		String sql = "select * from  TabelaMatricula where StatusMatricula like ?";

		ArrayList<Matricula> matricula = new ArrayList<Matricula>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);
			pst.setString(1, status);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Matricula TMatricula = new Matricula();

				TMatricula.setCodMatricula(resultSet.getInt("Matricula"));
				TMatricula.setDataMatricula(resultSet.getString("DataMatricula"));
				TMatricula.setCursoMatricula(resultSet.getInt("CodigoCurso"));
				TMatricula.setValorMatricula(resultSet.getFloat("Valor"));
				TMatricula.setAlunoMatricula(resultSet.getInt("RaAluno"));
				TMatricula.setStatusMatricula(resultSet.getString("StatusMatricula"));
				TMatricula.setPagamentoMatricula(resultSet.getString("StatusFinanceiro"));

				matricula.add(TMatricula);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matricula;
	}
	
	public ArrayList<Matricula> consultaAluno(int cod) {

		PreparedStatement pst;
		String sql = "select * from  TabelaMatricula where RaAluno= ?";

		ArrayList<Matricula> matricula = new ArrayList<Matricula>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setInt(1, cod);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Matricula TMatricula = new Matricula();

				TMatricula.setCodMatricula(resultSet.getInt("Matricula"));
				TMatricula.setDataMatricula(resultSet.getString("DataMatricula"));
				TMatricula.setCursoMatricula(resultSet.getInt("CodigoCurso"));
				TMatricula.setValorMatricula(resultSet.getFloat("Valor"));
				TMatricula.setAlunoMatricula(resultSet.getInt("RaAluno"));
				TMatricula.setStatusMatricula(resultSet.getString("StatusMatricula"));
				TMatricula.setPagamentoMatricula(resultSet.getString("StatusFinanceiro"));

				matricula.add(TMatricula);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matricula;
	}

	public ArrayList<Matricula> consultarData(String DataMatricula) {

		PreparedStatement pst;
		String sql = "select * from  TabelaMatricula where DataMatricula= ?";

		ArrayList<Matricula> matricula = new ArrayList<Matricula>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);
			pst.setString(1, DataMatricula);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Matricula TMatricula = new Matricula();

				TMatricula.setCodMatricula(resultSet.getInt("Matricula"));
				TMatricula.setDataMatricula(resultSet.getString("DataMatricula"));
				TMatricula.setCursoMatricula(resultSet.getInt("CodigoCurso"));
				TMatricula.setValorMatricula(resultSet.getFloat("Valor"));
				TMatricula.setAlunoMatricula(resultSet.getInt("RaAluno"));
				TMatricula.setStatusMatricula(resultSet.getString("StatusMatricula"));
				TMatricula.setPagamentoMatricula(resultSet.getString("StatusFinanceiro"));

				matricula.add(TMatricula);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matricula;
	}
	
	public ArrayList<Matricula> consultarCurso(int curso) {

		PreparedStatement pst;
		String sql = "select * from  TabelaMatricula where CodigoCurso= ?";

		ArrayList<Matricula> matricula = new ArrayList<Matricula>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, curso);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Matricula TMatricula = new Matricula();

				TMatricula.setCodMatricula(resultSet.getInt("Matricula"));
				TMatricula.setDataMatricula(resultSet.getString("DataMatricula"));
				TMatricula.setCursoMatricula(resultSet.getInt("CodigoCurso"));
				TMatricula.setValorMatricula(resultSet.getFloat("Valor"));
				TMatricula.setAlunoMatricula(resultSet.getInt("RaAluno"));
				TMatricula.setStatusMatricula(resultSet.getString("StatusMatricula"));
				TMatricula.setPagamentoMatricula(resultSet.getString("StatusFinanceiro"));

				matricula.add(TMatricula);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matricula;
	}

}

package DAO;

import java.sql.*;
import java.util.ArrayList;

import MODEL.Curso;

public class DAO_Curso  {

	// Insert
	public void Insert(Curso curso) {

		PreparedStatement pst;
		String sql = "insert into TabelaCurso(NomeCurso,DataInicio,DataFim,Horario,NumeroVagas,Valor,Tipo,LabSala,MatSoftwares) values (?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);

			pst.setString(1, curso.getNomeCurso());
			pst.setString(2, curso.getDataInicioCurso());
			pst.setString(3, curso.getDataFimCurso());
			pst.setString(4, curso.getHorarioCurso());
			pst.setInt(5, curso.getNumVagasCurso());
			pst.setDouble(6, curso.getValorCurso());
			pst.setString(7, curso.getTipoCurso());
			pst.setString(8, curso.getSalaCurso());
			pst.setString(9, curso.getMateriaisCurso());
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Alterar
	public void Update(Curso curso) {

		PreparedStatement pst;
		String sql = "update TabelaCurso set NomeCurso=?,DataInicio=?,DataFim=?,Horario=?,NumeroVagas=?,Valor=?,Tipo=?,LabSala=?,MatSoftwares=? where Codigo= ?";

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);
			pst.setInt(10, curso.getCodCurso());
			pst.setString(1, curso.getNomeCurso());
			pst.setString(2, curso.getDataInicioCurso());
			pst.setString(3, curso.getDataFimCurso());
			pst.setString(4, curso.getHorarioCurso());
			pst.setInt(5, curso.getNumVagasCurso());
			pst.setDouble(6, curso.getValorCurso());
			pst.setString(7, curso.getTipoCurso());
			pst.setString(8, curso.getSalaCurso());
			pst.setString(9, curso.getMateriaisCurso());
			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Excluir
	public void Excluir(int codigo) {

		PreparedStatement pst;

		String sql = "delete from TabelaCurso where Codigo=?";

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setInt(1, codigo);

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Consultar por Codigo
	public Curso Consultar(int codigo) {

		PreparedStatement pst;
		String sql = "select * from  TabelaCurso where Codigo =?";
		Curso curso = null;

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setInt(1, codigo);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {

				curso = new Curso(codigo);
				curso.setCodCurso(resultSet.getInt("Codigo"));
				curso.setNomeCurso(resultSet.getString("NomeCurso"));
				curso.setDataInicioCurso(resultSet.getString("DataInicio"));
				curso.setDataFimCurso(resultSet.getString("DataFim"));
				curso.setHorarioCurso(resultSet.getString("Horario"));
				curso.setNumVagasCurso(resultSet.getInt("NumeroVagas"));
				curso.setValorCurso(resultSet.getDouble("Valor"));
				curso.setTipoCurso(resultSet.getString("Tipo"));
				curso.setSalaCurso(resultSet.getString("LabSala"));
				curso.setMateriaisCurso(resultSet.getString("MatSoftwares"));

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	public ArrayList<Curso> consuAll() {

		PreparedStatement pst;
		String sql = "select * from  TabelaCurso";
		ArrayList<Curso> curso = new ArrayList<Curso>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Curso TCurso = new Curso();

				TCurso.setCodCurso(resultSet.getInt("Codigo"));
				TCurso.setNomeCurso(resultSet.getString("NomeCurso"));
				TCurso.setDataInicioCurso(resultSet.getString("DataInicio"));
				TCurso.setDataFimCurso(resultSet.getString("DataFim"));
				TCurso.setHorarioCurso(resultSet.getString("Horario"));
				TCurso.setNumVagasCurso(resultSet.getInt("NumeroVagas"));
				TCurso.setValorCurso(resultSet.getFloat("Valor"));
				TCurso.setTipoCurso(resultSet.getString("Tipo"));
				TCurso.setSalaCurso(resultSet.getString("LabSala"));
				TCurso.setMateriaisCurso(resultSet.getString("MatSoftwares"));
				curso.add(TCurso);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	public ArrayList<Curso> consultaPorTipo(String tipo) {

		PreparedStatement pst;
		String sql = "select * from  TabelaCurso where Tipo like ?";
		ArrayList<Curso> curso = new ArrayList<Curso>();

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setString(1, tipo);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {

				Curso TCurso = new Curso();

				TCurso.setCodCurso(resultSet.getInt("Codigo"));
				TCurso.setNomeCurso(resultSet.getString("NomeCurso"));
				TCurso.setDataInicioCurso(resultSet.getString("DataInicio"));
				TCurso.setDataFimCurso(resultSet.getString("DataFim"));
				TCurso.setHorarioCurso(resultSet.getString("Horario"));
				TCurso.setNumVagasCurso(resultSet.getInt("NumeroVagas"));
				TCurso.setValorCurso(resultSet.getFloat("Valor"));
				TCurso.setTipoCurso(resultSet.getString("Tipo"));
				TCurso.setSalaCurso(resultSet.getString("LabSala"));
				TCurso.setMateriaisCurso(resultSet.getString("MatSoftwares"));
				curso.add(TCurso);

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import MODEL.Atendente;

public class DAO_Atendente {

	// Insert
		public void insert(Atendente atendente) {

			PreparedStatement pst;

			String sql = "insert into TabelaAtendente (Login,Senha) values (?,?)";
			try {
				Connection conn = ConnectionFactory.obtemConexao();

				pst = conn.prepareStatement(sql);
				pst.setString(1, atendente.getLogin());
				pst.setString(2, atendente.getSenha());
				pst.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		// Alterar
		public void alterarSenha(String login, String senha) {

			PreparedStatement pst;

			String sql = "update TabelaAtendente set Senha=? where Login like ?";
			try {
				Connection conn = ConnectionFactory.obtemConexao();
				pst = conn.prepareStatement(sql);

				pst.setString(1, senha);
				pst.setString(2, login);
				

				pst.executeUpdate();
				pst.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		// Excluir
		public void excluir(String login, String senha) {

			PreparedStatement pst;

			String sql = "delete * from TabelaAluno where Login like ? AND Senha like ?";
			try {
				Connection conn = ConnectionFactory.obtemConexao();
				pst = conn.prepareStatement(sql);

				pst.setString(1, login);
				pst.setString(2, senha);

				pst.executeUpdate();
				pst.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		// Consultar por Codigo
		public Atendente consultar(String login) {

			PreparedStatement pst;

			Atendente atendente = new Atendente();

			try {
				Connection conn = ConnectionFactory.obtemConexao();

				String sql = "select * from  TabelaAluno where Login like ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, login);
				ResultSet resultSet = pst.executeQuery();
				if (resultSet.next()) {

					atendente.setCodigo(resultSet.getInt("Codigo"));
					atendente.setLogin(resultSet.getString("Login"));
					atendente.setSenha(resultSet.getString("Senha"));

				}
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
			return atendente;
		}

}

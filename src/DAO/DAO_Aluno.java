package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MODEL.Aluno;

public class DAO_Aluno {

	// Insert
	public boolean Insert(int codAluno, String nomeAluno, String enderecoAluno, String telefoneAluno, String emailAluno, String rgAluno, String cpfAluno, String senhaAluno) {

		PreparedStatement pst;

		String sql = "insert into TabelaAluno (Nome,Endereco,Telefone,Email,RG,CPF,Senha) values (?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionFactory.obtemConexao();

			pst = conn.prepareStatement(sql);
			pst.setString(1, nomeAluno);
			pst.setString(2, enderecoAluno);
			pst.setString(3, telefoneAluno);
			pst.setString(4, emailAluno);
			pst.setString(5, rgAluno);
			pst.setString(6, cpfAluno);
			pst.setString(7, senhaAluno);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		return true;

	}

	// Alterar
	public void Update(Aluno aluno) {

		PreparedStatement pst;

		String sql = "update TabelaAluno set Nome=?,Endereco=?,Telefone=?,Email=?,RG=?,CPF=?,Senha=? where Ra= ?";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);

			pst.setInt(8, aluno.getCodAluno());
			pst.setString(1, aluno.getNomeAluno());
			pst.setString(2, aluno.getEnderecoAluno());
			pst.setString(3, aluno.getTelefoneAluno());
			pst.setString(4, aluno.getEmailAluno());
			pst.setString(5, aluno.getRgAluno());
			pst.setString(6, aluno.getCpfAluno());
			pst.setString(7, aluno.getSenhaAluno());

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Excluir
	public void Excluir(int ra) {

		PreparedStatement pst;

		String sql = "delete from TabelaAluno where Ra=?";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			pst = conn.prepareStatement(sql);

			pst.setInt(1, ra);

			pst.executeUpdate();
			pst.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// Consultar por Codigo
	public Aluno  Consultar(int ra) {

		PreparedStatement pst;

		Aluno aluno = new Aluno(ra);

		try {
			Connection conn = ConnectionFactory.obtemConexao();

			String sql = "select * from  TabelaAluno where Ra =?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ra);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {

				aluno.setNomeAluno(resultSet.getString("Nome"));
				aluno.setEnderecoAluno(resultSet.getString("Endereco"));
				aluno.setTelefoneAluno(resultSet.getString("Telefone"));
				aluno.setEmailAluno(resultSet.getString("Email"));
				aluno.setRgAluno(resultSet.getString("RG"));
				aluno.setCpfAluno(resultSet.getString("CPF"));
				aluno.setSenhaAluno(resultSet.getString("Senha"));

			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return aluno;
	}

}

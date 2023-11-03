package br.cefet.simulacaoTurfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.simulacaoTurfe.model.Proprietario;

public class ProprietarioDao {
	private Connection connection;

	public ProprietarioDao() {
		connection = ConnectionFactory.getConnection();
	}

	public void adicionar(Proprietario proprietario) throws SQLException {
		String sql = "INSERT INTO proprietario(nome, cpf, email, telefone) values(?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, proprietario.getNome());
		stmt.setString(2, proprietario.getCpf());
		stmt.setString(3, proprietario.getEmail());
		stmt.setString(4, proprietario.getTelefone());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void apagar(int id) throws SQLException {
		String sql = "DELETE FROM proprietario where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void alterar(Proprietario proprietario) throws SQLException {
		String sql = "UPDATE proprietario set nome = ?, email = ?, telefone = ? where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, proprietario.getNome());
		stmt.setString(2, proprietario.getCpf());
		stmt.setString(3, proprietario.getEmail());
		stmt.setString(4, proprietario.getTelefone());
		stmt.setInt(5, proprietario.getId());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Proprietario> listarTodos() throws SQLException {
		String sql = "SELECT id, nome, cpf, email, telefone FROM proprietario";
		PreparedStatement stmt = connection.prepareStatement(sql);
		Proprietario proprietario = null;
		List<Proprietario> proprietarios = new ArrayList<Proprietario>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			proprietario = new Proprietario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("telefone"));
			proprietario.setId(rs.getInt("id"));
			proprietarios.add(proprietario);
		}
		stmt.close();
		connection.close();
		return proprietarios;
	}

	public Proprietario buscarUm(int id) throws SQLException {
		String sql = "SELECT id, nome FROM proprietario where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		Proprietario proprietario = null;
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			proprietario = new Proprietario();
			proprietario.setId(rs.getInt("id"));
			proprietario.setNome(rs.getString("nome"));
		}
		stmt.close();
		connection.close();
		return proprietario;
	}
}

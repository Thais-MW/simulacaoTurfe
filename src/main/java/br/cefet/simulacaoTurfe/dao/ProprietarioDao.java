package br.cefet.simulacaoTurfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.cefet.simulacaoTurfe.model.Proprietario;

public class ProprietarioDao {
	private Connection connection;

	public ProprietarioDao() {
	}

	public int adicionar(Proprietario proprietario) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO proprietario(nome, cpf, email, telefone, senha) values(?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, proprietario.getNome());
		stmt.setString(2, proprietario.getCpf());
		stmt.setString(3, proprietario.getEmail());
		stmt.setString(4, proprietario.getTelefone());
		stmt.setString(5, proprietario.getSenha());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		int lastInsertId = 0;
		if (rs.next()) {
			lastInsertId = rs.getInt(1);
		}
		stmt.close();
		connection.close();
		return lastInsertId;
	}

	public void apagar(int id) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "DELETE FROM proprietario where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void alterar(Proprietario proprietario) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "UPDATE proprietario set nome = ?, cpf = ?, email = ?, telefone = ?, senha = ? where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, proprietario.getNome());
		stmt.setString(2, proprietario.getCpf());
		stmt.setString(3, proprietario.getEmail());
		stmt.setString(4, proprietario.getTelefone());
		stmt.setString(5, proprietario.getSenha());
		stmt.setInt(6, proprietario.getId());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Proprietario> listarTodos() throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, cpf, email, telefone, senha FROM proprietario";
		PreparedStatement stmt = connection.prepareStatement(sql);
		Proprietario proprietario = null;
		List<Proprietario> proprietarios = new ArrayList<Proprietario>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			proprietario = this.getProprietario(rs);
			proprietarios.add(proprietario);
		}
		stmt.close();
		return proprietarios;
	}

	public Proprietario buscarUm(int id) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM proprietario where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		Proprietario proprietario = null;
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			proprietario = this.getProprietario(rs);
		}
		stmt.close();
		connection.close();
		return proprietario;
	}
	
	public Proprietario getProprietario(ResultSet rs) throws SQLException {
		Proprietario p = new Proprietario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("telefone"), rs.getString("senha"));
		p.setId(rs.getInt("id"));
		return p;
	}
}

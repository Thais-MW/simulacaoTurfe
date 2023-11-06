package br.cefet.simulacaoTurfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefet.simulacaoTurfe.model.Usuario;


public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		connection = ConnectionFactory.getConnection();
	}
	
	public void adicionar(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario(nome, email, senha) VALUES(?,?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		stmt.setString(3, usuario.getSenha());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public Usuario buscarUm(int id) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		Usuario usuario = null;
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String senha = rs.getString("senha");
			usuario = new Usuario(id, nome, email, senha);
		}
		
		stmt.close();
		connection.close();
		return usuario;
	}
	
	public Usuario buscarUm(String email, String senha) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		
		Usuario usuario = null;
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			usuario = new Usuario(id, nome, email, senha);
		}
		
		stmt.close();
		connection.close();
		
		return usuario;
	}
}

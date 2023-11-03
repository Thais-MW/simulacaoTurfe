package br.cefet.simulacaoTurfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.simulacaoTurfe.model.Corrida;

public class CorridaDao {
	private Connection connection;

	public CorridaDao() {
		connection = ConnectionFactory.getConnection();
	}

	public void adicionar(Corrida corrida) throws SQLException {
		String sql = "INSERT INTO corrida(data_agendada, valor_inscricao) VALUES (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setTimestamp(1, corrida.getData());
		stmt.setFloat(2, corrida.getInscricao());
		
		stmt.execute();
		stmt.close();
		connection.close();
	}
	
	public void apagar(int id) throws SQLException {
		String sql = "DELETE FROM corrida WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		connection.close();
	}
	
	public void alterar(Corrida corrida) throws SQLException {
		String sql = "UPDATE corrida SET data_agendada = ?, valor_inscricao = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setTimestamp(1, corrida.getData());
		stmt.setFloat(2, corrida.getInscricao());
		
		stmt.execute();
		stmt.close();
		connection.close();
	}
	
	public List<Corrida> listarTodos() throws SQLException {
		String sql = "SELECT id, data_agendada, valor_inscricao FROM corrida ORDER BY data_agendada";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		Corrida corrida = null;
		List<Corrida> corridas = new ArrayList<Corrida>();
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			corrida = new Corrida();
			corrida.setId(rs.getInt("id"));
			corrida.setData(rs.getTimestamp("data_agendada"));
			corrida.setInscricao(rs.getFloat("valor_inscricao"));
			
			corridas.add(corrida);
		}
		
		stmt.close();
		connection.close();
		return corridas;
	}
	
	public Corrida buscarUm(int id) throws SQLException {
		String sql = "SELECT id, data_agendada, valor_inscricao FROM corrida WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, id);
		Corrida corrida = null;
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			corrida = new Corrida();
			corrida.setId(rs.getInt("id"));
			corrida.setData(rs.getTimestamp("data_agendada"));
			corrida.setInscricao(rs.getFloat("valor_inscricao"));
		}
		
		stmt.close();
		connection.close();
		return corrida;
	}
}

package br.cefet.simulacaoTurfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.simulacaoTurfe.model.InscricaoCorrida;

public class InscricaoCorridaDao {
	private Connection connection;

	public InscricaoCorridaDao() {
		connection = ConnectionFactory.getConnection();
	}

	public void adicionar(InscricaoCorrida inscricao) throws SQLException {
		String sql = "INSERT INTO cavalo_corrida(id_cavalo, id_corrida) VALUES (?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, inscricao.getCavalo().getId());
		stmt.setInt(2, inscricao.getCorrida().getId());
		
		stmt.execute();
		stmt.close();
		connection.close();
	}
	
	public void apagar(int id) throws SQLException {
		String sql = "DELETE FROM cavalo_corrida WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		connection.close();
	}
	
	public List<InscricaoCorrida> listarTodos() throws SQLException {
		String sql = "SELECT id, id_cavalo, id_corrida FROM cavalo_corrida";
		PreparedStatement stmt = connection.prepareStatement(sql);
		InscricaoCorrida inscricao = null;
		List<InscricaoCorrida> inscricoes = new ArrayList<InscricaoCorrida>();
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			inscricao = new InscricaoCorrida(new CavaloDao().buscarUm(rs.getInt("id_cavalo")), new CorridaDao().buscarUm(rs.getInt("id_corrida")));
			inscricao.setId(rs.getInt("id"));
			
			inscricoes.add(inscricao);
		}
		
		stmt.close();
		connection.close();
		return inscricoes;
	}
	
	public InscricaoCorrida buscarUm(int id) throws SQLException {
		String sql = "SELECT id, id_cavalo, id_corrida FROM cavalo_corrida";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setInt(1, id);
		InscricaoCorrida inscricao = null;
		ResultSet rs = stmt.executeQuery();
		
		if (rs.next()) {
			inscricao = new InscricaoCorrida(new CavaloDao().buscarUm(rs.getInt("id_cavalo")), new CorridaDao().buscarUm(rs.getInt("id_corrida")));
			inscricao.setId(rs.getInt("id"));
		}
		
		stmt.close();
		connection.close();
		return inscricao;
	}
}

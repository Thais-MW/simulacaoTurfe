package br.cefet.simulacaoTurfe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.simulacaoTurfe.model.Cavalo;

public class CavaloDao {

	private Connection connection;

	public CavaloDao() {
	}

	public void adicionar(Cavalo cavalo) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "INSERT INTO cavalo(nome, numero, cor, preco, velocidade, resistencia, id_proprietario) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, cavalo.getNome()); 	
		stmt.setInt(2, cavalo.getNumero());
		stmt.setString(3, cavalo.getCor());
		stmt.setFloat(4, (float) cavalo.getPreco());
		stmt.setInt(5, cavalo.getVelocidade());
		stmt.setInt(6, cavalo.getResistencia());
		stmt.setInt(7, cavalo.getProprietario().getId());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void apagar(int id) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "DELETE FROM cavalo WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void alterar(Cavalo cavalo) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "UPDATE cavalo set nome = ?, numero = ?, cor = ?, preco = ?, velocidade = ?, resistencia = ?, id_proprietario = ? WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, cavalo.getNome()); 	
		stmt.setInt(2, cavalo.getNumero());
		stmt.setString(3, cavalo.getCor());
		stmt.setFloat(4, (float) cavalo.getPreco());
		stmt.setInt(5, cavalo.getVelocidade());
		stmt.setInt(6, cavalo.getResistencia());
		stmt.setInt(7, cavalo.getProprietario().getId());
		stmt.setInt(8, cavalo.getId());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Cavalo> listarTodos() throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, numero, cor, preco, velocidade, resistencia, id_proprietario FROM cavalo";
		PreparedStatement stmt = connection.prepareStatement(sql);
		Cavalo cavalo = null;
		List<Cavalo> cavalos = new ArrayList<Cavalo>();
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			cavalo = this.getCavalo(rs);
			cavalos.add(cavalo);
		}
		stmt.close();
		connection.close();
		return cavalos;
	}

	public Cavalo buscarUm(int id) throws SQLException {
		connection = ConnectionFactory.getConnection();
		String sql = "SELECT id, nome, numero, cor, preco, velocidade, resistencia, id_proprietario FROM cavalo WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		Cavalo cavalo = null;
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			cavalo = this.getCavalo(rs);
		}
		stmt.close();
		connection.close();
		return cavalo;
	}
	
	public Cavalo getCavalo(ResultSet rs) throws SQLException {
		Cavalo cavalo = new Cavalo();
		cavalo.setId(rs.getInt("id"));
		cavalo.setNome(rs.getString("nome"));
		cavalo.setNumero(rs.getInt("numero"));
		cavalo.setCor(rs.getString("cor"));
		cavalo.setPreco(rs.getFloat("preco"));
		cavalo.setVelocidade(rs.getInt("velocidade"));
		cavalo.setResistencia(rs.getInt("resistencia"));
		cavalo.setProprietario(new ProprietarioDao().buscarUm(rs.getInt("id_proprietario")));	
		return cavalo;
	}

}

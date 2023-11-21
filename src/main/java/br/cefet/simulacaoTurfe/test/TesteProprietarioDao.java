package br.cefet.simulacaoTurfe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import br.cefet.simulacaoTurfe.dao.ProprietarioDao;
import br.cefet.simulacaoTurfe.model.Proprietario;

class TesteProprietarioDao {

	@Test
	void test() {
		ProprietarioDao dao = new ProprietarioDao();
		Proprietario p = new Proprietario("Saulo", "cpf fake", "email@email.com", "(22) 99999-9999", "senha");
		
		try {
			p.setId(dao.adicionar(p));
			assertNotEquals(p.getId(), 0);
			assertInstanceOf(Proprietario.class, dao.buscarUm(p.getId()));
			Proprietario outrop = p;
			outrop.setNome("Silver");
			dao.alterar(outrop);
			assertEquals(dao.buscarUm(outrop.getId()).getNome(), "Silver");
			dao.apagar(p.getId());
			assertNull(dao.buscarUm(outrop.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

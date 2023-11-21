/**
 * 
 */
package br.cefet.simulacaoTurfe.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.cefet.simulacaoTurfe.model.Corrida;

/**
 * 
 */
class TesteCorrida {

	@Test
	void taxaDeInscricaoMinima() {
		final float taxaInscricaoInvalida = 99;
		Corrida corrida = new Corrida();
		corrida.setInscricao(taxaInscricaoInvalida);
		assertEquals(corrida.taxaInscricaoMinima, corrida.getInscricao());
	}
	
}

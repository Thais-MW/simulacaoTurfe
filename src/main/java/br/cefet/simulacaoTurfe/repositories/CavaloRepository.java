package br.cefet.simulacaoTurfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cefet.simulacaoTurfe.entities.Cavalo;

public interface CavaloRepository extends JpaRepository<Cavalo, Integer>{
	Cavalo findByNome(String nome);
}

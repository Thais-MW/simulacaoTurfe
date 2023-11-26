package br.cefet.simulacaoTurfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cefet.simulacaoTurfe.entities.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer>{
	Proprietario findByNome(String nome);
}

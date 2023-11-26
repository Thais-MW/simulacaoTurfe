package br.cefet.simulacaoTurfe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.cefet.simulacaoTurfe.entities.Cavalo;
import br.cefet.simulacaoTurfe.entities.Resposta;
import br.cefet.simulacaoTurfe.repositories.CavaloRepository;

@RestController
@RequestMapping(value="/cavalos")
public class CavaloController {
	@Autowired
	private CavaloRepository repository;
	
	@GetMapping
	public ResponseEntity findAll() {
		List<Cavalo> cavalos = this.repository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(cavalos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		Optional<Cavalo> possivelCavalo = this.repository.findById(id);

		if (possivelCavalo.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Resposta("Cavalo não existe."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(possivelCavalo.get());
	}
	
	@PostMapping
	public ResponseEntity insert(@RequestBody Cavalo cavalo) {
		Cavalo cavaloAchado = this.repository.findByNome(cavalo.getNome());
		
		if (cavaloAchado != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Resposta("Cavalo já existe"));
		}
		
		Cavalo cavaloCriado = this.repository.save(cavalo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cavaloCriado);
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Cavalo cavalo) {
		Integer id = cavalo.getId();
		if (id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Resposta("Id não enviado pra requisição."));
		}
		Cavalo CavaloAtualizado = this.repository.save(cavalo);
		return ResponseEntity.status(HttpStatus.CREATED).body(CavaloAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		Optional<Cavalo> possivelCavalo = this.repository.findById(id);

		if (possivelCavalo.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Resposta("Cavalo não existe."));
		}
		
		this.repository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new Resposta("Cavalo deletado com sucesso!"));
	}
}

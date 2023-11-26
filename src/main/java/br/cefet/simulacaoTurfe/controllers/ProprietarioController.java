package br.cefet.simulacaoTurfe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.cefet.simulacaoTurfe.entities.Proprietario;
import br.cefet.simulacaoTurfe.entities.Resposta;
import br.cefet.simulacaoTurfe.repositories.ProprietarioRepository;

@RestController
@RequestMapping(value="/proprietarios")
public class ProprietarioController {
	@Autowired
	private ProprietarioRepository repository;
	
	@GetMapping
	public ResponseEntity findAll() {
		List<Proprietario> proprietarios = this.repository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(proprietarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById(@PathVariable Integer id) {
		Optional<Proprietario> possivelProprietario = this.repository.findById(id);

		if (possivelProprietario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Resposta("Proprietário não existe."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(possivelProprietario.get());
	}
	
	@PostMapping
	public ResponseEntity insert(@RequestBody Proprietario proprietario) {
		Proprietario proprietarioAchado = this.repository.findByNome(proprietario.getNome());
		
		if (proprietarioAchado != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Resposta("Proprietário já existe."));
		}
		
		Proprietario proprietarioCriado = this.repository.save(proprietario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proprietarioCriado);
	}
	
	@PutMapping
	public ResponseEntity update(@RequestBody Proprietario proprietario) {
		Integer id = proprietario.getId();
		if (id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Resposta("Id não enviado pra requisição."));
		}
		Proprietario proprietarioAtualizado = this.repository.save(proprietario);
		return ResponseEntity.status(HttpStatus.CREATED).body(proprietarioAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		Optional<Proprietario> possivelProprietario = this.repository.findById(id);

		if (possivelProprietario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Resposta("Proprietário não existe."));
		}
		
		this.repository.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new Resposta("Proprietário deletado com sucesso!"));
	}
}

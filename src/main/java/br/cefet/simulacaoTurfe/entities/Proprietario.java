package br.cefet.simulacaoTurfe.entities;

import jakarta.persistence.*;

@Entity
@Table(name="proprietario")
public class Proprietario {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String senha;
	
	public Proprietario (String nome, String cpf, String email, String telefone, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
	}
	
	public void atualiza(String nome, String cpf, String email, String telefone, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
	}
	
	public Proprietario () {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
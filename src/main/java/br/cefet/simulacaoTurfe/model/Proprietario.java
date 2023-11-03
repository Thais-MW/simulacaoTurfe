package br.cefet.simulacaoTurfe.model;

public class Proprietario {
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
	public Proprietario (String nome, String cpf, String email, String telefone) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setTelefone(telefone);
	}
	
	public Proprietario () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}

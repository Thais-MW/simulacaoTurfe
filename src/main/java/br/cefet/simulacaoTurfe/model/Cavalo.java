package br.cefet.simulacaoTurfe.model;

public class Cavalo {
	private int id;
	private String nome;
	private int numero;
	private String cor;
	private float preco;
	private int velocidade;
	private int resistencia;
	private Proprietario proprietario;

	public Cavalo(String nome, int numero, String cor, float preco, int velocidade, int resistencia, Proprietario proprietario) {
		this.setNome(nome);
		this.setNumero(numero);
		this.setCor(cor);
		this.setPreco(preco);
		this.setVelocidade(velocidade);
		this.setResistencia(resistencia);
		this.setProprietario(proprietario);
	}

	public Cavalo() {
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}

package br.cefet.simulacaoTurfe.model;

public class InscricaoCorrida {
	private int id;
	private Cavalo cavalo;
	private Corrida corrida;

	public InscricaoCorrida(Cavalo cavalo, Corrida corrida) {
		this.setCavalo(cavalo);
		this.setCorrida(corrida);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cavalo getCavalo() {
		return cavalo;
	}

	public void setCavalo(Cavalo cavalo) {
		this.cavalo = cavalo;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

}

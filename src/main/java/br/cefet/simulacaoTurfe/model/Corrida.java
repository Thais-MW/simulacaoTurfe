package br.cefet.simulacaoTurfe.model;

import java.sql.Timestamp;

public class Corrida {
	private int id;
	private Timestamp dataHora;
	private float taxaInscricao;

	public Corrida(Timestamp dataHora, float taxaInscricao) {
		this.setData(dataHora);
		this.setInscricao(taxaInscricao);
	}

	public Corrida() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getData() {
		return dataHora;
	}

	public void setData(Timestamp data) {
		this.dataHora = data;
	}

	public float getInscricao() {
		return taxaInscricao;
	}

	public void setInscricao(float inscricao) {
		this.taxaInscricao = inscricao;
	}
}

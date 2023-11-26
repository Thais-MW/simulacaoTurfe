package br.cefet.simulacaoTurfe.entities;


public class Resposta {
	private String mensagem;
	
	public Resposta(String msg) {
		this.setMensagem(msg);
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

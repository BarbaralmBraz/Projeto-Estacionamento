package modelo;

import java.io.Serializable;
import java.util.Date;
import modelo.Vaga;


public class Evento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9174897350757802492L;
	private String nome;
	private String data;
	private boolean liberarAcesso;
	private int numVagas;
	private String tipoVaga;
	private boolean vagasReservada;
	
	
	
	public Evento(String nome, String data, boolean liberarAcesso, int numVagas, String tipoVaga) {
		super();
		this.nome = nome;
		this.data = data;
		this.liberarAcesso = liberarAcesso;
		this.numVagas = numVagas;
		this.tipoVaga = tipoVaga;
		this.vagasReservada = false;
	}


	public boolean isVagasReservada() {
		return vagasReservada;
	}


	public void setVagasReservada(boolean vagasReservada) {
		this.vagasReservada = vagasReservada;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	public boolean isLiberarAcesso() {
		return liberarAcesso;
	}

	public void setLiberarAcesso(boolean liberarAcesso) {
		this.liberarAcesso = liberarAcesso;
	}
	
	

	public int getNumVagas() {
		return numVagas;
	}


	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}


	public String getTipoVaga() {
		return tipoVaga;
	}


	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}


	public String toString() {
		return "Nome do evento= " + this.nome + ", data do evento = " + this.data;
	}

}

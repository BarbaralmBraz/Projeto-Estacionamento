package modelo;

import java.io.Serializable;

public class Vaga implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6865878279061475128L;
	private int numeroVaga;
	private String placaVeiculo;
	private boolean disponivel;
	private boolean vagaEspecial;
	private String codigoReserva;

	
	
	public Vaga(int numeroVaga) {
		super();
		this.numeroVaga = numeroVaga;
		this.placaVeiculo = "";
		this.disponivel = true;
	}
	
	
	
	
	
	public int getNumeroVaga() {
		return this.numeroVaga;
	}
	
	
	
	
	
	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	
	
	
	
	
	public String getPlacaVeiculo() {
		return this.placaVeiculo;
	}
	
	
	
	
	
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	
	
	
	
	
	public boolean isDisponivel() {
		return this.disponivel;
	}
	
	
	
	
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
	
	
	
	
	public boolean isVagaEspecial() {
		return vagaEspecial;
	}





	public void setVagaEspecial(boolean vagaEspecial) {
		this.vagaEspecial = vagaEspecial;
	}





	public String getCodigoReserva() {
		return codigoReserva;
	}





	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}





	public String retornaDisponibilidade() {
		if (isDisponivel()) {
			return "Disponivel";
		}
		else { 
			return "Ocupada";
		}
		
	}
	
	
	
	public String toString() {
		return "Vaga: " + String.valueOf(this.numeroVaga) + " - " + retornaDisponibilidade();
	
	}
}

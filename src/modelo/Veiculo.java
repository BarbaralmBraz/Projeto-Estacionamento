package modelo;

import java.io.Serializable;

public class Veiculo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6239602922885569641L;
	//Abstraindo o objeto Aluno
	private String placa;
	private int id; //Representa��o de valor �nico para cada registro de cada ve�culo
	private String tipoVeiculo; //O tipo do ve�culo � uma caracteristica de ve�culo.
	private String proprietario;
	private String matriculaProprietario;
	
	
	public Veiculo(String placa, int id, String tipoVeiculo, String proprietario, String matriculaProprietario) {
		this.placa = placa;
		this.id = id;
		this.tipoVeiculo = tipoVeiculo;
		this.proprietario = proprietario;
		this.matriculaProprietario = matriculaProprietario;
		
		
	}
	
	public String getPlaca() {
		return placa;		
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	
	
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getMatriculaProprietario() {
		return matriculaProprietario;
	}

	public void setMatriculaProprietario(String matriculaProprietario) {
		this.matriculaProprietario = matriculaProprietario;
	}
	
	

	public String toString() {
		return "\n Placa do ve�culo:" + this.placa +  ",\n Id do ve�culo:" + String.valueOf(this.id) + ",\n Tipo do ve�culo:" + this.tipoVeiculo;
	}

	
	
	
	
	
	
	

}

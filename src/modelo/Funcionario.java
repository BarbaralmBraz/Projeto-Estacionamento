package modelo;

import java.io.Serializable;

public class Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5400852641533998566L;
	private String nome;
	private String matricula;
	private String areaEspecial;
	private String placa;
	
	
	public Funcionario(String nome, String matricula, String placa) {
		this.nome = nome;
		this.matricula = matricula;
		this.placa = placa;
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getAreaEspecial() {
		return areaEspecial;
	}


	public void setAreaEspecial(String areaEspecial) {
		this.areaEspecial = areaEspecial;
	}


	public String getPlaca() {
		return placa;
	}


	public void setVeiculo(String placa) {
		this.placa = placa;
	}


	public String toString() {
		return "Nome do funcionário =" + this.nome + ", Matrícula do funcionário=" + this.matricula + ", Permissão par Área Especial=" + this.areaEspecial
				+ ", Veículo =";
	}


	

	}

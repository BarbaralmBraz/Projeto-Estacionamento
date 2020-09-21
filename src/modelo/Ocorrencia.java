package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ocorrencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8059237330073834505L;
	private String categoria;
	private String data;
	private String titulo;
	private String ocorrencia;
	private String funcionario;
	private int id;
	private String tipoEstacionamento;
	
	
	public Ocorrencia(String categoria, String titulo,String ocorrencia, String funcionario, String tipoEstacionamento) {
		
		Date data = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		this.categoria = categoria;
		this.titulo = titulo;
		this.ocorrencia = ocorrencia;
		this.funcionario = funcionario;
		this.tipoEstacionamento = tipoEstacionamento;
		this.data = formato.format(data);
		
		
	}


	public String getTipoEstacionamento() {
		return tipoEstacionamento;
	}


	public void setTipoEstacionamento(String tipoEstacionamento) {
		this.tipoEstacionamento = tipoEstacionamento;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getOcorrencia() {
		return ocorrencia;
	}


	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}


	public String getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	
	public int getId() {
		return id;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}


	
	public String toString() {
		return "\nTitulo: " + titulo + " \ndata: " + data +  "\nOcorrência: "
				+ ocorrencia + "\nFuncionario: " + funcionario;
	}
	
	
	
	


}

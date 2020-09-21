package visao;

import controle.OcorrenciaEventos;
import controle.UsuarioEventos;
import controle.EventoEvento;
import controle.BaseDados;
import controle.EventoFuncionario;

import controle.AlunoEventos;
import controle.BaseDados;
import controle.CursoEventos;
import controle.VeiculoEventos;


import controle.VagaEventos;
public class Principal {
	
	private  BaseDados base = new BaseDados();
	private  EventoEvento controleEvento = new EventoEvento(base);
	private  VagaEventos controleVagas = new VagaEventos(base, this.controleEvento);
	private  OcorrenciaEventos controleOcorrencias = new OcorrenciaEventos(base);
	private  VeiculoEventos controleVeiculos = new VeiculoEventos(base);
	private  EventoFuncionario controleFuncionario = new EventoFuncionario(base);
	private  UsuarioEventos controleUsuario = new UsuarioEventos(base);
	
	

	public Principal() {
		
		//this.controleVagas.criarVagas("Carro", 100);
		//this.controleVagas.criarVagas("Moto", 20);
		//this.controleVagas.criarVagas("Onibus", 10);
		
		
		this.controleEvento.ocupaVagaEvento();
		
		
		
	}
		
	public void cadastrarVeiculo(String placa, String tipoVeiculo, String proprietario, String matriculaProprietario) {
		try {
			controleVeiculos.cadastrarVeiculo(placa, tipoVeiculo, proprietario, matriculaProprietario);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	public void ocuparVaga(String placa, int vaga, String tipoVeiculo) {
		try {
			controleVagas.ocupaVaga(placa, vaga, tipoVeiculo);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	public void reservarVagas(String tipoVaga, String codigo, int numVagas) {
		try {
			controleVagas.reservarVagas(tipoVaga, codigo, numVagas);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	
	
	
	public void cadastrarFuncionario(String nome, String matricula, String placa) {
		try {
			controleFuncionario.cadastrarFuncionario(nome, matricula, placa);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	
	public String [][] retornaFuncionarios(){
		try {
			
			return this.controleFuncionario.retornaFuncionarios();
				
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	
	public void cadastrarOcorrencia(String categoria, String titulo, String ocorrencia, String funcionario, String tipoEstacionamento) {
		try {
			controleOcorrencias.criarOcorrencia(categoria, titulo, ocorrencia, funcionario, tipoEstacionamento);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	
		
	public void liberarVaga(int vaga, String tipoVeiculo) {
		try {
			controleVagas.liberarVaga(vaga, tipoVeiculo);
			
		}
		
		catch(Exception e) {
			throw e;
		}
		
	}
	
	public String [][] listarVagas(String tipoVaga) {
		try {
			
			return this.controleVagas.listarVagas(tipoVaga);
			
				
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	public String [][] retornaOcorrenciasData(String data){
		try {
			
			return this.controleOcorrencias.retornaOcorrenciasData(data);
			
				
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	public String [][] retornaOcorrenciasTipoEstacionamento(String tipoEstacionamento){
		try {
			
			return this.controleOcorrencias.retornaOcorrenciasTipoEstacionamento(tipoEstacionamento);
			
				
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	
	public String [][] retornaVeiculosTipo(String tipoVeiculo){
		try {
			
			return this.controleVeiculos.retornaVeiculos(tipoVeiculo);
			
				
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	
	public String [][] retornaVeiculoPlaca(String placa){
		try {
			
			return this.controleVeiculos.retornaVeiculoPlaca(placa);
			
				
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	public void adicionarPermissao(String placa, String codigo) {
		try {
			this.controleVagas.adicionarPermissao(placa, codigo);
		}
		
		catch(Exception e) {
			throw e;
		}	
		
	}
	
	public void liberarAreasEspeciais(String codigo) {
		try {
			this.controleVagas.removerReserva(codigo);
			
		}
		
		catch(Exception e) {
			throw e;
		}	
	}
	
	public void removerVeiculo(String placa) {
		try {
			
			
			this.controleVeiculos.removerVeiculo(placa);
		}
		
		catch (Exception e) {
			throw e;
		}
	}
	
	public void adicionarEvento(String nome, String data, boolean permissao, int numVagas, String tipoVaga) {
		try {
			
			
			this.controleEvento.adicionarEvento(nome,data, permissao, numVagas, tipoVaga);
		}
		
		catch (Exception e) {
			throw e;
		}
	}
	
	public String [][] retornaRelatorios(String data) {
		
		try {
			
			
			return this.controleVagas.retornaRelatorios(data);
		}
		
		catch (Exception e) {
			throw e;
		}
	}
	
	public String retornaTipoUsuario(String login, String senha) {
		try {
			return this.controleUsuario.retornaTipoUsuario(login, senha);
		}
		
		catch (Exception e) {
			throw e;
		}
	}
	
	
			
}		
		
			
			
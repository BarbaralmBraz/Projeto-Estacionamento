package controle;

import java.util.ArrayList;//ArrayLista é uma extensão de List (tem algo a mais)
import modelo.Usuario;
import java.util.HashMap;
import java.util.List;

import modelo.Aluno;
import modelo.Curso;
import modelo.Evento;
import modelo.Funcionario;
import modelo.Login;
import modelo.Ocorrencia;
import modelo.Vaga;
import modelo.Veiculo;
import serializacao.Empacotamento;
public class BaseDados {

	private static String diretorioAtual = System.getProperty("user.dir").replace("\\", "/");
	private List<Vaga> vagasCarro;
	private List<Vaga> vagasMoto;
	private List<Vaga> vagasOnibus;
	private List<Ocorrencia> ocorrencias;
	private HashMap<String, List<String>> areasEspeciais;
	private List<Evento> eventos;
	private HashMap<String, List<String>> relatorios;
	private HashMap<String, Usuario> usuarios;

	public static List<Curso> listaCurso = new ArrayList<Curso> (); //static por que os dados serão guardados em memória e poderão ser acessados depois. Esta List serve para armazenar(guardar) os cursos(objeto) na classe BancoDados.
	private static int idCurso = 0;

	// Construtor vazio, porque so serve para representar os dados desta classe, ele é inacessível.
	public BaseDados() {	
		carregarDados();
	}

	//método simples para id curso
	public static int proximoIdCurso() {
		idCurso = idCurso + 1;
		return idCurso;
	}

	//Criando lista de alunos
	public static List<Aluno> listaAluno = new ArrayList<Aluno> (); 
	private static int alunoMatricula=0;


	public static int proximaMatriculaAluno() {
		alunoMatricula = alunoMatricula +1;
		return alunoMatricula;	
	}

	//Criando lista de veículos
	private List<Veiculo> listaVeiculo = new ArrayList<Veiculo> (); 
	private static int idVeiculo=0;


	public void adicionarVeiculo(Veiculo veiculo) {
		listaVeiculo.add(veiculo);
		Empacotamento.gravarArquivoBinario(listaVeiculo, BaseDados.diretorioAtual + "/dados/LVeiculos.ser");
	}

	public List<Veiculo> getVeiculos(){
		return listaVeiculo;
	}

	public void removerVeiculo(String placa) {
		int indice = 0;
		boolean encontrou = false;
		while(indice < listaVeiculo.size() && !encontrou) {
			Veiculo veiculo =  listaVeiculo.get(indice);
			if(veiculo.getPlaca().equals(placa)) {
				listaVeiculo.remove(indice);
				encontrou = true;
				Empacotamento.gravarArquivoBinario(listaVeiculo, BaseDados.diretorioAtual + "/dados/LVeiculos.ser");


			} 
			indice++;


		}


		if(!encontrou) {
			throw new IllegalArgumentException ("Veículo inexistente!");
		}

	}

	public static int proximoIdVeiculo() {
		idVeiculo = idVeiculo +1;
		return idVeiculo;	
	}


	public List<Vaga> retornaLista(String tipoVaga) {
		String tipoVagaMinusculo = tipoVaga.toLowerCase();
		if (tipoVagaMinusculo.equals("carro")) {
			return vagasCarro;
		}


		else if (tipoVagaMinusculo.equals("moto")) {
			return vagasMoto;
		}

		else if (tipoVagaMinusculo.equals("onibus")) {
			return vagasOnibus;
		}

		else {
			return null;
		}
	}

	public void adicionarVagas(String tipoVaga, int numeroVagas) {
		try {
			List<Vaga> lista = retornaLista(tipoVaga);
			int numeroElementos = lista.size();
			for (int i = 0; i < numeroVagas; i++ ) {
				Vaga vaga = new Vaga(numeroElementos); 
				lista.add(numeroElementos++, vaga);

			}

			String nomeArquivo;

			if(tipoVaga.equals("Carro")) {
				nomeArquivo = "/dados/VCarro.ser";
			}

			else if (tipoVaga.equals("Moto")) {
				nomeArquivo = "/dados/VMoto.ser";
			}

			else {
				nomeArquivo = "/dados/VOnibus.ser";
			}

			Empacotamento.gravarArquivoBinario(lista, BaseDados.diretorioAtual + nomeArquivo);


		}
		catch (Exception e) {
			throw e;
		}

	}

	public void alteraVaga(int numeroVaga, Vaga vaga, String tipoVaga) {

		List<Vaga> lista = retornaLista(tipoVaga);
		lista.set(numeroVaga, vaga);

		String nomeArquivo;

		if(tipoVaga.equals("Carro")) {
			nomeArquivo = "/dados/VCarro.ser";
		}

		else if (tipoVaga.equals("Moto")) {
			nomeArquivo = "/dados/VMoto.ser";
		}

		else {
			nomeArquivo = "/dados/VOnibus.ser";
		}

		Empacotamento.gravarArquivoBinario(lista,BaseDados.diretorioAtual + nomeArquivo);


	}


	public Vaga retornaVaga(int numeroVaga, String tipoVaga) {

		List<Vaga> lista = retornaLista(tipoVaga);
		Vaga retorno = lista.get(numeroVaga);
		return retorno;
	}


	public void adicionarOcorrencia(Ocorrencia ocorrencia) {


		int numeroElementos = ocorrencias.size();
		ocorrencia.setId(numeroElementos);
		ocorrencias.add(ocorrencia);

		Empacotamento.gravarArquivoBinario(ocorrencias, BaseDados.diretorioAtual + "/dados/Ocorrencias.ser");
	}

	public int retornaNumOcorrencias() {
		return this.ocorrencias.size();
	}


	public List<Ocorrencia> retornaOcorrencias(){
		return ocorrencias;
	}


	public int retornaNumVagas(String tipoVaga) {
		List<Vaga> lista = retornaLista(tipoVaga);
		return lista.size();

	}

	public int retornaVagasDisponiveis(String tipoVaga) {
		List<Vaga> lista = retornaLista(tipoVaga);
		int retorno = 0;
		for (Vaga vaga : lista) {
			if (vaga.isDisponivel()) {
				retorno += 1;
			}
		}
		return retorno;

	}

	// Criando lista de Funcionários
	private List<Funcionario> listaFuncionario; 
	private static int matriculaEvento=0;

	public void adicionarFuncionario(Funcionario funcionario) {
		listaFuncionario.add(funcionario);
		Empacotamento.gravarArquivoBinario(listaFuncionario, BaseDados.diretorioAtual + "/dados/Funcionarios.ser");
	}

	public List<Funcionario> getFuncionarios(){
		return listaFuncionario;
	}



	public static int proximoFuncionario() {
		matriculaEvento = matriculaEvento +1;
		return matriculaEvento;
	}


	// Registrando logins
	public static List<Login> listaLogin = new ArrayList<Login> (); 
	private static String usuarioEvento;


	public static String proximoLogin() {
		usuarioEvento = usuarioEvento +1;
		return usuarioEvento;
	}

	public void addAreaEspecial(String codigo) {
		List<String> lista = new ArrayList<String>();
		this.areasEspeciais.put(codigo, lista);
		Empacotamento.gravarArquivoBinario(areasEspeciais, BaseDados.diretorioAtual + "/dados/Especiais.ser");

	}

	public void adicionarPermissao(String codigo, String placa) {
		this.areasEspeciais.get(codigo).add(placa);
		Empacotamento.gravarArquivoBinario(areasEspeciais, BaseDados.diretorioAtual + "/dados/Especiais.ser");

	}

	public List<String> retornaPermissoes(String codigo){
		return this.areasEspeciais.get(codigo);
	}


	public boolean retornaExisteRerserva(String codigo){
		return this.areasEspeciais.containsKey(codigo);
	}

	public void adicionarEvento(Evento evento) {
		this.eventos.add(evento);
		Empacotamento.gravarArquivoBinario(eventos, BaseDados.diretorioAtual + "/dados/Eventos.ser");
	}

	public void removerEvento(int indice) {
		this.eventos.remove(indice);
		Empacotamento.gravarArquivoBinario(eventos, BaseDados.diretorioAtual + "/dados/Eventos.ser");
	}

	public int retornaNumEventos() {
		return this.eventos.size();
	}

	public List<Evento>getEventos(){
		return this.eventos;
	}

	public void alteraEvento(int indice, Evento evento) {
		try {
			this.eventos.set(indice, evento);
			Empacotamento.gravarArquivoBinario(this.eventos, BaseDados.diretorioAtual + "/dados/Eventos.ser");

		}

		catch(Exception e) {
			System.out.println(e);
		}

	}

	public List<String>retornaRelatorio(String data){
		if(this.relatorios.containsKey(data)) {
			return this.relatorios.get(data);
		}
		else {
			throw new IllegalArgumentException("Relatorio inexisgente!");
		}

	}


	public void addLinhaRelatorio(String linha, String data) {
		try {
			if(this.relatorios.containsKey(data)) {
				this.relatorios.get(data).add(linha);
			}

			else {
				List<String> lista = new ArrayList<String>();
				lista.add(linha);
				this.relatorios.put(data, lista);

			}

			Empacotamento.gravarArquivoBinario(this.relatorios, BaseDados.diretorioAtual + "/dados/Relatorios.ser");
		}


		catch(Exception e) {
			throw e;
		}

	}
	
	public void adicionaUsuario(Usuario usuario) {
		String login = usuario.getLogin();
		usuarios.put(login, usuario);
		
	}
	
	public boolean usuarioExiste(String login) {
		return usuarios.containsKey(login);
	}
	
	public Usuario retornaUsuario(String login) {
		return usuarios.get(login);
		
	}



	private void carregarDados() {
		try {
			vagasCarro = (List<Vaga>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/VCarro.ser");

		}
		catch (Exception e) {
			vagasCarro = new ArrayList<Vaga>();

		}

		try {
			vagasMoto = (List<Vaga>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/VMoto.ser");

		}
		catch (Exception e) {
			vagasMoto = new ArrayList<Vaga>();
		}


		try {
			vagasOnibus = (List<Vaga>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/VOnibus.ser");

		}
		catch (Exception e) {
			vagasOnibus = new ArrayList<Vaga>();
		}


		try {
			ocorrencias = (List<Ocorrencia>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/Ocorrencias.ser");

		}
		catch (Exception e) {
			ocorrencias = new ArrayList<Ocorrencia>();
		}


		try {
			listaVeiculo = (List<Veiculo>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/LVeiculos.ser");

		}
		catch (Exception e) {
			listaVeiculo = new ArrayList<Veiculo>();
			System.out.println(BaseDados.diretorioAtual + "/dados/LVeiculos.ser");
		}


		try {
			listaFuncionario = (List<Funcionario>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/Funcionarios.ser");

		}
		catch (Exception e) {
			listaFuncionario = new ArrayList<Funcionario>();
		}


		try {
			areasEspeciais =  (HashMap<String, List<String>>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/Especiais.ser");

		}
		catch (Exception e) {
			areasEspeciais = new HashMap<String, List<String>>();

		}

		try {
			eventos =  (List<Evento>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/Eventos.ser");

		}
		catch (Exception e) {
			eventos = new ArrayList<Evento>();

		}


		try {
			relatorios =  (HashMap<String, List<String>>) Empacotamento.lerArquivoBinario(BaseDados.diretorioAtual + "/dados/Relatorios.ser");

		}
		catch (Exception e) {
			relatorios = new HashMap<String, List<String>>();

		}
		
		usuarios = new HashMap<String, Usuario>();

	}



}


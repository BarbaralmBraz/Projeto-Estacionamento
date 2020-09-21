
   package telas;

import java.awt.BorderLayout;
import telas.TelaLogin;
import telas.GerarRelatorios;
import telas.CadastrarEventos;
import telas.AreasEspeciais;
import telas.AreasEspeciais;
import telas.CadastrarFuncionarios;
import telas.ListarVeiculos;
import telas.CadastrarOcorrencia;
import telas.LiberarVaga;
import visao.Principal;
import java.awt.EventQueue;
import java.awt.Font;
import telas.OcuparVaga;
import telas.ListarVagas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import telas.CadastrarVeiculos;
import telas.MonitorarEstacionamento;
import main.Main;
import telas.ListarOcorrencias;
import telas.RemoverVeiculo;
public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private CadastrarVeiculos cadastroAluno;
	private OcuparVaga ocuparVaga;
	private JTabbedPane tabbedPane;
	private Principal principal;
	private LiberarVaga liberarVaga;
	private ListarVagas listarVagas;
	private MonitorarEstacionamento monitorarEstacionamento;
	private Main main;
	private CadastrarOcorrencia cadastrarOcorrencia;
	private ListarOcorrencias listarOcorrencias;
	private ListarVeiculos listarVeiculos;
	private CadastrarFuncionarios cadastrarFuncionarios;
	private AreasEspeciais areasEspeciais;
	private AdicionarPermissoes adicionarPermissoes;
	private RemoverVeiculo removerVeiculo;
	private CadastrarEventos cadastrarEventos;
	private GerarRelatorios gerarRelatorios;
	private TelaLogin telaLogin;
	
	
	private int idLogin =  0;
	private int idTelaOcupar = 1;
	private int idTelaLiberar = 2;
	private int idTelaListar = 3;
	private int idFuncionario = 4;
	private int idGestor = 5;
	private int idRh = 6;
	private int idAtual;
	
	/**
	 * Launch the application.
	 */
	
	public JanelaPrincipal(Main main) {
		this.main = main;
		
		
		this.principal = new Principal();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
	}
	
	
	public void carregaTelaOcupar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.ocuparVaga = new OcuparVaga(this.principal, this, idAtual);
		this.contentPane.add(this.ocuparVaga,BorderLayout.CENTER);
		setContentPane(contentPane);
	}
	
	public void carregaTelaLiberar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.liberarVaga = new LiberarVaga(this.principal, this, idAtual);
		this.contentPane.add(this.liberarVaga,BorderLayout.CENTER);
		setContentPane(contentPane);
	}
	
	public void carregaTelaListar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.listarVagas = new ListarVagas(this.principal, this, idAtual);
		this.contentPane.add(this.listarVagas,BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}
	
	
	
	public void carregaAbasFuncionario() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.cadastroAluno = new CadastrarVeiculos(this.principal, this);
		this.removerVeiculo = new RemoverVeiculo(this.principal);
		this.monitorarEstacionamento = new MonitorarEstacionamento(this);
		this.cadastrarOcorrencia = new CadastrarOcorrencia(this.principal, this);
		this.cadastrarEventos = new CadastrarEventos(this.principal);
		
		
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));

		this.tabbedPane.addTab("Cadastrar Veiculo", this.cadastroAluno);
		this.tabbedPane.addTab("Remover Veiculo", this.removerVeiculo);
		this.tabbedPane.addTab("Monitorar Estacionamento", this.monitorarEstacionamento);
		this.tabbedPane.addTab("Cadastrar Ocorrências", this.cadastrarOcorrencia);
		this.tabbedPane.addTab("Cadastrar Eventos", this.cadastrarEventos);
		
		
		
		
		
		
		
		
		this.contentPane.add(this.tabbedPane,BorderLayout.CENTER);
		
		
		setContentPane(contentPane);
	}
	
	
	public void addAbasGestor() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.monitorarEstacionamento = new MonitorarEstacionamento(this);
		this.areasEspeciais = new AreasEspeciais(this.principal);
		this.adicionarPermissoes = new AdicionarPermissoes(this.principal);
		this.gerarRelatorios = new GerarRelatorios(this.principal);
		this.cadastrarEventos = new CadastrarEventos(this.principal);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		this.tabbedPane.addTab("Monitorar Estacionamento", this.monitorarEstacionamento);
		this.tabbedPane.addTab("Criar Áreas Especiais", this.areasEspeciais);
		this.tabbedPane.addTab("Adicionar Permissões", this.adicionarPermissoes);
		this.tabbedPane.addTab("Gerar Relatorios", this.gerarRelatorios);
		this.tabbedPane.addTab("Cadastrar Eventos", this.cadastrarEventos);
		
		
		this.contentPane.add(this.tabbedPane,BorderLayout.CENTER);
		
		
		setContentPane(contentPane);
	}
	
	
	public void addAbasRh() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		this.cadastrarFuncionarios = new CadastrarFuncionarios(this.principal);
		this.adicionarPermissoes = new AdicionarPermissoes(this.principal);
		
		
		this.tabbedPane.addTab("Adicionar Permissões", this.adicionarPermissoes);
		this.tabbedPane.addTab("Cadastrar Funcionários", this.cadastrarFuncionarios);
		
		
		this.contentPane.add(this.tabbedPane,BorderLayout.CENTER);
		
		
		setContentPane(contentPane);
	}
	
	
	public void carregaLogin() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.telaLogin = new TelaLogin(this.principal, this);
		this.contentPane.add(this.telaLogin,BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}
	
	
	public void setIdAtual(int idAtual) {
		this.idAtual = idAtual;
	}
	
	
	public void iniciarTela(int opcao) {
		if (opcao == idLogin) {
			this.carregaLogin();
		}
		else if (opcao == idTelaOcupar ) {
			this.carregaTelaOcupar();
		}
		
		else if (opcao == idTelaLiberar) {
			this.carregaTelaLiberar();
		}
		
		else if (opcao == idTelaListar) {
			this.carregaTelaListar();
		}
		
		else if(opcao == idFuncionario) {
			this.carregaAbasFuncionario();
			this.idAtual = idFuncionario;
		}
		
		else if(opcao == idGestor) {
			this.addAbasGestor();
			this.idAtual = idGestor;
		}
		
		else if(opcao == idRh) {
			this.addAbasRh();
			this.idAtual = idRh;
		}
	}
	
	public void reload(int opcao) {
		this.main.reload(opcao, this.idAtual);
	}
	
	
	public void listarOcorrencias() {
		this.listarOcorrencias = new ListarOcorrencias(this.principal, this);
		
		this.tabbedPane.setComponentAt(3, this.listarOcorrencias);
		
	}
	
	
	public void voltarListarOcorrencias() {
		this.cadastrarOcorrencia = new CadastrarOcorrencia(this.principal, this);
		this.tabbedPane.setComponentAt(3, this.cadastrarOcorrencia);
		
	}
	
	public void listarVeiculo() {
		this.listarVeiculos = new ListarVeiculos(this.principal, this);
		
		this.tabbedPane.setComponentAt(0, this.listarVeiculos);
		
	}
	
	
	public void voltarListarVeiculos() {
		this.cadastroAluno = new CadastrarVeiculos(this.principal, this);
		this.tabbedPane.setComponentAt(0, this.cadastroAluno);
		
	}

}

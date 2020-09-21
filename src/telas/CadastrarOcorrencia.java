package telas;

import javax.swing.JPanel;
import telas.JanelaPrincipal;
import visao.Principal;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;

public class CadastrarOcorrencia extends JPanel {
	private JTextField valTitulo;
	private JTextField valData;
	private JTextField valFuncionario;
	private JComboBox opcoesCategoria;
	private JComboBox opcoesEstacionamento;
	private JTextPane valOcorrencia;
	private Principal principal;
	private JanelaPrincipal janelaPrincipal;

	/**
	 * Create the panel.
	 */
	public CadastrarOcorrencia(Principal principal, JanelaPrincipal janelaPrincipal) {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		this.principal = principal;
		this.janelaPrincipal = janelaPrincipal;
		
		setLayout(null);
		
		JLabel cadastrarOcorrencia = new JLabel("Cadastrar Ocorr\u00EAncia");
		cadastrarOcorrencia.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		cadastrarOcorrencia.setBounds(130, 11, 345, 70);
		add(cadastrarOcorrencia);
		
		JLabel titulo = new JLabel("T\u00EDtulo:");
		titulo.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		titulo.setBounds(33, 130, 66, 14);
		add(titulo);
		
		valTitulo = new JTextField();
		valTitulo.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		valTitulo.setBounds(139, 127, 190, 20);
		add(valTitulo);
		valTitulo.setColumns(10);
		
		JLabel data = new JLabel("Data:");
		data.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		data.setBounds(371, 89, 46, 14);
		add(data);
		
		valData = new JTextField();
		valData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valData.setBounds(473, 84, 86, 20);
		add(valData);
		valData.setColumns(10);
		
		JLabel estacinonamento = new JLabel("Estacionamento:");
		estacinonamento.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		estacinonamento.setBounds(33, 169, 134, 14);
		add(estacinonamento);
		
		JLabel categoria = new JLabel("Categoria:");
		categoria.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		categoria.setBounds(371, 130, 102, 14);
		add(categoria);
		
		JLabel ocorrencia = new JLabel("Ocorr\u00EAncia:");
		ocorrencia.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		ocorrencia.setBounds(29, 194, 102, 14);
		add(ocorrencia);
		
		JLabel funcionario = new JLabel("Funcion\u00E1rio:");
		funcionario.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		funcionario.setBounds(29, 89, 102, 14);
		add(funcionario);
		
		valFuncionario = new JTextField();
		valFuncionario.setBounds(140, 86, 189, 20);
		add(valFuncionario);
		valFuncionario.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnLimpar.setBounds(91, 345, 89, 33);
		add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnCadastrar.setBounds(386, 345, 102, 33);
		add(btnCadastrar);
		
		
		String[]opcoesEst = {"Carro", "Moto", "Ônibus"};
		String[]tipoOcorrencia = {"Sinistro", "Furto ou Roubo", "Estac.Indevido", "Inundação", "Dano ao Veículo", "Outros"};
		
		
		
		opcoesEstacionamento = new JComboBox(opcoesEst);
		opcoesEstacionamento.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		opcoesEstacionamento.setBounds(177, 160, 102, 26);
		add(opcoesEstacionamento);
		
		opcoesCategoria = new JComboBox(tipoOcorrencia);
		opcoesCategoria.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		opcoesCategoria.setBounds(468, 127, 102, 20);
		add(opcoesCategoria);
		
		valOcorrencia = new JTextPane();
		valOcorrencia.setBackground(UIManager.getColor("Button.background"));
		valOcorrencia.setForeground(Color.BLACK);
		valOcorrencia.setBounds(29, 218, 530, 100);
		add(valOcorrencia);
		
		JButton listarOcorrencias = new JButton("Listar");
		listarOcorrencias.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		listarOcorrencias.setBounds(240, 345, 89, 33);
		add(listarOcorrencias);

		
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		
		listarOcorrencias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listarOcorrencias();
			}
		});
	}
	
	private void limpar() {
		valTitulo.setText("");
		valData.setText("");
		valFuncionario.setText("");
		valOcorrencia.setText("");
		
		
	}
	
	private void cadastrar() {
		try {
			if (valTitulo.getText().equals("") || valData.getText().equals("")  
					|| valFuncionario.getText().equals("") || valOcorrencia.getText().equals("")) {
				throw new IllegalArgumentException("Campos Vazios");
				
			}
			
			
			
			
			String titulo = valTitulo.getText();
			String data = valData.getText();
			String funcionario = valFuncionario.getText();
			String ocorrencia = valOcorrencia.getText();
			String tipoVaga = (String)opcoesEstacionamento.getSelectedItem();
			String tipoCategoria = (String)opcoesCategoria.getSelectedItem();
			
			
			
			
			this.principal.cadastrarOcorrencia(tipoCategoria, titulo, ocorrencia, funcionario, tipoVaga);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Ocorrência Cadastrada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void listarOcorrencias() {
		this.janelaPrincipal.listarOcorrencias();
	}
}

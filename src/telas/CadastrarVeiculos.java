package telas;

import javax.swing.JPanel;
import telas.JanelaPrincipal;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class CadastrarVeiculos extends JPanel {
	private JTextField valNomeAluno;
	private JTextField valMatriculaAluno;
	private JTextField valPlaca;
	private final ButtonGroup tipoGroup = new ButtonGroup();
	private JRadioButton tipoCarro;
	private JRadioButton tipoMoto;
	private JRadioButton tipoOnibus;
	private Principal principal;
	private JanelaPrincipal janelaPrincipal;
	

	/**
	 * Create the panel.
	 */
	public CadastrarVeiculos(Principal principal, JanelaPrincipal janelaPrincipal) {
		
		this.principal = principal;
		this.janelaPrincipal = janelaPrincipal;
		
		setBackground(Color.WHITE);
		setForeground(SystemColor.desktop);
		setLayout(null);
		
		JLabel titulo = new JLabel("Cadastrar Novos Ve\u00EDculos");
		titulo.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		titulo.setBounds(117, 32, 403, 34);
		add(titulo);
		
		JLabel nomeAluno = new JLabel("Nome:\r\n");
		nomeAluno.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		nomeAluno.setBounds(97, 93, 86, 24);
		add(nomeAluno);
		
		valNomeAluno = new JTextField();
		valNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valNomeAluno.setBounds(97, 116, 247, 20);
		add(valNomeAluno);
		valNomeAluno.setColumns(10);
		
		JLabel matriculaAluno = new JLabel("Matr\u00EDcula:");
		matriculaAluno.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		matriculaAluno.setBounds(97, 153, 86, 20);
		add(matriculaAluno);
		
		valMatriculaAluno = new JTextField();
		valMatriculaAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valMatriculaAluno.setBounds(97, 175, 247, 20);
		add(valMatriculaAluno);
		valMatriculaAluno.setColumns(10);
		
		JLabel tipo = new JLabel("Tipo Veiculo:");
		tipo.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipo.setBounds(97, 212, 109, 14);
		add(tipo);
		
		JLabel placa = new JLabel("Placa:");
		placa.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		placa.setBounds(97, 278, 56, 14);
		add(placa);
		
		valPlaca = new JTextField();
		valPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valPlaca.setBounds(97, 296, 247, 20);
		add(valPlaca);
		valPlaca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnCadastrar.setBounds(374, 351, 99, 34);
		add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		btnLimpar.setBounds(97, 351, 89, 34);
		add(btnLimpar);
		
		tipoCarro = new JRadioButton("Carro");
		tipoCarro.setBackground(Color.WHITE);
		tipoCarro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoGroup.add(tipoCarro);
		tipoCarro.setBounds(97, 233, 109, 23);
		add(tipoCarro);
		
		tipoMoto = new JRadioButton("Moto");
		tipoMoto.setBackground(Color.WHITE);
		tipoMoto.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoGroup.add(tipoMoto);
		tipoMoto.setBounds(239, 233, 109, 23);
		add(tipoMoto);
		
		tipoOnibus = new JRadioButton("\u00D4nibus");
		tipoOnibus.setBackground(Color.WHITE);
		tipoOnibus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoGroup.add(tipoOnibus);
		tipoOnibus.setBounds(374, 233, 109, 23);
		add(tipoOnibus);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListar.setBounds(240, 349, 89, 36);
		add(btnListar);
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		
		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listarVeiculo();
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});

	}
	
	private void limpar() {
		valNomeAluno.setText("");
		valMatriculaAluno.setText("");
		valPlaca.setText("");
		tipoCarro.setSelected(false);
		tipoMoto.setSelected(false);
		tipoOnibus.setSelected(false);
		
		
		
	}
	
	private void cadastrar() {
		try {
			if (valNomeAluno.getText().equals("") || valMatriculaAluno.getText().equals("") || valPlaca.getText().equals("")) {
				throw new IllegalArgumentException("Campos vazios!");
				
			}
			
			if (!tipoCarro.isSelected() && !tipoMoto.isSelected() && !tipoOnibus.isSelected()) {
				throw new IllegalArgumentException("Selecione um tipo de veículo.");
				
			}
			
			String nome = valNomeAluno.getText();
			String matricula = valMatriculaAluno.getText();
			String placa = valPlaca.getText();
			String tipo;
			
			if(tipoCarro.isSelected()) {
				tipo = "Carro";
				
			}
			
			else if(tipoMoto.isSelected()) {
				tipo = "Moto";
			}
			
			else {
				tipo = "Onibus";
			}
			
			this.principal.cadastrarVeiculo(placa, tipo, nome, matricula);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Veiculo Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void listarVeiculo() {
		this.janelaPrincipal.listarVeiculo();
	}
}

package telas;

import javax.swing.JPanel;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CadastrarFuncionarios extends JPanel {
	private JTextField valNome;
	private JTextField valMatricula;
	private JTextField valPlaca;
	private Principal principal;

	/**
	 * Create the panel.
	 */
	public CadastrarFuncionarios(Principal principal) {
		setBackground(new Color(255, 255, 255));
		this.principal = principal;
		
		setLayout(null);
		
		JLabel cadastrarFuncionario = new JLabel("Cadastrar Funcion\u00E1rios");
		cadastrarFuncionario.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		cadastrarFuncionario.setBounds(98, 27, 371, 56);
		add(cadastrarFuncionario);
		
		JLabel nomeFuncionario = new JLabel("Nome:");
		nomeFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		nomeFuncionario.setBounds(42, 120, 74, 14);
		add(nomeFuncionario);
		
		JLabel matriculaFuncionario = new JLabel("Matr\u00EDcula:\r\n");
		matriculaFuncionario.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		matriculaFuncionario.setBounds(42, 183, 93, 14);
		add(matriculaFuncionario);
		
		JLabel placa = new JLabel("Placa:");
		placa.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		placa.setBounds(42, 255, 46, 14);
		add(placa);
		
		valNome = new JTextField();
		valNome.setBounds(128, 117, 245, 20);
		add(valNome);
		valNome.setColumns(10);
		
		valMatricula = new JTextField();
		valMatricula.setBounds(130, 180, 145, 20);
		add(valMatricula);
		valMatricula.setColumns(10);
		
		valPlaca = new JTextField();
		valPlaca.setBounds(127, 252, 114, 20);
		add(valPlaca);
		valPlaca.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnLimpar.setBounds(84, 325, 89, 36);
		add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnCadastrar.setBounds(401, 325, 114, 36);
		add(btnCadastrar);
		
		
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
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
		valNome.setText("");
		valMatricula.setText("");
		valPlaca.setText("");
		
		
		
		
	}
	
	private void cadastrar() {
		try {
			if (valNome.getText().equals("") || valMatricula.getText().equals("") || valPlaca.getText().equals("")) {
				throw new IllegalArgumentException("Campos vazios!");
				
			}
			
			
			
			String nome = valNome.getText();
			String matricula = valMatricula.getText();
			String placa = valPlaca.getText();
			
			
			
			
			this.principal.cadastrarFuncionario(nome, matricula, placa);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Funcionário Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}

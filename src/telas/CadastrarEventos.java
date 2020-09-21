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
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class CadastrarEventos extends JPanel {
	private JTextField valEvento;
	private JTextField valData;
	private JTextField valVagas;
	private Principal principal;
	private JComboBox tipoVaga;
	private JComboBox acesso;

	/**
	 * Create the panel.
	 */
	public CadastrarEventos(Principal principal) {
		setBackground(new Color(255, 255, 255));
		this.principal = principal;
		
		
		setLayout(null);
		
		JLabel cadastrarEvento = new JLabel("Cadastrar Evento");
		cadastrarEvento.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		cadastrarEvento.setBounds(166, 34, 280, 38);
		add(cadastrarEvento);
		
		JLabel nomeEvento = new JLabel("Nome do Evento:");
		nomeEvento.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		nomeEvento.setBounds(28, 97, 144, 25);
		add(nomeEvento);
		
		valEvento = new JTextField();
		valEvento.setBounds(201, 99, 269, 20);
		add(valEvento);
		valEvento.setColumns(10);
		
		JLabel tipoEsationamento = new JLabel("Estacionamento:");
		tipoEsationamento.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoEsationamento.setBounds(45, 233, 128, 14);
		add(tipoEsationamento);
		
		JLabel data = new JLabel("Data:");
		data.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		data.setBounds(412, 233, 46, 14);
		add(data);
		
		valData = new JTextField();
		valData.setBounds(468, 230, 111, 20);
		add(valData);
		valData.setColumns(10);
		
		JLabel vagas = new JLabel("Vagas para o evento:");
		vagas.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		vagas.setBounds(300, 167, 179, 14);
		add(vagas);
		
		JLabel usuarios = new JLabel("Liberar Acesso:");
		usuarios.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		usuarios.setBounds(45, 167, 127, 14);
		add(usuarios);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.setBounds(401, 321, 111, 38);
		add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpar.setBounds(97, 321, 89, 38);
		add(btnLimpar);
		
		String[]opcoesAcesso = {"Sim", "Não"};
		String[]opcoesVaga = {"Carro", "Moto", "Onibus"};
		
		tipoVaga = new JComboBox(opcoesVaga);
		tipoVaga.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoVaga.setBackground(UIManager.getColor("Button.light"));
		tipoVaga.setBounds(201, 230, 89, 20);
		add(tipoVaga);
		
		valVagas = new JTextField();
		valVagas.setBounds(468, 164, 86, 20);
		add(valVagas);
		valVagas.setColumns(10);
		
		acesso = new JComboBox(opcoesAcesso);
		acesso.setBackground(UIManager.getColor("Button.light"));
		acesso.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		acesso.setBounds(201, 164, 71, 20);
		add(acesso);

		
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
	}
	
	private void limpar() {
		valEvento.setText("");
		valData.setText("");
		valVagas.setText("");
		
		
	}
	
	private void cadastrar() {
		try {
			if (valEvento.getText().equals("") || valData.getText().equals("")  || valVagas.getText().equals("")){
					 
				throw new IllegalArgumentException("Campos Vazios");
			}	
			
			
			
			
			
			String nome = valEvento.getText();
			String data = valData.getText();
			int vagas = Integer.parseInt(valVagas.getText());
			String permitirAcesso = (String)acesso.getSelectedItem();
			String estacionamento = (String)tipoVaga.getSelectedItem();
			
			
			boolean permitir;
			if(permitirAcesso.equals("Sim")) {
				permitir = true;
			}
			
			else {
				permitir = false;
			}
			
			
			this.principal.adicionarEvento(nome, data, permitir, vagas, estacionamento);
		
			this.limpar();
			JOptionPane.showMessageDialog(null, "Evento Cadastrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}

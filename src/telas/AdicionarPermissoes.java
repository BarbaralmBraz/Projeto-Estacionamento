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

public class AdicionarPermissoes extends JPanel {
	private JTextField valPlaca;
	private JTextField valCodigo;
	private Principal principal;

	/**
	 * Create the panel.
	 */
	public AdicionarPermissoes(Principal principal) {
		setBackground(new Color(255, 255, 255));
		this.principal = principal;
		
		
		setLayout(null);
		
		JLabel permissoes = new JLabel("Adicionar Permiss\u00F5es");
		permissoes.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		permissoes.setBounds(117, 32, 351, 38);
		add(permissoes);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel.setBounds(61, 153, 46, 14);
		add(lblNewLabel);
		
		valPlaca = new JTextField();
		valPlaca.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		valPlaca.setBounds(129, 150, 86, 20);
		add(valPlaca);
		valPlaca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo:\r\n");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(324, 153, 72, 14);
		add(lblNewLabel_1);
		
		valCodigo = new JTextField();
		valCodigo.setBounds(396, 150, 86, 20);
		add(valCodigo);
		valCodigo.setColumns(10);
		
		JButton adicionar = new JButton("Adicionar");
		adicionar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		adicionar.setBounds(397, 319, 118, 38);
		add(adicionar);
		
		JButton btnLimpar = new JButton("Limpar\r\n");
		btnLimpar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnLimpar.setBounds(86, 319, 89, 38);
		add(btnLimpar);

		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		
		adicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
			}
		});
	}
	
	
	private void limpar() {
		valPlaca.setText("");
		valCodigo.setText("");
				
	}
	
	
	private void adicionar() {
		try {
			if (valPlaca.getText().equals("") || valCodigo.getText().equals("")) {
				throw new IllegalArgumentException("Campos vazios!");
				
			}
			
			
			
			String codigo = valCodigo.getText();
			String placa = valPlaca.getText();
			
			
			this.principal.adicionarPermissao(placa, codigo);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Permissão Adicionada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	


}

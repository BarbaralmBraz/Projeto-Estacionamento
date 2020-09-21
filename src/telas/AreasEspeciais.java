package telas;

import javax.swing.JPanel;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class AreasEspeciais extends JPanel {
	private JTextField valVagas;
	private JTextField valNome;
	private JRadioButton carro; 
	private JRadioButton moto;
	private JRadioButton onibus;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Principal principal;

	/**
	 * Create the panel.
	 */
	public AreasEspeciais(Principal principal ) {
		setBackground(new Color(255, 255, 255));
		this.principal = principal;
		
		setLayout(null);
		
		JLabel areasEspeciais = new JLabel("\u00C1reas Especiais");
		areasEspeciais.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		areasEspeciais.setBounds(145, 28, 324, 49);
		add(areasEspeciais);
		
		carro = new JRadioButton("Carro\r\n");
		carro.setBackground(new Color(255, 255, 255));
		carro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(carro);
		carro.setBounds(82, 170, 109, 23);
		add(carro);
		
		moto = new JRadioButton("Moto");
		moto.setBackground(new Color(255, 255, 255));
		moto.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(moto);
		moto.setBounds(253, 170, 109, 23);
		add(moto);
		
		onibus = new JRadioButton("\u00D4nibus");
		onibus.setForeground(new Color(0, 0, 0));
		onibus.setBackground(new Color(255, 255, 255));
		onibus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(onibus);
		onibus.setBounds(406, 170, 109, 23);
		add(onibus);
		
		JLabel vagas = new JLabel("Vagas:");
		vagas.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		vagas.setBounds(82, 255, 51, 14);
		add(vagas);
		
		valVagas = new JTextField();
		valVagas.setBounds(145, 252, 86, 20);
		add(valVagas);
		valVagas.setColumns(10);
		
		JLabel nome = new JLabel("Nome:");
		nome.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		nome.setBounds(309, 255, 80, 14);
		add(nome);
		
		valNome = new JTextField();
		valNome.setBounds(376, 252, 86, 20);
		add(valNome);
		valNome.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnConfirmar.setBounds(395, 326, 120, 29);
		add(btnConfirmar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnLimpar.setBounds(97, 326, 89, 29);
		add(btnLimpar);
		
		JLabel lblNewLabel_2 = new JLabel("Selecione um estacionamento:\r\n");
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(60, 117, 278, 23);
		add(lblNewLabel_2);
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				confirmar();
			}
		});

	}
	
	
	private void limpar() {
		valNome.setText("");
		valVagas.setText("");
			
	}
	
	private void confirmar() {
		try {
			if (valNome.getText().equals("") || valVagas.getText().equals("")) {
				throw new IllegalArgumentException("Campos vazios!");
				
			}
			
			if (!carro.isSelected() && !moto.isSelected() && !onibus.isSelected()) {
				throw new IllegalArgumentException("Selecione um tipo de vaga.");
				
			}
			
			String nome = valNome.getText();
			int vagas = Integer.parseInt(valVagas.getText());
			
			String tipo;
			
			if(carro.isSelected()) {
				tipo = "Carro";
				
			}
			
			else if(moto.isSelected()) {
				tipo = "Moto";
			}
			
			else {
				tipo = "Onibus";
			}
			
			this.principal.reservarVagas(tipo, nome, vagas);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Área especial criada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}

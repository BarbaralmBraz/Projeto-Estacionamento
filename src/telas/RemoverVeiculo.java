package telas;

import javax.swing.JPanel;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class RemoverVeiculo extends JPanel {
	private JTextField valPlaca;
	private Principal principal; 

	/**
	 * Create the panel.
	 */
	public RemoverVeiculo(Principal principal) {
		setBackground(Color.WHITE);
		this.principal = principal;
		
		setLayout(null);
		
		JLabel removerVeiculo = new JLabel("Remover Ve\u00EDculos");
		removerVeiculo.setBounds(167, 11, 305, 38);
		removerVeiculo.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		add(removerVeiculo);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRemover.setBounds(375, 333, 97, 38);
		add(btnRemover);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpar.setBounds(122, 333, 108, 38);
		add(btnLimpar);
		
		JLabel lbl = new JLabel("Placa:");
		lbl.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lbl.setBounds(203, 134, 46, 14);
		add(lbl);
		
		valPlaca = new JTextField();
		valPlaca.setBounds(259, 131, 86, 20);
		add(valPlaca);
		valPlaca.setColumns(10);

		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});

		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remover();
			}
		});
	}
	
	private void limpar() {
		valPlaca.setText("");
		



	}
	
	
	private void remover() {
		try {
			if (valPlaca.getText().equals("")) {
				throw new IllegalArgumentException("Campo vazio!");
				
			}
			
			
			String placa = valPlaca.getText();
			
			
			
			this.principal.removerVeiculo(placa);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Veiculo Removido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}

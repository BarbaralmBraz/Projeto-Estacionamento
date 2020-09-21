package telas;

import javax.swing.JPanel;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

public class GerarRelatorios extends JPanel {
	private JTable table;
	private JTextField valData;
	private Principal principal;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public GerarRelatorios(Principal principal) {
		setBackground(Color.WHITE);
		this.principal = principal;
		
		
		setLayout(null);
		
		JLabel gerarRelatorio = new JLabel("Gerar Relat\u00F3rios\r\n");
		gerarRelatorio.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		gerarRelatorio.setBounds(169, 11, 263, 67);
		add(gerarRelatorio);
		
		JButton btnGerar = new JButton("Gerar\r\n");
		btnGerar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnGerar.setBounds(409, 345, 89, 23);
		add(btnGerar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 137, 500, 174);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Data:");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNewLabel.setBounds(94, 100, 46, 14);
		add(lblNewLabel);
		
		valData = new JTextField();
		valData.setBounds(150, 97, 86, 20);
		add(valData);
		valData.setColumns(10);
		
		
		btnGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gerar();
			}
		});

	}
	
	private void carregarTabela(String data) {

		try {
			String [] colunas = {"Relarotios"};
			String[][] dados = this.principal.retornaRelatorios(data);
			
			this.table = new JTable(dados, colunas);

			this.table.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Tamanho e tipo de letra.
			this.table.setEnabled(false); // Evitando edição não desejada.
			
			
			this.table.setBackground(SystemColor.info); // Cor da linha.
			this.table.setRowHeight(30); // Aumentando altura das linhas.

			this.scrollPane.setViewportView(this.table);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void gerar() {
		try {
			if (valData.getText().equals("")) {
				throw new IllegalArgumentException("Campo vazio!");
				
			}
			
			
			String data = valData.getText();
			
			
			
			this.carregarTabela(data);
		
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}

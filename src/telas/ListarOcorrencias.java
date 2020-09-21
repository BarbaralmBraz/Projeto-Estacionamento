package telas;

import javax.swing.JPanel;
import telas.JanelaPrincipal;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class ListarOcorrencias extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1237621656945471121L;
	private JTextField valData;
	private JScrollPane scrollPane_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton data;
	private JRadioButton tipoEstacionamento;
	private JComboBox valEstacionamento;
	private JTable table;
	private Principal principal;
	private JButton btnVoltar;
	private JanelaPrincipal janelaPrincipal;

	/**
	 * Create the panel.
	 */
	public ListarOcorrencias(Principal principal, JanelaPrincipal janelaPrincipal) {
		setBackground(Color.WHITE);
		this.principal = principal;
		this.janelaPrincipal = janelaPrincipal;
		
		setLayout(null);
		
		JLabel listarOcorrencia = new JLabel("Listar Ocorr\u00EAncias");
		listarOcorrencia.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		listarOcorrencia.setBounds(139, 23, 338, 51);
		add(listarOcorrencia);
		
		JLabel buscar = new JLabel("Buscar por:");
		buscar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buscar.setBounds(44, 96, 109, 25);
		add(buscar);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 178, 484, 168);
		add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		data = new JRadioButton("Data");
		data.setBackground(Color.WHITE);
		data.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(data);
		data.setBounds(193, 97, 109, 23);
		add(data);
		
		tipoEstacionamento = new JRadioButton("Estacionamento");
		tipoEstacionamento.setBackground(Color.WHITE);
		tipoEstacionamento.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(tipoEstacionamento);
		tipoEstacionamento.setBounds(315, 97, 162, 23);
		add(tipoEstacionamento);
		
		JLabel buscarData = new JLabel("Data:");
		buscarData.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buscarData.setBounds(139, 130, 46, 14);
		buscarData.setVisible(false);
		add(buscarData);
		
		valData = new JTextField();
		valData.setBounds(184, 127, 86, 20);
		valData.setVisible(false);
		add(valData);
		valData.setColumns(10);
		
		String[]opcoesEst = {"Carro", "Moto", "Ônibus"};
		valEstacionamento = new JComboBox(opcoesEst);
		valEstacionamento.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		valEstacionamento.setBounds(337, 127, 89, 20);
		valEstacionamento.setVisible(false);
		add(valEstacionamento);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnListar.setBounds(442, 357, 89, 23);
		add(btnListar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnVoltar.setBounds(66, 357, 89, 23);
		add(btnVoltar);
		
		data.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buscarData.setVisible(true);
				valData.setVisible(true);
				valEstacionamento.setVisible(false);
			}
		});
		
		tipoEstacionamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buscarData.setVisible(false);
				valData.setVisible(false);
				valEstacionamento.setVisible(true);
			}
		});
		
		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listar();
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});

	}
	
	private void listar() {
		try {
			if (!data.isSelected() && !tipoEstacionamento.isSelected()) {
				throw new IllegalArgumentException("Selecione um tipo de busca.");
				
			}
			
			if (data.isSelected() && valData.getText().equals("")) {
				throw new IllegalArgumentException("Informe uma data.");
				
			}
			
			
			String dataEntrada = valData.getText();
			String tipoVaga = (String)valEstacionamento.getSelectedItem();
			
			
			if(tipoEstacionamento.isSelected()) {
				String[][] dados = this.principal.retornaOcorrenciasTipoEstacionamento(tipoVaga);
				this.carregarTabela(dados);
				
			}
			
			else if (data.isSelected()) {
				String[][] dados = this.principal.retornaOcorrenciasData(dataEntrada);
				this.carregarTabela(dados);
				
			}
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void carregarTabela(String [][] dados) {

		try {
			String [] colunas = {"Categoria", "Estacionamento", "Data"};
			
			this.table = new JTable(dados, colunas);

			this.table.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Tamanho e tipo de letra.
			this.table.setEnabled(false); // Evitando edição não desejada.
			
			
			this.table.setBackground(SystemColor.info); // Cor da linha.
			this.table.setRowHeight(30); // Aumentando altura das linhas.

			this.scrollPane_1.setViewportView(this.table);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void voltar() {
		this.janelaPrincipal.voltarListarOcorrencias();
	}
}

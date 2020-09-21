package telas;

import javax.swing.JPanel;

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

public class ListarVeiculos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1237621656945471121L;
	private JScrollPane scrollPane_1;
	private JTable table;
	private Principal principal;
	private JButton btnVoltar;
	private JanelaPrincipal janelaPrincipal;
	private JTextField valPlaca;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton carro;
	private JRadioButton moto;
	private JRadioButton onibus;
	
	

	/**
	 * Create the panel.
	 */
	public ListarVeiculos(Principal principal, JanelaPrincipal janelaPrincipal) {
		setBackground(Color.WHITE);
		this.principal = principal;
		this.janelaPrincipal = janelaPrincipal;
		
		setLayout(null);
		
		JLabel listarOcorrencia = new JLabel("Listar Ve\u00EDculos Cadastrados");
		listarOcorrencia.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		listarOcorrencia.setBounds(67, 26, 464, 51);
		add(listarOcorrencia);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 178, 549, 168);
		add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		String[]opcoesEst = {"Carro", "Moto", "Ônibus"};
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnListar.setBounds(442, 357, 89, 23);
		add(btnListar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnVoltar.setBounds(66, 357, 89, 23);
		add(btnVoltar);
		
		JLabel placa = new JLabel("Placa:");
		placa.setBounds(56, 88, 46, 14);
		add(placa);
		
		valPlaca = new JTextField();
		valPlaca.setBounds(112, 85, 86, 20);
		add(valPlaca);
		valPlaca.setColumns(10);
		
		carro = new JRadioButton("Carro");
		carro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		carro.setBackground(Color.WHITE);
		buttonGroup.add(carro);
		carro.setBounds(89, 132, 109, 23);
		add(carro);
		
		moto = new JRadioButton("Moto");
		moto.setBackground(Color.WHITE);
		moto.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(moto);
		moto.setBounds(243, 132, 109, 23);
		add(moto);
		
		onibus = new JRadioButton("Ônibus");
		onibus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		onibus.setBackground(Color.WHITE);
		buttonGroup.add(onibus);
		onibus.setBounds(392, 132, 109, 23);
		add(onibus);
		
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
			String placa = valPlaca.getText();
			if (!carro.isSelected() && !moto.isSelected() && !onibus.isSelected() && placa.equals("")) {
				throw new IllegalArgumentException("Informe uma placa ou um tipo de veículo.");
				
			}
			
			if (!placa.equals("")) {
				String[][] dados = this.principal.retornaVeiculoPlaca(placa);
				this.carregarTabela(dados);
				
			}
			
			else {
				String tipoVaga;
				if(carro.isSelected()) {
					tipoVaga = "Carro";
				}
				else if (moto.isSelected()) {
					tipoVaga = "Moto";
				}
				
				else {
					tipoVaga = "Onibus";
				}
				
				String[][] dados = this.principal.retornaVeiculosTipo(tipoVaga);
				this.carregarTabela(dados);
				
			}
			
			
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void carregarTabela(String [][] dados) {

		try {
			String [] colunas = {"Proprietário", "Matricula", "Placa","Veiculo"};
			
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
		this.janelaPrincipal.voltarListarVeiculos();
	}
}

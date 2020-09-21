package telas;

import javax.swing.JPanel;
import telas.JanelaPrincipal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import visao.Principal;
import javax.swing.JButton;
import java.awt.Color;
public class ListarVagas extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private JRadioButton listaCarro;
	private JRadioButton listarMoto;
	private JRadioButton listarOnibus;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Principal principal;
	private JButton voltar;
	private JanelaPrincipal janelaPrincipal;
	private int idUsuario;
	

	
	public ListarVagas(Principal principal, JanelaPrincipal janelaPrincipal, int idUsuario) {
		setBackground(Color.WHITE);
		this.principal = principal;
		this.janelaPrincipal = janelaPrincipal;
		this.idUsuario = idUsuario;
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Vagas");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(179, 38, 237, 46);
		add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 155, 468, 184);
		add(scrollPane);
		
		
		
		listaCarro = new JRadioButton("Carro");
		listaCarro.setBackground(Color.WHITE);
		listaCarro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(listaCarro);
		listaCarro.setBounds(104, 113, 109, 23);
		add(listaCarro);
		
		listarMoto = new JRadioButton("Moto");
		listarMoto.setBackground(Color.WHITE);
		listarMoto.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(listarMoto);
		listarMoto.setBounds(239, 113, 109, 23);
		add(listarMoto);
		
		listarOnibus = new JRadioButton("\u00D4nibus");
		listarOnibus.setBackground(Color.WHITE);
		listarOnibus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		buttonGroup.add(listarOnibus);
		listarOnibus.setBounds(375, 113, 109, 23);
		add(listarOnibus);
		
		voltar = new JButton("Voltar");
		voltar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		voltar.setBounds(21, 350, 89, 39);
		add(voltar);
		
		
		listaCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarTabela("carro");
			}
		});
		
		listarMoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarTabela("moto");
			}
		});
		
		listarOnibus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarTabela("onibus");
			}
		});
		
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});


	}
	
	private void carregarTabela(String tipoVaga) {

		try {
			String [] colunas = {"Número", "Placa", "Disponibilidade"};
			String [][] dados = this.principal.listarVagas(tipoVaga);

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
	
	private void voltar() {
		this.janelaPrincipal.reload(this.idUsuario);
		
	}
}

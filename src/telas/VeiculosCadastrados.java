package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Color;

public class VeiculosCadastrados extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VeiculosCadastrados() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel veiculosCadastrados = new JLabel("Ve\u00EDculos Cadastrados");
		veiculosCadastrados.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		veiculosCadastrados.setBounds(116, 11, 360, 48);
		add(veiculosCadastrados);
		
		JLabel lblNome = new JLabel("Nome:\r\n");
		lblNome.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblNome.setBounds(37, 80, 102, 14);
		add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblMatricula.setBounds(37, 116, 80, 14);
		add(lblMatricula);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblPlaca.setBounds(37, 159, 102, 14);
		add(lblPlaca);
		
		textField = new JTextField();
		textField.setBounds(126, 77, 214, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 113, 135, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 156, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(53, 208, 459, 159);
		add(scrollPane);
		
		table = new JTable();
		table.setBounds(278, 321, 1, 1);
		add(table);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnListar.setBounds(370, 155, 89, 23);
		add(btnListar);

	}
}

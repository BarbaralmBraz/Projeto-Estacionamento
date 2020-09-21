package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import telas.JanelaPrincipal;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import visao.Principal;
import javax.swing.ButtonGroup;
import java.awt.Color;
public class LiberarVaga extends JPanel {
	private JTextField valVaga;
	private JRadioButton tipoOnibus;
	private JRadioButton tipoMoto;
	private JRadioButton tipoCarro;
	private Principal principal;
	private JanelaPrincipal janelaPrincipal;
	private JTextField valCodigo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton tipoReservada;
	private int idUsuario;

	/**
	 * Create the panel.
	 */
	public LiberarVaga(Principal principal, JanelaPrincipal janelaPrincipal, int idUsuario) {
		setBackground(Color.WHITE);
		this.principal = principal;
		this.janelaPrincipal = janelaPrincipal;
		this.idUsuario = idUsuario;


		setLayout(null);

		JLabel liberarVaga = new JLabel("Liberar Vagas");
		liberarVaga.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		liberarVaga.setBounds(167, 37, 318, 45);
		add(liberarVaga);

		JLabel tipoVaga = new JLabel("Vaga:");
		tipoVaga.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoVaga.setBounds(59, 127, 71, 25);
		add(tipoVaga);

		valVaga = new JTextField();
		valVaga.setBounds(120, 133, 86, 20);
		add(valVaga);
		valVaga.setColumns(10);

		JLabel tipoVeiculo = new JLabel("Estacionamento:");
		tipoVeiculo.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		tipoVeiculo.setBounds(37, 195, 181, 25);
		add(tipoVeiculo);

		tipoCarro = new JRadioButton("Carro");
		tipoCarro.setBackground(Color.WHITE);
		buttonGroup.add(tipoCarro);
		tipoCarro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoCarro.setBounds(37, 243, 109, 23);
		add(tipoCarro);

		tipoMoto = new JRadioButton("Moto");
		tipoMoto.setBackground(Color.WHITE);
		buttonGroup.add(tipoMoto);
		tipoMoto.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoMoto.setBounds(176, 243, 109, 23);
		add(tipoMoto);

		tipoOnibus = new JRadioButton("\u00D4nibus");
		tipoOnibus.setBackground(Color.WHITE);
		buttonGroup.add(tipoOnibus);
		tipoOnibus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoOnibus.setBounds(287, 243, 109, 23);
		add(tipoOnibus);

		tipoReservada = new JRadioButton("Vagas Especiais");
		tipoReservada.setBackground(Color.WHITE);
		buttonGroup.add(tipoReservada);
		tipoReservada.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoReservada.setBounds(408, 243, 154, 23);
		add(tipoReservada);

		JButton limpar = new JButton("LIMPAR");
		limpar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		limpar.setBounds(231, 328, 109, 23);
		add(limpar);

		JButton liberar = new JButton("LIBERAR");
		liberar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		liberar.setBounds(396, 328, 109, 23);
		add(liberar);

		JButton voltar = new JButton("VOLTAR");
		voltar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		voltar.setBounds(57, 328, 109, 23);
		add(voltar);

		JLabel codigo = new JLabel("C\u00F3digo:");
		codigo.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		codigo.setBounds(304, 132, 74, 14);
		codigo.setVisible(false);
		add(codigo);

		valCodigo = new JTextField();
		valCodigo.setBounds(371, 130, 86, 20);
		valCodigo.setVisible(false);
		add(valCodigo);
		valCodigo.setColumns(10);


		limpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});

		liberar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				liberar();
			}
		});

		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});

		tipoCarro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigo.setVisible(false);
				valCodigo.setVisible(false);
				tipoVaga.setVisible(true);
				valVaga.setVisible(true);
			}
		});


		tipoMoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigo.setVisible(false);
				valCodigo.setVisible(false);
				tipoVaga.setVisible(true);
				valVaga.setVisible(true);

			}
		});


		tipoOnibus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigo.setVisible(false);
				valCodigo.setVisible(false);
				tipoVaga.setVisible(true);
				valVaga.setVisible(true);
			}
		});


		tipoReservada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				codigo.setVisible(true);
				valCodigo.setVisible(true);
				tipoVaga.setVisible(false);
				valVaga.setVisible(false);
			}
		});


	}

	private void limpar() {
		valVaga.setText("");
		valCodigo.setText("");



	}

	private void liberar() {
		try {


			if (!tipoCarro.isSelected() && !tipoMoto.isSelected() && !tipoOnibus.isSelected() && !tipoReservada.isSelected()) {
				throw new IllegalArgumentException("Selecione um tipo de vaga");

			}
			if(tipoReservada.isSelected()) {

				String codigo = valCodigo.getText();
				if(codigo.equals("")) {
					throw new IllegalArgumentException("Informe um código de reserva");


				}

				this.principal.liberarAreasEspeciais(codigo);
				JOptionPane.showMessageDialog(null, "Reserva removida!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				this.limpar();
			}

			else {
				if (valVaga.getText().equals("")) {
					throw new IllegalArgumentException("Campos passados vazios");

				}

				int vaga = Integer.parseInt(valVaga.getText());
				String tipo;

				if(tipoCarro.isSelected()) {
					tipo = "Carro";

				}

				else if(tipoMoto.isSelected()) {
					tipo = "Moto";
				}

				else {
					tipo = "Onibus";
				}

				this.principal.liberarVaga(vaga, tipo);
				this.limpar();
				JOptionPane.showMessageDialog(null, "Vaga Liberada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void voltar() {
		this.janelaPrincipal.reload(this.idUsuario);

	}

}

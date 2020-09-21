package telas;

import javax.swing.JPanel;
import telas.JanelaPrincipal;
import visao.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class OcuparVaga extends JPanel {
	private JTextField valVaga;
	private JTextField valPlaca;
	private final ButtonGroup tipoGroup = new ButtonGroup();
	private JRadioButton tipoOnibus;
	private JRadioButton tipoMoto;
	private JRadioButton tipoCarro;
	private Principal principal;
	private JanelaPrincipal janelaPrincipal;
	private int idUsuario;

	/**
	 * Create the panel.
	 */
	public OcuparVaga(Principal principal, JanelaPrincipal janelaPrincipal, int idUsuario ) {
		setBackground(Color.WHITE);
		this.janelaPrincipal = janelaPrincipal;
		this.principal = principal;
		this.idUsuario = idUsuario;
		
		setLayout(null);
		
		JLabel ocupar = new JLabel("Ocupar Vaga");
		ocupar.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		ocupar.setBounds(181, 31, 229, 38);
		add(ocupar);
		
		JLabel tipoVeiculo = new JLabel("Tipo de Ve\u00EDculo:");
		tipoVeiculo.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoVeiculo.setBounds(46, 98, 123, 14);
		add(tipoVeiculo);
		
		JLabel vaga = new JLabel("Vaga:");
		vaga.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		vaga.setBounds(46, 162, 46, 14);
		add(vaga);
		
		valVaga = new JTextField();
		valVaga.setBounds(100, 159, 86, 20);
		add(valVaga);
		valVaga.setColumns(10);
		
		JLabel placa = new JLabel("Placa:");
		placa.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		placa.setBounds(46, 241, 46, 14);
		add(placa);
		
		valPlaca = new JTextField();
		valPlaca.setBounds(100, 238, 86, 20);
		add(valPlaca);
		valPlaca.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnLimpar.setBounds(232, 314, 89, 29);
		add(btnLimpar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnConfirmar.setBounds(405, 314, 123, 29);
		add(btnConfirmar);
		
		tipoCarro = new JRadioButton("Carro");
		tipoCarro.setBackground(Color.WHITE);
		tipoCarro.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoGroup.add(tipoCarro);
		tipoCarro.setBounds(195, 94, 109, 23);
		add(tipoCarro);
		
		tipoMoto = new JRadioButton("Moto");
		tipoMoto.setBackground(Color.WHITE);
		tipoMoto.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoGroup.add(tipoMoto);
		tipoMoto.setBounds(330, 94, 109, 23);
		add(tipoMoto);
		
		tipoOnibus = new JRadioButton("Onibus");
		tipoOnibus.setBackground(Color.WHITE);
		tipoOnibus.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		tipoGroup.add(tipoOnibus);
		tipoOnibus.setBounds(464, 94, 109, 23);
		add(tipoOnibus);
		
		JButton voltar = new JButton("Voltar");
		voltar.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		voltar.setBounds(58, 314, 89, 30);
		add(voltar);
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ocupar();
			}
		});
		
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});

	}
	
	private void limpar() {
		valVaga.setText("");
		valPlaca.setText("");
		
		
	}
	
	private void ocupar() {
		try {
			if (valVaga.getText().equals("") || valPlaca.getText().equals("")) {
				throw new IllegalArgumentException("Campos passados vazios");
				
			}
			
			if (!tipoCarro.isSelected() && !tipoMoto.isSelected() && !tipoOnibus.isSelected()) {
				throw new IllegalArgumentException("Selecione um tipo de veiculo");
				
			}
			
			int vaga = Integer.parseInt(valVaga.getText());
			String placa = valPlaca.getText();
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
			
			this.principal.ocuparVaga(placa, vaga, tipo);
			this.limpar();
			JOptionPane.showMessageDialog(null, "Vaga Ocupada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void voltar() {
		this.janelaPrincipal.reload(this.idUsuario);
		
	}

}

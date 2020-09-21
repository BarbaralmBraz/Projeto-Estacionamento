package telas;

import javax.swing.JPanel;
import telas.JanelaPrincipal;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class MonitorarEstacionamento extends JPanel {

	private JanelaPrincipal janelaPrincipal;
	
	
	public MonitorarEstacionamento(JanelaPrincipal janelaPrincipal) {
		setBackground(new Color(255, 255, 255));
		this.janelaPrincipal = janelaPrincipal;
		
		setLayout(null);
		
		JLabel lblMonitorar = new JLabel("Monitorar Estacionamento");
		lblMonitorar.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblMonitorar.setBounds(60, 33, 513, 59);
		add(lblMonitorar);
		
		JLabel Opcao = new JLabel("Selecione uma op\u00E7\u00E3o:");
		Opcao.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 18));
		Opcao.setBounds(53, 119, 217, 26);
		add(Opcao);
		
		JButton btnOcuparVaga = new JButton("OCUPAR VAGA");
		btnOcuparVaga.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnOcuparVaga.setBounds(286, 122, 173, 34);
		add(btnOcuparVaga);
		
		JButton btnDesocuparVaga = new JButton("LIBERAR VAGA");
		btnDesocuparVaga.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnDesocuparVaga.setBounds(286, 188, 173, 34);
		add(btnDesocuparVaga);
		
		JButton btnListarVagas = new JButton("LISTAR VAGAS");
		btnListarVagas.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnListarVagas.setBounds(286, 257, 173, 34);
		add(btnListarVagas);
		
		
		btnOcuparVaga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarOcuparVaga();
			}
		});
		
		btnDesocuparVaga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarLiberarVaga();
			}
		});
		
		btnListarVagas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				carregarListarVaga();
			}
		});

	}
	
	private void carregarOcuparVaga() {
		this.janelaPrincipal.reload(1);
	}
	
	private void carregarLiberarVaga() {
		this.janelaPrincipal.reload(2);
	}
	
	private void carregarListarVaga() {
		this.janelaPrincipal.reload(3);
	}
}

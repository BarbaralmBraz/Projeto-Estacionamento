package telas;
import visao.Principal;
import java.awt.Color;
import telas.JanelaPrincipal;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class TelaLogin extends JPanel {
	
	private JTextField valLogin;
	private JTextField valSenha;
	private JanelaPrincipal janela;
	private Principal principal;

	/**
	 * Create the panel.
	 */
	public TelaLogin(Principal principal, JanelaPrincipal janela) {
		setBackground(Color.WHITE);
		this.principal = principal;
		this.janela = janela;

		setLayout(null);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(UIManager.getColor("Button.light"));
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEntrar.setBounds(263, 338, 89, 23);
		add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(60, 35, 482, 120);
		lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/morais.png"))); // NOI18N
		add(lblNewLabel);
		
				valLogin = new JTextField();
				valLogin.setForeground(Color.BLACK);
				valLogin.setBackground(Color.WHITE);
				valLogin.setBounds(222, 176, 172, 20);
				add(valLogin);
				valLogin.setColumns(10);
				
						JLabel login = new JLabel("Login:");
						login.setBounds(183, 150, 73, 20);
						add(login);
						login.setForeground(Color.BLACK);
						login.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
						
								JLabel senha = new JLabel("Senha:");
								senha.setBounds(183, 231, 73, 14);
								add(senha);
								senha.setForeground(Color.BLACK);
								senha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
								
										valSenha = new JPasswordField();
										valSenha.setForeground(new Color(0, 0, 0));
										valSenha.setBounds(222, 256, 172, 20);
										add(valSenha);
										valSenha.setColumns(10);
		
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});


	}


	private void login() {
		try {
			if (valLogin.getText().equals("") || valSenha.getText().equals("")) {
				throw new IllegalArgumentException("Campos vazios!");
			}
			
			String login = valLogin.getText();
			String senha = valSenha.getText();
			
			String tipoUsuario = this.principal.retornaTipoUsuario(login, senha);
			
			if(tipoUsuario.equals("funcionario")) {
				janela.reload(4);
			}
			
			else if(tipoUsuario.equals("rh")) {
				janela.reload(6);
				
			}
			
			else {
				janela.reload(5);
				
			}
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}

package main;

import telas.JanelaPrincipal;


public class Main {
	
	private JanelaPrincipal tela;

	public static void main(String[] args) {
		
		new Main().iniciaTela(0);
		

	}
	
	public void reload(int opcao, int idAtual) {
		this.tela.setVisible(false);
		this.tela = new JanelaPrincipal(this);
		this.tela.setIdAtual(idAtual);
		this.tela.iniciarTela(opcao);
		this.tela.setVisible(true);
	}
	
	public void iniciaTela(int opcao) {
		this.tela = new JanelaPrincipal(this);
		this.tela.iniciarTela(opcao);
		this.tela.setVisible(true);
	}

}

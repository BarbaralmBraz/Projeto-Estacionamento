package modelo;

public class Login {

	private String usuario;
	private int senha;


	public Login() {

	}

	public Login(String usuario, int senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}



	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public int getSenha() {
		return senha;
	}


	public void setSenha(int senha) {
		this.senha = senha;
	}


	public String toString() {
		return "Usuário = " + usuario + ", Senha = " + senha;
	}




}

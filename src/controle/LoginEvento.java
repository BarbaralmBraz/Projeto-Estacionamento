package controle;

import java.util.List;
import modelo.Login;

public class LoginEvento {
	
	
	
	public void cadastrarLogin(Login login) {
		if (login != null);
			login.setUsuario(BaseDados.proximoLogin());
			BaseDados.listaLogin.add(login);
	}
	
}




package controle;
import controle.BaseDados;
import modelo.Usuario;


public class UsuarioEventos {
	
	private BaseDados base;
	
	
	public UsuarioEventos(BaseDados base) {
		this.base = base;
		this.adicionarUsuario("estacionamento","123" ,"funcionario" );
		this.adicionarUsuario("rh","456" ,"rh" );
		this.adicionarUsuario("gestor","789" ,"gestor" );
		
	}
	
	public void adicionarUsuario(String login, String senha, String tipoUsuario) {
		Usuario usuario = new Usuario(login, senha, tipoUsuario);
		base.adicionaUsuario(usuario);
	}
	
	public String retornaTipoUsuario(String login, String senha) {
		try {
			if(!base.usuarioExiste(login)) {
				throw new IllegalArgumentException("Usuario inexistente!");
			}
			
			Usuario usuario = base.retornaUsuario(login);
			
			if(!usuario.getSenha().equals(senha)) {
				throw new IllegalArgumentException("Senha incorreta!");
				
			}
			
			return usuario.getTipoUsuario();
						
		}
		
		catch (Exception e) {
			throw e;
		}
	}

}

package controle;

import java.util.List;
import modelo.Funcionario;
import modelo.Veiculo;


public class EventoFuncionario{
	
	private BaseDados base;

	public EventoFuncionario(BaseDados base) {
		this.base = base;
	
	}
	
	public void cadastrarFuncionario(String nome, String matricula, String placa){
		Funcionario funcionario = new Funcionario(nome,matricula,placa);
		if(funcionario!= null) {
			
			base.adicionarFuncionario(funcionario);
		}
	}
	
	public List<Funcionario> listarFuncionario(){
		return base.getFuncionarios();

	}
	
public String [][] retornaFuncionarios(){
		
		try {
			
			List<Funcionario> funcionarios = this.listarFuncionario();
			int numFuncionarios = funcionarios.size();
			if(numFuncionarios == 0) {
				throw new IllegalArgumentException("Não existem funcionarios cadastrados.");
				
			}
			String [][] retorno = new String[numFuncionarios][3];
			int indice = 0;
			for(Funcionario funcionario : funcionarios) {
				
					String[]lista = new String[3];
					
					lista[0] = funcionario.getNome();
					lista[1] = funcionario.getMatricula();
					lista[2] = funcionario.getPlaca();
					
					retorno[indice++] = lista;
				
				}		
			
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
}

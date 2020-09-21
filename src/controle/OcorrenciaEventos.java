package controle;

import java.util.List;

import modelo.Ocorrencia;
import modelo.Vaga;

public class OcorrenciaEventos {

	private BaseDados base;
	
	
	public OcorrenciaEventos(BaseDados base) {
		this.base = base;
		
	}

	public void criarOcorrencia(String categoria, String titulo, String ocorrencia, String funcionario, String tipoEstacionamento) {
		Ocorrencia novaOcorrencia = new Ocorrencia(categoria, titulo, ocorrencia, funcionario, tipoEstacionamento);
		base.adicionarOcorrencia(novaOcorrencia);
	}

	public String listarOcorrencias() {
		List<Ocorrencia> ocorrencias = base.retornaOcorrencias();
		String saida;
		saida = "";

		if (ocorrencias != null) {
			for (Ocorrencia ocorrencia : ocorrencias) {
				saida += ocorrencia.toString();

			}

		} else {
			throw new IllegalArgumentException("Ocorrencias inexistentes");
		}

		return saida;
	}
	
	/*
	 * Essa função gera linhas para uma tabela que vai conter os campos, tipo ocorrencia, tipo estacionamento e data.
	 * O retorno é uma matriz onde cada lista contem esses dados de uma ocorrencia.
	 */
	public String [][] retornaOcorrenciasData(String data){
		
		try {
			if (data == null || data.equals("")) {
				throw new IllegalArgumentException("Informe uma data");
			}
			List<Ocorrencia> ocorrencias = base.retornaOcorrencias();
			
			String [][] retorno = new String[ocorrencias.size()][3];
			int indice = 0;
			for(Ocorrencia ocorrencia : ocorrencias) {
				if(ocorrencia.getData().equals(data)) {
					String[]lista = new String[3];
					
					lista[0] = ocorrencia.getCategoria();
					lista[1] = ocorrencia.getTipoEstacionamento();
					lista[2] = ocorrencia.getData();
					retorno[indice++] = lista;
				
				}		
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
		public String [][] retornaOcorrenciasTipoEstacionamento(String tipoEstacionamento){
		
		try {
			if (tipoEstacionamento == null || tipoEstacionamento.equals("")) {
				throw new IllegalArgumentException("Informe o estacionamento.");
			}
			List<Ocorrencia> ocorrencias = base.retornaOcorrencias();
			
			String [][] retorno = new String[ocorrencias.size()][3];
			int indice = 0;
			for(Ocorrencia ocorrencia : ocorrencias) {
				if(ocorrencia.getTipoEstacionamento().equals(tipoEstacionamento)) {
					String[]lista = new String[3];
					
					lista[0] = ocorrencia.getCategoria();
					lista[1] = ocorrencia.getTipoEstacionamento();
					lista[2] = ocorrencia.getData();
					retorno[indice++] = lista;
				
				}		
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
}

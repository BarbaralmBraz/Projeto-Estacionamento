package controle;

import java.util.List;

import controle.BaseDados;
import modelo.Ocorrencia;
import modelo.TipoVeiculo;
import modelo.Veiculo;


public class VeiculoEventos {

	//Esta classe contempla todos os métodos que envolverão a classe Veiculo.

	private BaseDados base;

	public VeiculoEventos (BaseDados base) {
		this.base = base;

	}

	public void cadastrarVeiculo(String placa, String tipoVeiculo, String proprietario, String matriculaProprietario) {
		try {
			int id = (base.proximoIdVeiculo());
			Veiculo veiculo = new Veiculo(placa, id, tipoVeiculo, proprietario, matriculaProprietario);
			if(veiculo!= null) {

				base.adicionarVeiculo(veiculo);
			}

		}
		catch(Exception e) {
			throw e;
		}

	}

	public List<Veiculo> listarVeiculo(){
		return base.getVeiculos();
	}

	public String [][] retornaVeiculos(String tipoVeiculo){

		try {

			List<Veiculo> veiculos = this.listarVeiculo();
			int numVeiculos = this.retornaNumVeiculos(tipoVeiculo);
			if(numVeiculos == 0) {
				throw new IllegalArgumentException("Não existem veículos desse tipo cadastrados.");

			}
			String [][] retorno = new String[numVeiculos][4];
			int indice = 0;

			for(Veiculo veiculo : veiculos) {
				if(veiculo.getTipoVeiculo().equals(tipoVeiculo)) {	
					String[]lista = new String[4];

					lista[0] = veiculo.getProprietario();
					lista[1] = veiculo.getMatriculaProprietario();
					lista[2] = veiculo.getPlaca();
					lista[3] = veiculo.getTipoVeiculo();
					retorno[indice++] = lista;

				}		

			}
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}



	public int retornaNumVeiculos(String tipoVeiculo) {
		try {
			List<Veiculo> veiculos = this.listarVeiculo();
			int retorno = 0;
			for(Veiculo veiculo : veiculos) {

				if(veiculo.getTipoVeiculo().equals(tipoVeiculo)) {
					retorno += 1;
				}
			}

			return retorno;

		}

		catch (Exception e) {
			throw e;
		}
	}


	public String [][] retornaVeiculoPlaca(String placa){

		try {

			List<Veiculo> veiculos = this.listarVeiculo();

			String [][] retorno = new String[1][4];
			int indice = 0;
			for(Veiculo veiculo : veiculos) {

				if(veiculo.getPlaca().equals(placa)) {
					String[]lista = new String[4];
					lista[0] = veiculo.getProprietario();
					lista[1] = veiculo.getMatriculaProprietario();
					lista[2] = veiculo.getPlaca();
					lista[3] = veiculo.getTipoVeiculo();
					retorno[indice++] = lista;
					return retorno;
				}
			}		

			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}

	public boolean contemVeiculos(String placa) {
		List<Veiculo> veiculos = this.listarVeiculo();
		boolean retorno = false;
		int indice = 0;
		while (!retorno && indice < veiculos.size()) {
			if(veiculos.get(indice++).getPlaca().equals(placa)) {
				retorno = true;
			}


		}

		return retorno;
	}
	
	public void removerVeiculo(String placa) {
		try {
			
			this.base.removerVeiculo(placa);
			
		}
		
		catch (Exception e) {
			throw e;
		}
	}



}














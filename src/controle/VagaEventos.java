package controle;

import controle.BaseDados;
import controle.EventoEvento;
import controle.VeiculoEventos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import modelo.Vaga;


public class VagaEventos {

	private BaseDados base;
	private VeiculoEventos controleVeiculos;
	private EventoEvento eventoEvento;


	public VagaEventos(BaseDados base, EventoEvento eventoEvento){
		this.base = base;
		this.eventoEvento = eventoEvento;
		this.controleVeiculos = new VeiculoEventos(this.base);


	}


	public void criarVagas(String tipoVaga, int numeroVagas) {
		base.adicionarVagas(tipoVaga, numeroVagas);
	}

	private boolean vagaDisponivel(Vaga vaga) {
		return vaga.isDisponivel();
	}

	public void ocupaVaga (String placa, int numeroVaga, String tipoVeiculo) {
		try {
			if (base.retornaNumVagas(tipoVeiculo) == 0) {
				throw	new IllegalArgumentException("Não existem vagas cadastradas!");

			}


			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String data = formato.format(new Date());
			formato = new SimpleDateFormat("HH:mm:ss");
			String hora = formato.format(new Date());
			if(!this.eventoEvento.liberarAcesso(data)) {


				if(!this.controleVeiculos.contemVeiculos(placa)) {
					throw	new IllegalArgumentException("Veículo não cadastrado!");

				}

			}

			Vaga vaga = base.retornaVaga(numeroVaga, tipoVeiculo);

			if (vaga != null) {
				if (vagaDisponivel(vaga)) {
					vaga.setDisponivel(false);
					vaga.setPlacaVeiculo(placa);

					base.alteraVaga(numeroVaga, vaga, tipoVeiculo);
					String relatorio = "Vaga: " + vaga.getNumeroVaga() + " | Tipo: " + tipoVeiculo + " | Ocupada por: " + placa + " | " + hora;
					this.base.addLinhaRelatorio(relatorio, data);
					
				}

				else if (vaga.isVagaEspecial()) {
					String codigo = vaga.getCodigoReserva();
					List<String> permissoes = this.base.retornaPermissoes(codigo);
					if(permissoes.contains(placa)) {
						vaga.setPlacaVeiculo(placa);
						base.alteraVaga(numeroVaga, vaga, tipoVeiculo);
						String relatorio = "Vaga: " + vaga.getNumeroVaga() + " | Tipo: " + tipoVeiculo + " | Ocupada por: " + placa + " | " + hora;
						this.base.addLinhaRelatorio(relatorio, data);
					}

					else {
						throw	new IllegalArgumentException("Veículo não permitido.");
					}
				}

				else {
					throw	new IllegalArgumentException("Vaga está ocupada.");
				}

			}

			else {
				throw	new IllegalArgumentException("Vaga não existe.");

			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	
	


	public void liberarVaga (int numeroVaga, String tipoVeiculo) {
		try {

			Vaga vaga = base.retornaVaga(numeroVaga, tipoVeiculo);

			if (vaga != null) {
				if (!vagaDisponivel(vaga)) {
					if(!vaga.isVagaEspecial()) {
						vaga.setDisponivel(true);
						vaga.setPlacaVeiculo("");
					}

					else {
						vaga.setPlacaVeiculo(vaga.getCodigoReserva());

					}
					base.alteraVaga(numeroVaga, vaga, tipoVeiculo);
				}
				else {
					throw	new IllegalArgumentException("Vaga está livre");
				}

			}

			else {
				throw	new IllegalArgumentException("Vaga não existe");

			}
		}
		catch(Exception e) {
			throw e;
		}

	}

	public String [][] listarVagas(String tipoVaga) {
		List<Vaga> vagas;
		String [][] saida = new String [base.retornaNumVagas(tipoVaga)][3];



		vagas = base.retornaLista(tipoVaga);


		if(vagas != null) {
			int indice = 0;
			for(Vaga vaga : vagas) {
				String [] linha = new String [3];
				linha [0] = Integer.toString(vaga.getNumeroVaga());
				linha [1] = vaga.getPlacaVeiculo();
				linha [2] = vaga.retornaDisponibilidade();

				saida [indice++] = linha;


			}

			return saida;

		}
		else {
			throw	new IllegalArgumentException("Vagas inexistentes");
		}


	}

	private void addAreaEspecial(String codigo) {
		try {
			this.base.addAreaEspecial(codigo);
		}
		catch(Exception e) {
			throw e;
		}
	}

	public void reservarVagas(String tipoVaga, String codigo, int numVagas) {
		try {

			if(base.retornaVagasDisponiveis(tipoVaga) < numVagas) {
				throw new IllegalArgumentException("Não exsite o número de vagas disponiveis");

			}

			List<Vaga> vagas;
			vagas = base.retornaLista(tipoVaga);

			for(Vaga vaga : vagas) {
				if(vaga.isDisponivel() && numVagas-- > 0) {
					vaga.setDisponivel(false);
					vaga.setPlacaVeiculo(codigo);
					vaga.setCodigoReserva(codigo);
					vaga.setVagaEspecial(true);
					int numeroVaga = vaga.getNumeroVaga();
					base.alteraVaga(numeroVaga, vaga, tipoVaga);

				}

			}

			this.base.addAreaEspecial(codigo);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Erro ao criar área especial");
		}

	}

	public void adicionarPermissao(String placa, String codigo) {
		try {
			if(!this.base.retornaExisteRerserva(codigo)) {
				throw new IllegalArgumentException("Não existe esse codigo de reserva");
			}

			if(!this.controleVeiculos.contemVeiculos(placa)) {
				throw	new IllegalArgumentException("Veículo não cadastrado!");

			}


			this.base.adicionarPermissao(codigo, placa);
		}

		catch(Exception e) {
			throw e;
		}
	}


	public void removerReserva(String codigo) {
		try {
			if(!this.base.retornaExisteRerserva(codigo)) {
				throw new IllegalArgumentException("Não existe esse codigo de reserva");
			}
			List<Vaga> vagas;
			vagas = base.retornaLista("Carro");

			for(Vaga vaga : vagas) {
				if(vaga.isVagaEspecial() && vaga.getCodigoReserva().equals(codigo)) {
					vaga.setCodigoReserva("");
					vaga.setDisponivel(true);
					vaga.setPlacaVeiculo("");
					vaga.setVagaEspecial(false);

					this.base.alteraVaga(vaga.getNumeroVaga(), vaga, "Carro" );
				}
			}

			vagas = base.retornaLista("Moto");

			for(Vaga vaga : vagas) {
				if(vaga.isVagaEspecial() && vaga.getCodigoReserva().equals(codigo)) {
					vaga.setCodigoReserva("");
					vaga.setDisponivel(true);
					vaga.setPlacaVeiculo("");
					vaga.setVagaEspecial(false);

					this.base.alteraVaga(vaga.getNumeroVaga(), vaga, "Moto" );
				}
			}

			vagas = base.retornaLista("Onibus");

			for(Vaga vaga : vagas) {
				if(vaga.isVagaEspecial() && vaga.getCodigoReserva().equals(codigo)) {
					vaga.setCodigoReserva("");
					vaga.setDisponivel(true);
					vaga.setPlacaVeiculo("");
					vaga.setVagaEspecial(false);

					this.base.alteraVaga(vaga.getNumeroVaga(), vaga, "Onibus" );
				}
			}
		}

		catch(Exception e) {
			throw e;

		}

	}
	
	public String [][] retornaRelatorios(String data) {
		
		try {
			List<String> lista = this.base.retornaRelatorio(data);
			String [][] retorno = new String [lista.size()][];
			int indice = 0;
			
			for (String dado : lista) {
				String [] linha = {dado}; 
				retorno[indice++] = linha;
			}
			
			return retorno;
		}
		catch (Exception e) {
			throw e;
		}
	}
}

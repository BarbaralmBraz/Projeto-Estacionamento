package controle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Evento;
import controle.BaseDados;
import controle.VagaEventos;

public class EventoEvento {

	private BaseDados base;
	private VagaEventos vagaEventos;

	public EventoEvento(BaseDados base) {
		this.base = base;
		
		this.vagaEventos = new VagaEventos(this.base, this);

	}

	public void adicionarEvento(String nome, String data, boolean liberarAcesso, int numVaga, String tipoVagas) {
		try {
			
			Evento evento = new Evento(nome, data, liberarAcesso, numVaga, tipoVagas);
			this.base.adicionarEvento(evento);
		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro ao adicionar evento!");
			
		}
	}
	
	
	public void ocupaVagaEvento() {
		try {
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String data = formato.format(new Date());
			List<Evento> lista = this.base.getEventos();
			int indice = 0;
			boolean encontrou = false;
			
			while (! encontrou && indice < lista.size()) {
				Evento evento = lista.get(indice);
				if(evento.getData().equals(data) && !evento.isVagasReservada()) {
					int vagas = evento.getNumVagas();
					String codigo = evento.getNome();
					String tipoVaga = evento.getTipoVaga();
					
					this.vagaEventos.reservarVagas(tipoVaga, codigo, vagas);
					encontrou = true;
					evento.setVagasReservada(true);
					this.base.alteraEvento(indice, evento);
				}
				else {
					Date dataAtual = new Date();
					Date dataEvento = this.converteData(evento.getData());
					if(dataAtual.getTime() > dataEvento.getTime()) {
						this.base.removerEvento(indice);
					}
				}

				indice += 1;

			}

			
		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro na contagem de eventos!");
		}
	}
			
		
		
	

	public void removerEvento(int indice) {
		try {

			this.base.removerEvento(indice);
		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro ao remover evento!");
		}
	}


	public int retornaNumEventos() {
		try {

			return this.base.retornaNumEventos();
		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro na contagem de eventos!");
		}
	}

	public List<Evento>getEventos(){
		try {

			return this.base.getEventos();
		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro ao retornar eventos!");
		}
	}


	private Date converteData(String data1) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			Date data = null;
			data = formato.parse(data1);
			return data;


		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro ao converter data!");
		}
	}


	public boolean liberarAcesso(String data) {
		try {
			List<Evento> lista = this.base.getEventos();
			int indice = 0;
			boolean encontrou = false;
			boolean retorno = false;
			
			while (! encontrou && indice < lista.size()) {
				Evento evento = lista.get(indice);
			
				if(evento.getData().equals(data)) {
					retorno = evento.isLiberarAcesso();
					encontrou = true;
				
				}
				else {
					Date dataAtual = new Date();
					Date dataEvento = this.converteData(evento.getData());
					if(dataAtual.getTime() > dataEvento.getTime()) {
						this.base.removerEvento(indice);
					}
				}

				indice += 1;

			}

			return retorno;
		}

		catch(Exception e) {
			throw new IllegalArgumentException("Erro na contagem de eventos!");
		}
	}
}




package modelo;

public enum TipoVeiculo {
	
	//Lista com quantidade fechada (5) de tipos de veículos, serve para determinar qual o tipo de veículos que irei cadastrar.
	CONVENCIONAL(1,"Convencional"), 
	MOTO(2, "Moto"), 
	PICKUP(3,"PickUp"),
	VAN(4, "Van"), 
	ONIBUS(5, "Ônibus");
	
	private int codigo; //Números que representam cada tipo de veículo
	private String descricao; //Mostrará ao usuário o tipo de veículo de forma mais apresentável. 
	
	private TipoVeiculo (int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao= descricao;
	}

	// Neste caso não precisarei setar(apontar nenhum valor, pois eles já tem seu próprio valor, quero apenas pegar(get) os valores de cada um.
	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString () {
		return "\n Codigo do tipo do veículo:" + this.codigo +  ",\n Tipo do veículo:" + this.descricao;
		
	}
	
}

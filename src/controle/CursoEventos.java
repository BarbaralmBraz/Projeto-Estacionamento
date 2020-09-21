package controle;

import java.util.List;

import modelo.Curso;

public class CursoEventos {
	
	//Esta classe contempla todos os métodos que envolverão a classe Curso.
	
	public CursoEventos () {
		
	}
	
	public void cadastrarCurso(Curso curso) {
		if(curso!= null) {
			curso.setId(BaseDados.proximoIdCurso());
			BaseDados.listaCurso.add(curso);
		}
	}
	
	public List<Curso> listarCurso(){
		return BaseDados.listaCurso;
	}
	
	
	

}

package controle;

import java.util.List;

import modelo.Aluno;
import modelo.Curso;

public class AlunoEventos {
	
	//Esta classe contempla todos os métodos que envolverão a classe Aluno.
	
	public AlunoEventos () {
		
	}
	
	public void cadastrarAluno(Aluno aluno) {
		if(aluno!= null) {
			aluno.setAlunoMatricula(BaseDados.proximaMatriculaAluno());
			BaseDados.listaAluno.add(aluno);
		}
	}
	
	public List<Aluno> listarAluno(){
		return BaseDados.listaAluno;
	}
	

}

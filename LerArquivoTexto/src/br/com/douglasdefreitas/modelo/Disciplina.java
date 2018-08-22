package br.com.douglasdefreitas.modelo;

public class Disciplina {
	
	private String nomeDisciplina;
	private static int quantidadeDeDisciplinas = 0;
	
	public Disciplina() {
		quantidadeDeDisciplinas += 1;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public static int getQuantidadeDeDisciplinas() {
		return quantidadeDeDisciplinas;
	}

}

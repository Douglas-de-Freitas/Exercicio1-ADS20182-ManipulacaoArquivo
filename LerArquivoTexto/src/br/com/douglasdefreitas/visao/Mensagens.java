package br.com.douglasdefreitas.visao;

import java.util.List;

import br.com.douglasdefreitas.modelo.Aluno;
import br.com.douglasdefreitas.util.Utilidades;

public class Mensagens {
/*
	public static void imprimeLinhaRelatorio(int sequencia, int nDigitos, Aluno aluno) {
	
		String linha = "";
		
		linha += Utilidades.configuraImpressaoDosDigitos(nDigitos, sequencia); // add sequencia
		linha += Utilidades.configuraImpressaoDaMatricula(aluno.getMatricula()); // add matricula
		linha += Utilidades.configuraImpressaoDoNome(aluno.getNome()); // add nome
		linha += Utilidades.configuraImpressaoDoCpf(aluno.getCpf()); // add cpf
		linha += Utilidades.configuraImpressaoDoSexo(aluno.getSexo()); // add sexo
		linha += Utilidades.configuraImpressaoDaData(aluno.getDataNascimento()); //data
		linha += Utilidades.configuraImpressaoDasDisciplinas(aluno.getDisciplinas()); // add disciplinas

		imprimeMensagem("\n" + linha);

	}*/
	
	/*
	public static void imprimeRelatorio(int sequencia, int digitos, List<Aluno> alunos) {
		
		for (Aluno aluno : alunos) {
			Mensagens.imprimeLinhaRelatorio(sequencia, digitos, aluno);
			sequencia += 1;
		}
		
	}	*/

	public static void imprimeRelatorio(int sequencia, int nDigitos, List<Aluno> alunos) {
		
		for (Aluno aluno : alunos) {
			
			String linha = "";
			
			linha += Utilidades.configuraImpressaoDosDigitos(nDigitos, sequencia); // add sequencia
			linha += Utilidades.configuraImpressaoDaMatricula(aluno.getMatricula()); // add matricula
			linha += Utilidades.configuraImpressaoDoNome(aluno.getNome()); // add nome
			linha += Utilidades.configuraImpressaoDoCpf(aluno.getCpf()); // add cpf
			linha += Utilidades.configuraImpressaoDoSexo(aluno.getSexo()); // add sexo
			linha += Utilidades.configuraImpressaoDaData(aluno.getDataNascimento()) + "\n\n"; //data
			linha += Utilidades.configuraImpressaoDasDisciplinas(aluno.getDisciplinas()); // add disciplinas
			
			sequencia += 1;
			
			imprimeMensagem(linha + "\n");
			
		}
		
	}
	
	public static void imprimeMensagemErro(String msg) {
		System.err.println(msg);
	}
	
	public static void imprimeMensagem(String msg) {
		System.out.println(msg);
	}

}

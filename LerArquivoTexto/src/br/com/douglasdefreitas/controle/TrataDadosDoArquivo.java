package br.com.douglasdefreitas.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasdefreitas.modelo.Aluno;
import br.com.douglasdefreitas.modelo.Disciplina;
import br.com.douglasdefreitas.util.LerEscreveArquivo;
import br.com.douglasdefreitas.visao.Mensagens;

public class TrataDadosDoArquivo {

	private static List<String> linhasDoArquivo = LerEscreveArquivo.ler();

	private static List<Aluno> criaListaDeAlunos() {

		if (linhasDoArquivo != null && !linhasDoArquivo.isEmpty()) {

			try {

				List<Aluno> alunos = new ArrayList<>();

				for (String linha : linhasDoArquivo) {

					linha = linha.trim();

					int qtdMaterias = linha.substring(49).length() / 7; // verifica a quantidade de matérias

					//List<String> disciplinas = new ArrayList<>(); // cria uma lista de disciplinas

					int indiceMateria = 49; // pega o indice onde inicia a primeira matéria

					// Cada objeto aluno deve ser armazenado em uma collection (Arraylist)
					// denominada de alunos.
					
					// criando novo objeto e colocando nele os atributos retirado da linha x do txt
					Aluno aluno = new Aluno();
					aluno.setMatricula(linha.substring(0, 4));
					aluno.setNome(linha.substring(4, 29));
					aluno.setCpf(linha.substring(29, 40));
					aluno.setSexo(linha.substring(40, 41).charAt(0));
					aluno.setDataNascimento(linha.substring(41, 49));
					//aluno.setDisciplinas(disciplinas);
					
					List<Disciplina> disciplinasDoTxt = new ArrayList<>();
					
					// adiciona as matérias existentes no txt para o Arraylist criado acima (list disciplinas)					
					for (int i = 0; i < qtdMaterias; i++) {
						//disciplinas.add(linha.substring(indiceMateria, indiceMateria + 7));
						Disciplina disciplina = new Disciplina();
						disciplina.setNomeDisciplina(linha.substring(indiceMateria, indiceMateria + 7));
						disciplinasDoTxt.add(disciplina);
						indiceMateria += 7;
					}
					
					aluno.setDisciplinas(disciplinasDoTxt);
					
					// adicionando ao arraylist alunos o novo objeto de aluno
					alunos.add(aluno);

				}

				return alunos;

			} catch (Exception e) {
				Mensagens.imprimeMensagemErro("erro ao ler linhas do arquivo, verifique as linhas do arquivo");
				return null;
			}

		} else {
			return null;
		}

	}
	
	public static List<Aluno> verificaStatusDoArquivo() {
		
		List<Aluno> alunos = criaListaDeAlunos();
		
		if(alunos == null) {
			Mensagens.imprimeMensagem("Arquivo Vázio ou não encontrado, Leitura não foi possível");
			System.exit(0);
		}
		
		return alunos;
		
	}

}

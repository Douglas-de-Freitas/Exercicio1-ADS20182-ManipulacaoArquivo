package br.com.douglasdefreitas.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasdefreitas.modelo.Aluno;
import br.com.douglasdefreitas.util.Mensagens;

public class TrataDadosDoArquivo {

	private List<String> linhasDoArquivo = ManipulaArquivo.ler();

	public List<Aluno> TrataLinhas() {

		if (linhasDoArquivo != null) {

			try {

				List<Aluno> alunos = new ArrayList<>();

				for (String linha : linhasDoArquivo) {

					linha = linha.trim();

					int qtdMaterias = linha.substring(49).length() / 7;

					List<String> disciplinas = new ArrayList<>();

					int indiceMateria = 49;

					for (int i = 0; i < qtdMaterias; i++) {
						disciplinas.add(linha.substring(indiceMateria, indiceMateria + 7));
						indiceMateria += 7;
					}

					// Cada objeto aluno deve ser armazenado em uma collection (Arraylist)
					// denominada de alunos.

					Aluno aluno = new Aluno();
					aluno.setMatricula(Integer.parseInt(linha.substring(0, 4)));
					aluno.setNome(linha.substring(4, 29));
					aluno.setCpf(linha.substring(29, 40));
					aluno.setSexo(linha.substring(40, 41).charAt(0));
					aluno.setDataNascimento(linha.substring(41, 49));
					aluno.setDisciplinas(disciplinas);

					alunos.add(aluno);

				}

				return alunos;

			} catch (Exception e) {
				Mensagens.imprimeMensagemErro("erro ao ler linhas do arquivo, verifique as linhas do arquivo");
				return null;
			}

		} else {
			Mensagens.imprimeMensagem("não foi possível ler o arquivo");
			return null;
		}

	}

}

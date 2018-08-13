package br.com.douglasdefreitas.visao;

import java.util.List;

import javax.swing.JOptionPane;
import br.com.douglasdefreitas.controle.TrataDadosDoArquivo;
import br.com.douglasdefreitas.modelo.Aluno;
import br.com.douglasdefreitas.util.Mensagens;

public class Visao {

	public static void main(String[] args) {

		TrataDadosDoArquivo trataDadosDoArquivo = new TrataDadosDoArquivo();
		List<Aluno> alunos = trataDadosDoArquivo.TrataLinhas();
		boolean verifica = true;

		do {

			try {

				int sequencia = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Informe a sequencia (1-98) para seu relatório: "));

				if (sequencia >= 1 && sequencia <= 98) {

					int qtd0s = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Quantos zeros você deseja colocar antes da sequência?: ")); // -------

					verifica = false;

					Mensagens.imprimeMensagem("RELAÇÃO DE ALUNOS DE OUTROS PÓLOS DE ENSINO");
					Mensagens.imprimeMensagem("\nSeq | Mat | Nome | CPF | Sexo | Data de Nacimento\n");

					for (Aluno aluno : alunos) {
						Mensagens.imprimeLinhaRelatorio(sequencia, qtd0s, aluno);
						sequencia += 1;
					}

				} else {
					JOptionPane.showMessageDialog(null, "Fora do intervalo", "Atenção",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Confira o que foi digitado", "Atenção",
						JOptionPane.WARNING_MESSAGE);
			}

		} while (verifica);

	}

}

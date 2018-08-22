package br.com.douglasdefreitas.visao;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.douglasdefreitas.controle.TrataDadosDoArquivo;
import br.com.douglasdefreitas.modelo.Aluno;
import br.com.douglasdefreitas.modelo.Disciplina;

public class Visao {

	public static void main(String[] args) {
		
		boolean verifica = true;

		do {

			try {

				int sequencia = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Informe a sequencia (1-98) para seu relatório: "));

				if (sequencia >= 1 && sequencia <= 98) {

					int digitos = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Quantos de digitos você quer para sua sequência?: ")); // -------
					
					verifica = false;
					
					// verifica no controle se ele consegue ler o arquivo sem nenhum erro
					// Caso ele não consiga ler ele fecha antes e não retorna nada
					List<Aluno> alunos = TrataDadosDoArquivo.verificaStatusDoArquivo();
					
					// caso o controle tenha conseguido ler o arquivo sem nenhum erro o programa retorna
					// para a visão que conseguiu ler sem nenhum erro e que pode imprimir o relátorio
					Mensagens.imprimeMensagem("RELAÇÃO DE ALUNOS DE OUTROS PÓLOS DE ENSINO");
					Mensagens.imprimeMensagem("\nSeq. Matr. Nome\n");
					Mensagens.imprimeRelatorio(sequencia, digitos, alunos);
					
					System.out.println(Disciplina.getQuantidadeDeDisciplinas());
					
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

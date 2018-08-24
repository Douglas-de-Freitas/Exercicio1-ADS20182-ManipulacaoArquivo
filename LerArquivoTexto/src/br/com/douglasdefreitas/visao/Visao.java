package br.com.douglasdefreitas.visao;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.douglasdefreitas.controle.Controle;
import br.com.douglasdefreitas.modelo.Aluno;

public class Visao {

	public static void main(String[] args) {
		
		// Solicita ao controle para criar uma lista de alunos
		List<Aluno> alunos = Controle.criaERetornaListaDeAlunos();
		
		// controle retornou uma lista de alunos que deve ser verificada se é vazia ou não
		if(alunos == null) {
			Mensagens.imprimeMensagemErro("Erro de leitura do arquivo!\n");
			Mensagens.imprimeMensagem("Verifique a localização e o conteudo das linhas que estão no arquivo.");
			System.exit(0);
		}
		
		boolean verifica = true; // para verificar se para ou continua

		do {

			try {

				int sequencia = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Informe a sequencia (1-98) para seu relatório: "));

				if (sequencia >= 1 && sequencia <= 98) {

					int digitos = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Quantos de digitos você quer para sua sequência?: ")); // -------
					
					verifica = false; // este não deixa o programa continuar o proxímo loop

					// Imprime a lista que o controle entregou
					Mensagens.imprimeMensagem("RELAÇÃO DE ALUNOS DE OUTROS PÓLOS DE ENSINO");
					Mensagens.imprimeMensagem("\nSeq. Matr. Nome\n");
					Mensagens.imprimeMensagem(Controle.configuraImpressaoTextoDoRelatorio(sequencia, digitos, alunos));;
					
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

package br.com.douglasdefreitas.visao;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.douglasdefreitas.controle.TrataDadosDoArquivo;
import br.com.douglasdefreitas.modelo.Aluno;

public class Visao {

	public static void main(String[] args) {
		
		// verifica no controle se ele consegue ler o arquivo sem nenhum erro
		// Caso ele n�o consiga ler ele fecha antes e n�o retorna nada
		List<Aluno> alunos = TrataDadosDoArquivo.criaListaDeAlunos();
		if(alunos == null) {
			Mensagens.imprimeMensagemErro("Erro de leitura do arquivo!\n");
			Mensagens.imprimeMensagem("Verifique a localiza��o e o conteudo das linhas que est�o no arquivo.");
			System.exit(0);
		}
		
		boolean verifica = true;

		do {

			try {

				int sequencia = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Informe a sequencia (1-98) para seu relat�rio: "));

				if (sequencia >= 1 && sequencia <= 98) {

					int digitos = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Quantos de digitos voc� quer para sua sequ�ncia?: ")); // -------
					
					verifica = false;

					// caso o controle tenha conseguido ler o arquivo sem nenhum erro o programa retorna
					// para a vis�o que conseguiu ler sem nenhum erro e que pode imprimir o rel�torio
					Mensagens.imprimeMensagem("RELA��O DE ALUNOS DE OUTROS P�LOS DE ENSINO");
					Mensagens.imprimeMensagem("\nSeq. Matr. Nome\n");
					Mensagens.imprimeRelatorio(sequencia, digitos, alunos);
					
				} else {
					JOptionPane.showMessageDialog(null, "Fora do intervalo", "Aten��o",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Confira o que foi digitado", "Aten��o",
						JOptionPane.WARNING_MESSAGE);
			}

		} while (verifica);

	}

}

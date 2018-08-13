package br.com.douglasdefreitas.controle;

public class VerificaDatas {

	// Como TERCEIRO DESAFIO utilize no seu programa um recurso para que ele possa
	// analisar se uma data de nascimento, informada no arquivo, está ou não
	// correta. Caso
	// esteja incorreta, escreva um asterisco logo após a data, como está informado
	// no
	// exemplo do relatório. Note que a data está formatada, diferentemente como
	// está no
	// arquivo de leitura.

	public static boolean data(String data) {

		int dia = Integer.parseInt(data.substring(0, 2));
		int mes = Integer.parseInt(data.substring(2, 4));
		int ano = Integer.parseInt(data.substring(4));

		// verifica dia
		if (dia > 31 || dia <= 0)
			return false;

		// verifica mes
		if (mes > 12 || mes <= 0)
			return false;

		// verifica ano
		if (ano > 2018)
			return false;

		// verifica anos bisestos

		if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {
			// ano bisesto
			if (mes == 2 && dia > 28)
				return false;
		}

		if (mes == 1 && dia > 31)
			return false;
		if (mes == 2 && dia > 29)
			return false;
		if (mes == 3 && dia > 31)
			return false;
		if (mes == 4 && dia > 30)
			return false;
		if (mes == 5 && dia > 31)
			return false;
		if (mes == 6 && dia > 30)
			return false;
		if (mes == 7 && dia > 31)
			return false;
		if (mes == 8 && dia > 31)
			return false;
		if (mes == 9 && dia > 30)
			return false;
		if (mes == 10 && dia > 31)
			return false;
		if (mes == 11 && dia > 30)
			return false;
		if (mes == 12 && dia > 31)
			return false;

		return true;

	}

}

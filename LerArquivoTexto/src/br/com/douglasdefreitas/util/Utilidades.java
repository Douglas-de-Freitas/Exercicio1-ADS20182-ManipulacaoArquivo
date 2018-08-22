package br.com.douglasdefreitas.util;

import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;

import br.com.douglasdefreitas.modelo.Disciplina;
import br.com.douglasdefreitas.visao.Mensagens;

public class Utilidades {

	private static boolean validaCpf(String cpf) {

		try {

			// logica para verificar cpf retirada do site
			// https://laennder.com/como-e-feito-o-calculo-de-validacao-cpf/
			// 123.456.789-10 (CPF inválido)
			// 123.456.789-09 (CPF válido)

			String cpfString = cpf.toString();
			int[] pesos1 = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
			int[] pesos2 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
			int somatoria = 0;
			int resto;
			int primeiroDigitoVerificador;
			int segundoDigitoVerificador;

			for (int i = 0; i < 9; i++) {
				somatoria += Character.getNumericValue(cpfString.charAt(i)) * pesos1[i];
			}

			resto = somatoria % 11;
			primeiroDigitoVerificador = 11 - resto;

			if (primeiroDigitoVerificador > 9) {
				primeiroDigitoVerificador = 0;
			}

			cpfString = cpfString + Integer.toString(primeiroDigitoVerificador);

			somatoria = 0;

			for (int i = 0; i < 10; i++) {
				somatoria += Character.getNumericValue(cpfString.charAt(i)) * pesos2[i];
			}

			resto = somatoria % 11;

			segundoDigitoVerificador = 11 - resto;

			if (segundoDigitoVerificador > 9) {
				segundoDigitoVerificador = 0;
			}

			cpfString = cpf.toString();

			if (Character.getNumericValue(cpfString.charAt(9)) == primeiroDigitoVerificador
					&& Character.getNumericValue(cpfString.charAt(10)) == segundoDigitoVerificador) {
				return true; // retorna cpf verdadeiro
			} else {
				return false; // retorna cpf falso
			}

		} catch (Exception e) {

			// verificar esse catch depois

			Mensagens.imprimeMensagemErro("Erro entre um cpf valido");
			return false;
		}

	}

	private static boolean validaDatas(String data) {

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

	public static String configuraImpressaoDosDigitos(int nDigitos, int sequencia) {

		String texto = "";

		while (true) {

			if (String.valueOf(sequencia).length() > nDigitos) {
				return sequencia + " ";
			}

			if ((texto.length() + String.valueOf(sequencia).length()) == nDigitos) {
				texto += sequencia;
				break;
			} else {
				texto += "0";
			}
		}

		return texto + " ";

	}

	public static String configuraImpressaoDaMatricula(String matricula) {
		return matricula + " ";
	}

	public static String configuraImpressaoDoNome(String nome) {

		String[] nomeQuebrado = nome.split(" ");

		nome = "";

		for (int i = 0; i < nomeQuebrado.length; i++) {
			nomeQuebrado[i] = StringUtils.capitalize(nomeQuebrado[i]);
			nome += nomeQuebrado[i] + " ";
		}

		return nome = nome.trim() + " ";

	}

	public static String configuraImpressaoDoCpf(String cpf) {

		String texto = "";
		char[] cpfs = cpf.toCharArray();

		if (validaCpf(cpf)) {
			texto += "" + cpfs[0] + cpfs[1] + cpfs[2] + cpfs[3] + cpfs[4] + cpfs[5] + cpfs[6] + cpfs[7] + cpfs[8] + "."
					+ cpfs[9] + cpfs[10] + " ";
		} else {

			texto += "" + cpfs[0] + cpfs[1] + cpfs[2] + cpfs[3] + cpfs[4] + cpfs[5] + cpfs[6] + cpfs[7] + cpfs[8] + "."
					+ cpfs[9] + cpfs[10] + "* ";
		}

		return texto;

	}

	public static String configuraImpressaoDoSexo(char nSexo) {

		String texto = "";

		switch (nSexo) {
		case '1':
			texto += "Masc" + " ";
			break;
		case '2':
			texto += "Fem" + " ";
			break;
		default:
			break;
		}

		return texto;
	}

	public static String configuraImpressaoDaData(String data) {

		char[] dataChar = data.toCharArray();

		String texto = "";

		if (validaDatas(data)) {
			texto += "" + dataChar[0] + dataChar[1] + "/" + dataChar[2] + dataChar[3] + "/" + dataChar[4] + dataChar[5]
					+ dataChar[6] + dataChar[7] + " "; // adiciona // data
		} else {
			texto += "" + dataChar[0] + dataChar[1] + "/" + dataChar[2] + dataChar[3] + "/" + dataChar[4] + dataChar[5]
					+ dataChar[6] + dataChar[7] + "* "; // adiciona // data
		}

		return texto;

	}

	public static String configuraImpressaoDasDisciplinas(List<Disciplina> disciplinas) {

		String texto = "";

		if (disciplinas.isEmpty()) {
			return "DISCIPLINAS: Sem disciplinas";
		}
		
		for(int i = 0; i < disciplinas.size(); i++) {
			texto += disciplinas.get(i).getNomeDisciplina() + ", ";
		}
/*
		for (String disc : disciplinas) {
			texto += disc + ", ";
		}*/

		return "DISCIPLINAS: " + texto;

	}

}

package br.com.douglasdefreitas.controle;

import br.com.douglasdefreitas.util.Mensagens;

public class VerificaCpf {

	public static boolean validaCpf(String cpf) {

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

}

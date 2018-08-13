package br.com.douglasdefreitas.util;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasdefreitas.controle.VerificaCpf;
import br.com.douglasdefreitas.controle.VerificaDatas;
import br.com.douglasdefreitas.modelo.Aluno;

public class Mensagens {

	public static void imprimeMensagem(String msg) {
		System.out.println(msg);
	}

	public static void imprimeLinhaRelatorio(int seq, int qtd0s, Aluno aluno) {

		String linha = "";

		String zeros = "";

		for (int i = 0; i < qtd0s; i++) {
			zeros += "0";
		}

		linha += zeros + seq + " ";

		linha += "" + aluno.getMatricula() + " "; // add matricula

		// <--------- inicio trabalha upper -----------------

		String nome = aluno.getNome();
		nome = nome.toLowerCase();
		List<String> list = new ArrayList<>();
		int indice = 0;

		// cortando a string para facilitar a colocação da letra maiuscula em cada
		// inicial
		for (int i = 0; i < nome.length(); i++) {
			if (nome.charAt(i) == ' ') {
				String nomeCortado = nome.substring(indice, i);
				if (!nomeCortado.equals(" ")) {
					nomeCortado = nomeCortado.trim();
					String primeiraLetra = nomeCortado.substring(0, 1).toUpperCase();
					nomeCortado = primeiraLetra + nomeCortado.substring(1);
					list.add(nomeCortado);
				}
				indice = i;
			}
		}

		nome = "";

		for (String s : list) {
			nome = nome + s + " ";
		}

		linha += "" + nome.trim() + " ";

		// <--------- frim trabalha upper -----------------

		char[] cpf = aluno.getCpf().toCharArray(); // adiciona cpf

		if (VerificaCpf.validaCpf(aluno.getCpf())) {
			linha += "" + cpf[0] + cpf[1] + cpf[2] + cpf[3] + cpf[4] + cpf[5] + cpf[6] + cpf[7] + cpf[8] + "." + cpf[9]
					+ cpf[10] + " ";
		} else {

			linha += "" + cpf[0] + cpf[1] + cpf[2] + cpf[3] + cpf[4] + cpf[5] + cpf[6] + cpf[7] + cpf[8] + "." + cpf[9]
					+ cpf[10] + "* ";
		}

		switch (aluno.getSexo()) { // adiciona sexo
		case '1':
			linha += "Masc" + " ";
			break;
		case '2':
			linha += "Fem" + " ";
			break;
		default:
			break;
		}

		String dataNascimento = aluno.getDataNascimento();
		char[] dt = dataNascimento.toCharArray();

		if (VerificaDatas.data(dataNascimento)) {
			linha += "" + dt[0] + dt[1] + "/" + dt[2] + dt[3] + "/" + dt[4] + dt[5] + dt[6] + dt[7] + " "; // adiciona
																											// data
		} else {
			linha += "" + dt[0] + dt[1] + "/" + dt[2] + dt[3] + "/" + dt[4] + dt[5] + dt[6] + dt[7] + "* "; // adiciona
																											// data
		}

		System.out.println(linha);
		System.out.print("DISCIPLINAS: ");

		for (String disc : aluno.getDisciplinas()) {
			System.out.print(disc + ", ");
		}
		System.out.println("\n");
		
		// adicionar sem disciplinas <<<<

	}

	public static void imprimeMensagemErro(String msg) {
		System.err.println(msg);
	}

}

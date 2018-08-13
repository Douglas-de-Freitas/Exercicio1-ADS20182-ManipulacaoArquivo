package br.com.douglasdefreitas.controle;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ManipulaArquivo {

	private static final String LOCAL_ARQUIVO = "C:\\Users\\siddo\\Desktop\\alunos.txt"; // defina aqui o local do arquivo
	
	private static final Path path = Paths.get(LOCAL_ARQUIVO);

	
	public static List<String> ler() {
		
		// método que faz a leitura do aquivo utilizando NIO
		
		try {

			return Files.readAllLines(path, Charset.forName("UTF-8"));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static boolean Escrever(List<String> listaLinhas) {
		
		// método que faz a escrita no aquivo utilizando NIO

		try {

			Files.write(path, listaLinhas, Charset.forName("UTF-8"));
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}

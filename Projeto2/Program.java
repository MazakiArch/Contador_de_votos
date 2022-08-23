package Projeto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> candidato = new LinkedHashMap<>();

		String path = "C:\\Users\\Mazaki\\Documents\\temp\\ws-Java\\curso_programacao\\src\\in.txt";

		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			String line = bf.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer numero = Integer.parseInt(fields[1]);

				if (candidato.containsKey(nome)) {
					int votesSoFar = candidato.get(nome);
					candidato.put(nome, numero + votesSoFar);
				} else {
					candidato.put(nome, numero);
				}

				line = bf.readLine();
			}
		}

		for (String key : candidato.keySet()) {
			System.out.println(key + ": " + candidato.get(key));
		}
		sc.close();
	}

}

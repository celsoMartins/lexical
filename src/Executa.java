import java.io.IOException;

import br.com.celsomartins.lexical.analyser.WordAnalyser;


public class Executa {

	public static void main(String[] args) {
		WordAnalyser analyser = WordAnalyser.instance("casa");
		
		try {
			String[] listaDeRetorno = analyser.analyse();
			for (String string : listaDeRetorno) {
				System.out.println(string);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
package br.com.celsomartins.lexical.analyser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WordAnalyser {
	
	private String word = "";

	public WordAnalyser(String testWord) {
		this.word = testWord;
	}

	public static WordAnalyser instance(String testWord) {
		return new WordAnalyser(testWord);
	}

	public String[] analyse() throws IOException {
		File file = new File("resource/words.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = "";
		List<String> lineList = new ArrayList<String>();

		while ((line = reader.readLine()) != null) {
			if (word.equals(line) || checkChars(line)) {
				lineList.add(line);
			}
		}
		
		return (String[]) lineList.toArray(new String[0]);
	}

	private Boolean checkChars(String line) {
		
		WordComparator comparator = WordComparator.getComparator(word, line);
		Integer matchCount = comparator.compare();
		
		System.out.println(new DecimalFormat("#0.00").format(
				matchCount.doubleValue() / word.length() * 100) + "% match");
		
		return ((matchCount.doubleValue() / word.length()) > 0.5);
	}
}
package br.com.celsomartins.lexical.analyser;

/**
 * Does the comparison between two words
 * @author Celso Martins
 * @since 1.5
 */
public class CharComparator {

	private String wordOne;
	private String wordTwo;

	public static CharComparator getComparator(String wordOne, String wordTwo) {
		return new CharComparator(wordOne, wordTwo);
	}

	private CharComparator(String wordOne, String wordTwo) {
		this.wordOne = wordOne;
		this.wordTwo = wordTwo;
	}

	/**
	 * Compare the two words given as parameter
	 * Breaks the words into a char array e compares each one
	 * if they differ, the method increments wordTwo count if wordTwo is bigger than wordOne
	 * and vice versa. 
	 * @return the total char match
	 */
	public Integer compare() {

		char[] wordOneChars = wordOne.toCharArray();
		char[] wordTwoChars = wordTwo.toCharArray();

		Integer countInWordTwo = 0, countWordOne = 0;

		Integer matchCount = 0;

		while (countWordOne < wordOne.length() && countInWordTwo < wordTwo.length()) {

			if (wordTwoChars[countInWordTwo] == wordOneChars[countWordOne]) {
				matchCount++;
				countInWordTwo++; countWordOne++;

			} else if (wordOne.length() == wordTwo.length()) {
				countInWordTwo++; countWordOne++;
				
			} else if (wordTwo.length() > wordOne.length()) {
				countInWordTwo++;

			} else if (wordTwo.length() < wordOne.length()) {
				countWordOne++;
			}
		}
		return matchCount;
	}
}
package br.com.celsomartins.lexical.tests;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import br.com.celsomartins.lexical.analyser.WordAnalyser;

public class WordAnalyserShould {
	
	@Test
	public void giveOptionsWithOneLetterMore() {
		String palavraDeTeste = "uibuntu";
		testAnalyse(palavraDeTeste);
	}

	@Test
	public void giveOptionsWithOneLetterLess() {
		String palavraDeTeste = "uuntu";
		testAnalyse(palavraDeTeste);
	}
	
	@Test
	public void giveOptionsWithOneDifferenceWithTheSameLength() {
		String palavraDeTeste = "uvuntu";
		testAnalyse(palavraDeTeste);
	}
	
	private void testAnalyse(String palavraDeTeste) {
		try {
			WordAnalyser analyser = WordAnalyser.instance(palavraDeTeste);
			String[] retorno = analyser.analyse();
			
			Assert.assertEquals("ubuntu", retorno[0]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
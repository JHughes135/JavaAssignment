package com.languageanalyser;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class Sentence{
	
	
	public ArrayList<String> sentence;
	
	public String line;
	public BreakIterator iterator;
	public String part1;
	public String part2;
	
	
	public Sentence(String line)
	{
		this.line = line;
		
		String[] sSentence = line.split("(?<=[a-z])\\.\\s+");
		
		for (String sentence : sSentence) {
			
			System.out.println(sentence);
		}
	}
	
	public int noOfWords(String lineToSent)
	{
		
		int noOfWords = 0;
		
		String[] sentences = lineToSent.split(Pattern.quote("."), 2);
		
		String[] words = sentences[0].split("//s");
		
		for(int i=0; i<words.length; i++) {
			
			
			System.out.printf("%s \n", words[i]);
			noOfWords++;
		}
		
		return noOfWords;
		
	}//end of sentenceLength

}

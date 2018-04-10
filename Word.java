package com.languageanalyser;


import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class Word 
{
	public String sentence;
	public String[] words;
	public static float noOfWords;
	public static float noOfLetters;
	public static float avgWordLength;
	
	public Word(String sentence)
	{
		this.sentence = sentence;
		
		words = sentence.split(" ");
		
		for (String word : words)
		{
			noOfWords ++;
			
			noOfLetters += word.length();
			
				
			
		}
		
		avgWordLength = noOfLetters/noOfWords;
		
		
	}

}
